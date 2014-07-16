package by.skakun.tunnel.entity;

import by.skakun.tunnel.exception.TrainException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import java.util.logging.Level;
import org.apache.log4j.Logger;

public class TunnelPool<T> extends ArrayList<Tunnel> {

    private static Logger LOG = Logger.getLogger(TunnelPool.class);
    private int numberOfTunnels;
    private Semaphore semaphore;

    public TunnelPool() { // добавляем два тоннеля
        numberOfTunnels = 2; //количество 
        semaphore = new Semaphore(numberOfTunnels); //семафор с двумя потоками
        for (int i = 0; i < numberOfTunnels; i++) {
            this.add(new Tunnel(i + 1)); // очередь из каналов
        }
    }

    public synchronized Tunnel getTunnel(int maxWaitMillis, String name) throws TrainException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, MILLISECONDS)) {
                Tunnel tunnel = this.get(0);
                this.remove(0);
                return tunnel;
                     } else {
                 LOG.info("Превышено время ожидания поезда №" + name + ". Пробуем другой тоннель.");
                  this.getSemaphore().tryAcquire();
                 Tunnel tunnel = this.getTunnel(300, name);
                 /*this.add(tunnel);
                 this.remove(0); */ 
                 return tunnel; 
            }
        } catch (InterruptedException ex) {

        }
         //   finally {
            /*  if(this.size()>1){
         this.remove(1);
         } */
        //   }
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

    public int changeTunnel(Tunnel tunnel, int tunnelNum) {
        return Math.abs(tunnel.getTunnelNum() - 1);
    }

}
