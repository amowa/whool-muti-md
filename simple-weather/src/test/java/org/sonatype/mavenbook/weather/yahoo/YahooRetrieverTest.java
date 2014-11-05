package org.sonatype.mavenbook.weather.yahoo;

import java.io.InputStream;

import org.sonatype.mavenbook.weather.YahooParser;
import org.sonatype.mavenbook.weather.YahooRetriever;
import org.sonatype.mavenbook.weather.model.Weather;

import junit.framework.TestCase;

public class YahooRetrieverTest extends TestCase {
	
	//YahooRetriever
	public void testRetriever() throws Exception {
		YahooRetriever ret = new YahooRetriever();
		InputStream nyData = ret.retrieve("10002");
		
		Weather weather = new YahooParser().parse( "10002", nyData );
		
		assertEquals( "New York", weather.getLocation().getCity() );
		assertEquals( "NY", weather.getLocation().getRegion() );
		assertEquals( "US", weather.getLocation().getCountry() );
		//assertEquals( "39", weather.getCondition().getTemp() );
		//assertEquals( "Fair", weather.getCondition().getText() );
		//assertEquals( "39", weather.getWind().getChill() );
		//assertEquals( "67", weather.getAtmosphere().getHumidity() );
	}
}
