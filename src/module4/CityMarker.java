package module4;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PGraphics;

public class CityMarker extends SimplePointMarker {
	
	public static final int TRI_SIZE = 5;  
	public CityMarker(Location location) {
		super(location);
	}
	
	public CityMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	}
	
	
	public void draw(PGraphics pg, float x, float y) {
		pg.pushStyle();
		pg.fill(255,0,0);
		pg.triangle(x,y,x-5,y+10,x+5,y+10);
		// Restore previous drawing style
		pg.popStyle();
	}
	
	
	public String getCity()
	{
		return getStringProperty("name");
	}
	
	public String getCountry()
	{
		return getStringProperty("country");
	}
	
	public float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}
	
}
