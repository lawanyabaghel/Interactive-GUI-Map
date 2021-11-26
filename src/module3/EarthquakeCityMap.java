package module3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import processing.core.PApplet;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

public class EarthquakeCityMap extends PApplet {

	private static final long serialVersionUID = 1L;
	private static final boolean offline = false;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	
	public void setup() {
		size(950, 600, OPENGL);

		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
			
	    List<Marker> markers = new ArrayList<Marker>();
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    //create a new SimplePointMarker for each PointFeature in earthquakes.  
	    for(PointFeature pf: earthquakes) {
	    	SimplePointMarker sp= createMarker(pf);
	    	markers.add(sp);
	    }
	    map.addMarkers(markers);
	}
		
	
	private SimplePointMarker createMarker(PointFeature feature){ 
		
	    // Create a new SimplePointMarker at the location given by the PointFeature
	    SimplePointMarker marker = new SimplePointMarker(feature.getLocation());
		
	    Object magObj = feature.getProperty("magnitude");
	    float mag = Float.parseFloat(magObj.toString());
		
	    int yellow = color(255, 255, 0);
	    int red=color(255,0,0);
	    int blue=color(0,0,255);
	    if(mag<THRESHOLD_LIGHT) marker.setColor(blue);
	    else if(mag>=THRESHOLD_LIGHT && mag <=THRESHOLD_MODERATE) marker.setColor(yellow);
	    else marker.setColor(red);
	    return marker;
	}
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}

        private void addKey() {	
		fill(255,254,245);
		rect(20,50,150,250);
		fill(255,0,0);
		ellipse(40,100,15,15);
		fill(255, 255, 0);
		ellipse(40,150,10,10);
		fill(0,0,255);
		ellipse(40,200,7,7);
		fill(0, 0, 0);
		text("Earthquake key",50,75);
		text(">5.0 magnitude",50,105);
		text(">=4.0 and <=5.0",50,155);
		text("magnitude",50,165);
		text("<4.0 magnitude",50,205);
		
	}
}
