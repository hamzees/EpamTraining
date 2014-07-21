package by.skakun.tunnel.entity;

import by.skakun.tunnel.exception.TrainException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import org.apache.log4j.Logger;

public class TunnelPool<T> extends ArrayList<Tunnel> {

    private static final Logger LOG = Logger.getLogger(TunnelPool.class);
    private int numberOfTunnels;
    private Semaphore semaphore;

    public TunnelPool() {
        numberOfTunnels = 2;
        semaphore = new Semaphore(numberOfTunnels); 
        for (int i = 0; i < numberOfTunnels; i++) {
            this.add(new Tunnel(i + 1));
        }
    }

    public Tunnel getTunnel(int maxWaitMillis, String name) throws TrainException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, MILLISECONDS)) {
                Tunnel tunnel = this.get(0);
                this.remove(0);
                return tunnel;
            } else {
                LOG.info("Превышено время ожидания поезда №" + name + ". Пробуем другой тоннель.");
                this.getSemaphore().tryAcquire();
                Tunnel tunnel = this.getTunnel(1000, name);
                return tunnel;
            }
        } catch (InterruptedException ex) {
            LOG.info("Ошибка работы с потоками:" + ex);
        }

        throw new TrainException(": превышено время ожидания");

    }

    public void returnTunnel(Tunnel tunnel) {
        this.add(tunnel);
        semaphore.release();
    }

    public synchronized void setTunnel(Tunnel tunnel) {
        this.add(tunnel);
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
