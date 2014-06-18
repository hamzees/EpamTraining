/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.skakun.gemstones.builder;

import by.skakun.gemstones.entities.Gem;
import by.skakun.gemstones.entities.SemiPreciousGem;
import by.skakun.gemstones.necklace.Necklace;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemsBaseBuilder and builds a necklace from the semi
 * precious gemstones.
 *
 * @author skakun
 */
public class SemiPreciousGemsBuilder extends GemsBaseBuilder {

    private static final Logger LOG = Logger.getLogger(SemiPreciousGemsBuilder.class);

    /**
     * constructor without parameters
     */
    public SemiPreciousGemsBuilder() {
        LOG.info("\nНОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из полудрагоценных камней.");
    }

    @Override
    public void buildGems() {
        LOG.trace("Отбираем камни для ожерелья");
        ArrayList<Gem> rpGems = new ArrayList<Gem>();
        rpGems.add(new SemiPreciousGem("Здоровье", 1500, 6, 1, "Розовый", "Агат"));
        rpGems.add(new SemiPreciousGem("Мудрость", 1400, 4, 3, "Синий", "Опал"));
        rpGems.add(new SemiPreciousGem("Лаконичность", 1300, 2, 5, "Фиолетовый", "Аметист"));
        getNecklace().setGems(rpGems);
    }

}
