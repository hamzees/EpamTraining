package by.skakun.tunnel.main;

import by.skakun.tunnel.parser.RailwayStarter;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args){
        new DOMConfigurator().doConfigure("src/properties/log4j.xml", LogManager.getLoggerRepository());
        LOG.info("Начало движения поездов.");
        try {
            RailwayStarter.startRailway();
        } catch (InterruptedException ex) {
            LOG.info("Работа потока была прервана: " + ex);
        }
        LOG.info("Конец движения поездов.");
    }
}
