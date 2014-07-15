package by.skakun.tunnel.entity;

import by.skakun.tunnel.exception.TrainException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

import org.apache.log4j.Logger;

public class Train extends Thread {

    private String name;
    private int throughTunnelTime;
    private Direction direction;
    private TunnelPool<Tunnel> tunnelPool;
    private int tunnelNum;
    private Tunnel tunnel;
    private static Logger LOG = Logger.getLogger(Train.class);
    private boolean reading = false; 

    public Train(String name, int throwTunnelTime, Direction direction, TunnelPool<Tunnel> tunnelPool) {
        super();
        this.name = name;
        this.throughTunnelTime = throwTunnelTime;
        this.direction = direction;
        this.tunnelPool = tunnelPool;
    }

    @Override
    public void run() {
        try {
            //tunnelPool.getSemaphore().tryAcquire();
            Tunnel tunnel = tunnelPool.getTunnel(300, this.getTrainName());
            tunnel.throughTunnel(this.getTrainName(), this.throughTunnelTime);
            LOG.info(this.trainThroughTunnelString(tunnel.getTunnelNum()));
            Thread.sleep(this.getThrowTunnelTime());
            tunnel.freeTunnel(this.getTrainName(), 4);
            tunnelPool.add(tunnel);
        } catch (InterruptedException | TrainException e) {
            LOG.error("Поезд №" + this.getTrainName() + e.getMessage());
        } finally {
           tunnelPool.getSemaphore().release();
        //    tunnelPool.returnTunnel(tunnel);

        }
    }

    public String trainThroughTunnelString(int tunnelNum) {
        return "Поезд " + name + " едет по тоннелю #" + tunnelNum +" в направлении " + direction + " в течении " + throughTunnelTime
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
