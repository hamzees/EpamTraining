package by.skakun.gemstones.builder;

import by.skakun.gemstones.entity.ArtificialGem;
import by.skakun.gemstones.entity.Gem;
import by.skakun.gemstones.exception.GemLogicException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * This class extends from GemBaseBuilder and builds a necklace from the
 artificial precious gemstones.
 *
 * @author skakun
 */
public class ArtificialGemBuilder extends GemBaseBuilder {

    private static final Logger LOG = Logger.getLogger(SemiPreciousGemBuilder.class);

    /**
     * constructor without parameters
     */
    public ArtificialGemBuilder() {
        LOG.info("НОВОЕ ОЖЕРЕЛЬЕ");
    }

    @Override
    public void buildType() {
        getNecklace().setType("Это ожерелье из искусственных драгоценных камней.");
    }

    @Override
    public void buildGems() {
        try {
            LOG.info("Отбираем камни для ожерелья");
            ArrayList<Gem> rpGems = new ArrayList<>();
            rpGems.add(new ArtificialGem(10, 5, "Круглая", 2500, 2, 1, "Розовый", "Бриллиант"));
            rpGems.add(new ArtificialGem(5, 4, "Ступенчатая", 2400, 2, 3, "Синий", "Сапфир"));
            rpGems.add(new ArtificialGem(3, 4, "Капельная", 2300, 2, 5, "Красный", "Рубин"));
            getNecklace().setGems(rpGems);
        } catch (GemLogicException ex) {
            getNecklace().setGems(null);
            LOG.warn("Ошибка исходных данных при создании ожерелья. " + ex);
        }
    }

}
