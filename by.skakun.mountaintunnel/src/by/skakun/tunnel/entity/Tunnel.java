package by.skakun.tunnel.entity;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class Tunnel {

    private int tunnelNum;

    private static Logger LOG = Logger.getLogger(Tunnel.class);

    public Tunnel(int tunnelNum) {
        this.tunnelNum = tunnelNum;
    }

    public void throughTunnel(String trainName, int timeThroughTunnel) throws InterruptedException {
        LOG.info("Поезд " + trainName + " к тоннелю №" + tunnelNum);
    }

    public void freeTunnel(String trainName, int timeThroughTunnel) throws InterruptedException {
       Thread.sleep(timeThroughTunnel * 100);

        LOG.info("Поезд " + trainName + " освобождает тоннель #" + tunnelNum);
    }

    public int getTunnelNum() {
        return tunnelNum;
    }

    public void setTunnelNum(int tunnelNum) {
        this.tunnelNum = tunnelNum;
    }

    
}
