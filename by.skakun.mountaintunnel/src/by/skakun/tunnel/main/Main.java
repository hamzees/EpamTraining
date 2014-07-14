package by.skakun.tunnel.main;

import by.skakun.tunnel.entity.Railway;
import by.skakun.tunnel.entity.Train;
import by.skakun.tunnel.entity.Tunnel;
import by.skakun.tunnel.thread.TrainParser;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    private static Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        new DOMConfigurator().doConfigure("src/properties/log4j.xml", LogManager.getLoggerRepository());


        LOG.info("Начало движения поездов");

        Tunnel<Railway> tunnel = new Tunnel<Railway>();
        List<Train> trains = TrainParser.getData(
                "src/resources/trains.xml", tunnel);

        for (Train train : trains) {
            train.start();
        }
        for (Train train : trains) {
            train.join();
        } 
        LOG.info("Конец движения поездов");
    }
}
