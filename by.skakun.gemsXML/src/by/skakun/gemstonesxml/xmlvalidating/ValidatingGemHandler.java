package by.skakun.gemstonesxml.xmlvalidating;

import java.io.IOException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ValidatingGemHandler extends DefaultHandler {

    private Logger logger = Logger.getLogger(ValidatingGemHandler.class.getName());

    public ValidatingGemHandler(String log) throws IOException {
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }
    @Override
    public void warning(SAXParseException ex){
        logger.warn(getLineAddress(ex) + "-" + ex.getMessage());
    }
    @Override
    public void error(SAXParseException ex){
        logger.error(getLineAddress(ex) + "-" + ex.getMessage());
    }
    @Override
    public void fatalError(SAXParseException ex){
        logger.fatal(getLineAddress(ex) + "-" + ex.getMessage());
    }
    public String getLineAddress(SAXParseException ex){
        return ex.getLineNumber() + " : " + ex.getColumnNumber();
    }
    

}
