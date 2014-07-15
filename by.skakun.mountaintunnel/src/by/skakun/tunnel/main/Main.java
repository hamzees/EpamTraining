package by.skakun.tunnel.main;

import by.skakun.tunnel.entity.Train;
import by.skakun.tunnel.entity.TunnelPool;
import by.skakun.tunnel.parser.TrainParser;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {

    private static Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        new DOMConfigurator().doConfigure("src/properties/log4j.xml", LogManager.getLoggerRepository());


        LOG.info("Начало движения поездов.");

        TunnelPool<Train> tunnelPool = new TunnelPool<Train>();
        List<Train> trains = TrainParser.getData(
                "src/resources/trains.xml", tunnelPool);

        trains.stream().forEach((train) -> {
            train.start();
        });
        
        for (Train train : trains) {
            train.join();
        } 
        LOG.info("Конец движения поездов.");
    }
}
