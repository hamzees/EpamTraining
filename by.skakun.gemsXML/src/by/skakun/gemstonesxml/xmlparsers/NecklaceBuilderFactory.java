package by.skakun.gemstonesxml.xmlparsers;


public class NecklaceBuilderFactory {
    private enum TypeParser {
        SAX,STAX,DOM;
    }
    public AbstractNecklaceBuilder createNecklaceBuilder(String typeParser){
        TypeParser type=TypeParser.valueOf(typeParser.toUpperCase());
        switch(type) {
            case DOM:
                return new NecklaceDOMBuilder();
            case SAX:
               return new NecklaceSAXBuilder();
            case STAX:
               return new NecklaceSTAXBuilder();   
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
