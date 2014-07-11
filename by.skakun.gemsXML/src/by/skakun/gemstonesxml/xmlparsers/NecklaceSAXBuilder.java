/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.skakun.gemstonesxml.xmlparsers;

import by.skakun.gemstonesxml.entity.Gem;
import java.io.IOException;
import java.util.Set;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class NecklaceSAXBuilder extends AbstractNecklaceBuilder{
private Set<Gem> gems;
private GemSAXHandler gh;
private XMLReader reader;

    public NecklaceSAXBuilder() {
        System.out.println("SAX-парсер.");
        gh = new GemSAXHandler();
    try {
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(gh);
    } catch (SAXException ex) {
        System.out.println("Ошибка SAX-парсера " + ex);
    }
    }
@Override
public Set<Gem> getGems(){
    return gems;
}
    @Override
    public void buildSetGems(String fileName) {
    try {
        reader.parse("src/resources/necklace.xml");
    } catch (SAXException ex) {
        System.out.println("Ошибка SAX-парсера " + ex);
    } catch (IOException ex) {
        System.out.println("Ошибка I/O потока " + ex);
    }
    gems=gh.getGems();
    collectNecklace();
    }
    private void collectNecklace() {
        gems.stream().forEach((emp) -> {
            System.out.println(emp);
        });
    }
    
}
