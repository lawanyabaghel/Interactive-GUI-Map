# Interactive-GUI-Map

The project consists of a map application that reads earthquake data from a live feed in realtime and displays it on the GUI, with the markers organized on the basis of magnitude and depth.The map also showcases the cities in the world map using City Markers. 

CUSTOM MARKERS
----------
The geo-positioned markers are customised with different shapes and colors using the Processing Library to denote the earthquakes of different magnitudes and depths on the map. A List of country markers(through their Point Features) is used to decide whether an earthquake occured on land or not. Different custom Markers are used to denote the earthquakes that occured on land(circle) and in water(square) respectively. A list of countries with the total number of respective earthquakes is also obtained.

EVENT HANDLERS
----------
The application is made interactive by the addition of event handlers for mouse clicks and hovers. For example:
1. When an earthquake marker is clicked, all the markers disappear except the city markers that lie in the threat circle(cities that might be affected by the earthquake) of the earthquake or if a city is clicked, it will display all the earthquakes where the city is in the threat circle whereas clicking it again unhides all the markers. 
2. Interactions like zoom and pan are included.
3. Hovering over an earthquake displays information about the earthquake like the magnitude and the location.
