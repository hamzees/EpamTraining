/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.skakun.gemstones.builder;

import by.skakun.gemstones.entity.Gem;
import by.skakun.gemstones.entity.SemiPreciousGem;
import by.skakun.gemstones.exception.GemLogicException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemBaseBuilder and builds a necklace from the semi
 precious gemstones.
 *
 * @author skakun
 */
public class SemiPreciousGemBuilder extends GemBaseBuilder {

    private static final Logger LOG = Logger.getLogger(SemiPreciousGemBuilder.class);

    /**
     * constructor without parameters
     */
    public SemiPreciousGemBuilder() {
        LOG.info("НОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из полудрагоценных камней.");
    }

    @Override
    public void buildGems() {
        try {
            LOG.info("Отбираем камни для ожерелья");
            ArrayList<Gem> rpGems = new ArrayList<>();
            rpGems.add(new SemiPreciousGem("Здоровье", 1500, 6, 1, "Розовый", "Агат"));
            rpGems.add(new SemiPreciousGem("Мудрость", 1400, 4, 7, "Синий", "Опал"));
            rpGems.add(new SemiPreciousGem("Лаконичность", 1300, 2, 5, "Фиолетовый", "Аметист"));
            getNecklace().setGems(rpGems);
        } catch (GemLogicException ex) {
            getNecklace().setGems(null);
            LOG.warn("Ошибка исходных данных при создании ожерелья. " + ex);
        }
    }

}
