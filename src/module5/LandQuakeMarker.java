package module5;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;
public class LandQuakeMarker extends EarthquakeMarker {
	
	public LandQuakeMarker(PointFeature quake) {
		// calling EarthquakeMarker constructor
		super(quake);
		isOnLand = true;
	}
        // Draw the earthquake as an ellipse
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		pg.ellipse(x, y, 2*radius, 2*radius);
		
	}
	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}
}
