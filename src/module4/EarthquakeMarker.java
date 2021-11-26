package module4;

import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PGraphics;

public abstract class EarthquakeMarker extends SimplePointMarker{
	protected boolean isOnLand;
  	// Magnitude	
	public static final float THRESHOLD_MODERATE = 5;
	public static final float THRESHOLD_LIGHT = 4;

	// Depth
	public static final float THRESHOLD_INTERMEDIATE = 70;
	public static final float THRESHOLD_DEEP = 300;
	
	public abstract void drawEarthquake(PGraphics pg, float x, float y);
		
	
	// constructor
	public EarthquakeMarker (PointFeature feature) {
		super(feature.getLocation());
		java.util.HashMap<String, Object> properties = feature.getProperties();
		float magnitude = Float.parseFloat(properties.get("magnitude").toString());
		properties.put("radius", 2*magnitude );
		setProperties(properties);
		this.radius = 1.75f*getMagnitude();
	}
	
	public void draw(PGraphics pg, float x, float y) {
		pg.pushStyle();
		colorDetermine(pg);
		drawEarthquake(pg, x, y);
		pg.popStyle();
		
	}
	
	private void colorDetermine(PGraphics pg) {
		if(getDepth()<THRESHOLD_INTERMEDIATE) {
			pg.fill(255,0,0);
		}else if(getDepth()>=THRESHOLD_INTERMEDIATE && getDepth()<THRESHOLD_DEEP) {
			pg.fill(255,255,0);
		}else pg.fill(0,0,255);
	}
	
	
	public float getMagnitude() {
		return Float.parseFloat(getProperty("magnitude").toString());
	}
	
	public float getDepth() {
		return Float.parseFloat(getProperty("depth").toString());	
	}
	
	public String getTitle() {
		return (String) getProperty("title");	
		
	}
	
	public float getRadius() {
		return Float.parseFloat(getProperty("radius").toString());
	}
	
	public boolean isOnLand()
	{
		return isOnLand;
	}
	
	
}
