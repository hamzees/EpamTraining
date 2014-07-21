package by.skakun.tunnel.entity;

import by.skakun.tunnel.exception.TrainException;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.log4j.Logger;

public class Train extends Thread {

    private static final Logger LOG = Logger.getLogger(Train.class);

    private String name;
    private int throughTunnelTime;
    private DirectionEnum direction;
    private TunnelPool<Tunnel> tunnelPool;
    ReentrantLock lock = new ReentrantLock();

    public Train(String name, int throwTunnelTime, DirectionEnum direction, TunnelPool<Tunnel> tunnelPool) {
        super();
        this.name = name;
        this.throughTunnelTime = throwTunnelTime;
        this.direction = direction;
        this.tunnelPool = tunnelPool;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            Tunnel tunnel = tunnelPool.getTunnel(1000, this.getTrainName());
            tunnel.throughTunnel(this.getTrainName(), this.throughTunnelTime);
            LOG.info(this.trainThroughTunnelString(tunnel.getTunnelNum()));
            Thread.sleep(this.getThrowTunnelTime());
            tunnel.freeTunnel(this.getTrainName(), 4);
            tunnelPool.add(tunnel);
        } catch (InterruptedException | TrainException e) {
            LOG.error("Поезд №" + this.getTrainName() + e.getMessage());
        } finally {
            tunnelPool.getSemaphore().release();
            lock.unlock();
        }
    }

    public String trainThroughTunnelString(int tunnelNum) {
        return "Поезд " + name + " едет по тоннелю #" + tunnelNum + " в направлении " + direction + " в течении " + throughTunnelTime
                + " секунд.";
    }

    public String getTrainName() {
        return name;
    }

    public void setTrainName(String name) {
        this.name = name;
    }

    public int getThrowTunnelTime() {
        return throughTunnelTime;
    }

    public void setThrowTunnelTime(int throwTunnelTime) {
        this.throughTunnelTime = throwTunnelTime;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }
}
