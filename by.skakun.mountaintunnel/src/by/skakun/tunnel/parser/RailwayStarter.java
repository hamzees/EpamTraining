package by.skakun.tunnel.parser;

import by.skakun.tunnel.entity.Train;
import by.skakun.tunnel.entity.TunnelPool;
import java.util.List;
import org.apache.log4j.Logger;

public class RailwayStarter {

    private static final Logger LOG = Logger.getLogger(RailwayStarter.class);
    private static final String PATH = ConfigurationManager.getProperty("train.path");

    public static void startRailway() throws InterruptedException {
        TunnelPool<Train> tunnelPool = new TunnelPool<>();
        List<Train> trains = TrainParser.getData(
                PATH, tunnelPool);

        trains.stream().forEach((train) -> {
            train.start();
        });

        for (Train train : trains) {
                train.join();
        }
    }
}

