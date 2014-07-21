package by.skakun.tunnel.entity;

import org.apache.log4j.Logger;

public class Tunnel {
    private static final Logger LOG = Logger.getLogger(Tunnel.class);
    private int tunnelNum;


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
