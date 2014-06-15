/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.com.jewels.builder;

import by.epam.com.jewels.entities.Gems;
import by.epam.com.jewels.entities.SemiPreciousGems;
import by.epam.com.jewels.necklace.Necklace;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemsBaseBuilder and builds a necklace from the semi
 * precious gemstones.
 *
 * @author apple
 */
public class SemiPreciousGemsBuilder extends GemsBaseBuilder {

    private static final Logger log = Logger.getLogger(SemiPreciousGemsBuilder.class);

    /**
     * constructor without parameters
     */
    public SemiPreciousGemsBuilder() {
        log.info("\nНОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из полудрагоценных камней.");
    }

    @Override
    public void buildGems() {
        log.trace("Отбираем камни для ожерелья");
        ArrayList<Gems> rpGems = new ArrayList<Gems>();
        rpGems.add(new SemiPreciousGems("Здоровье", 1500, 6, 1, "Розовый", "Агат"));
        rpGems.add(new SemiPreciousGems("Мудрость", 1400, 4, 3, "Синий", "Опал"));
        rpGems.add(new SemiPreciousGems("Лаконичность", 1300, 2, 5, "Фиолетовый", "Аметист"));
        getNecklace().setGems(rpGems);
    }

}
