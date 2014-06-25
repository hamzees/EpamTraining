package by.skakun.gemstones.builder;

import by.skakun.gemstones.entity.Gem;
import by.skakun.gemstones.entity.RealPreciousGem;
import by.skakun.gemstones.exception.GemLogicException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemBaseBuilder and builds a necklace from the real
 precious gemstones.
 *
 * @author skakun
 */
public class RealPreciousGemBuilder extends GemBaseBuilder {

    private static final Logger LOG = Logger.getLogger(RealPreciousGemBuilder.class.getName());

    /**
     * constructor without parameters
     */
    public RealPreciousGemBuilder() {
        LOG.info("НОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из натуральных драгоценных камней.");
    }

    @Override
    public void buildGems() {   
        try {
            LOG.info("Отбираем камни для ожерелья");
            ArrayList<Gem> rpGems = new ArrayList<>();
            rpGems.add(new RealPreciousGem("Германия", 4, "Круглая", 500, 2, 1, "Розовый", "Бриллиант"));
            rpGems.add(new RealPreciousGem("Италия", 4, "Ступенчатая", 400, 2, 3, "Синий", "Сапфир"));
            rpGems.add(new RealPreciousGem("Россия", 4, "Капельная", 33, 2, 5, "Красный", "Рубин"));
            getNecklace().setGems(rpGems);
        } catch (GemLogicException ex) {
            getNecklace().setGems(null);
            LOG.warn("Ошибка исходных данных при создании ожерелья. " + ex);       
        }

    }

}
