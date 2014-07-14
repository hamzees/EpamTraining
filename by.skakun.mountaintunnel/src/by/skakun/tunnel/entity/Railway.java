package by.skakun.tunnel.entity;

import org.apache.log4j.Logger;

public class Railway {

    private int railway = 1;
    private int railwayNum;

    private static Logger LOG = Logger.getLogger(Railway.class);

    public Railway(int railwayNum) {
        this.railwayNum = railwayNum;
    }

    public void holdRailway(String trainName) {
        railway--;
        if (railway < 0) {
            System.out.println("Поезд " + trainName + " к тоннелю #" + railwayNum);
        }
        System.out.println("Поезд " + trainName + " к тоннелю  #" + railwayNum);
    }

    public void clearRailway(String trainName) {
        railway++;
        if (railway > 1) {
            System.out.println(trainName + " free one more tunnel №" + railwayNum);
        }
        System.out.println("Поезд №" + trainName + " освобождает тоннель №" + railwayNum);
    }
}
