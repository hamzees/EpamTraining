package by.skakun.tunnel.parser;

import by.skakun.tunnel.entity.Direction;
import by.skakun.tunnel.entity.Train;
import by.skakun.tunnel.entity.TunnelPool;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class TrainParser {
	private static Logger LOG = Logger.getLogger(TrainParser.class);
	public static final String DATA = "data";

	public static List<Train> getData(String dataFileName, final TunnelPool tunnel) {

		final List<Train> trains = new ArrayList<Train>();
               // final List<Train> trainsN = new ArrayList<Train>();


		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				boolean isID = false;
				boolean isDirection = false;
				boolean isTime = false;
                                boolean isTunnel = false;
				String id = "";
				int direction = 0;
				int time = 0;
                                int tunnelNum = 0;

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if (qName.equalsIgnoreCase("id")) {
						isID = true;
					}

					if (qName.equalsIgnoreCase("waitingTime")) {
						isTime = true;
					}

					if (qName.equalsIgnoreCase("direction")) {
						isDirection = true;
					}
                                        if (qName.equalsIgnoreCase("tunnel")) {
						isTunnel = true;
					}
				}

				@Override
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (qName.equalsIgnoreCase("train")) {
						Train train = new Train(id, time,
								direction == 0 ? Direction.SOUTH
										: Direction.NORTH, tunnel);
						trains.add(train);
					}

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					if (isID) {
						id = new String(ch, start, length);
						isID = false;
					}

					if (isDirection) {
						direction = Integer.parseInt(new String(ch, start,
								length));
						isDirection = false;
					}

					if (isTime) {
						time = Integer.parseInt(new String(ch, start, length));
						isTime = false;
					}
                                        if (isTunnel) {
                                            tunnelNum = Integer.parseInt(new String(ch, start, length));
                                            isTunnel = false;                                           
                                        }
                                       
				}

			};
			saxParser.parse(dataFileName, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return trains;
	}
}
