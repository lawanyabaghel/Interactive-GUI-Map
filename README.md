# Interactive-GUI-Map

The project uses PApplet to lay out a map that reads earthquake data from a live feed in realtime and displays it on the GUI(Graphical User Interface) with the help of earthquake markers. The markers are organized on the basis of magnitude and depth, for example- big red circles for large magnitude earthquakes, medium yellow markers for moderate earthquakes and small blue markers for light earthquakes. The earthquakes that occurred on land are denoted by markers different from that of the earthquakes that occurred in the ocean. Cities all over the world are denoted by red triangular city markers.
 

CUSTOM MARKERS
----------
The geo-positioned markers are customised with different shapes and colors using the Processing Library to denote the earthquakes of different magnitudes and depths on the map. A List of country markers(through their Point Features) is used to decide whether an earthquake occured on land or not. Different custom Markers are used to denote the earthquakes that occured on land(circle) and in water(square) respectively. A list of countries with the total number of respective earthquakes is also printed as output.

EVENT HANDLERS
----------
The application is made interactive by the addition of event handlers for mouse clicks and hovers. For example:
1. When an earthquake marker is clicked, all the markers disappear except the city markers that lie in the threat circle(cities that might be affected by the earthquake) of the earthquake and if a city is clicked, all the earthquakes disappear except those that might affect the city i.e city lies in the threat circle of that particular earthquake whereas clicking it again unhides all the markers. 
2. Interactions like zoom and pan are included.
3. Hovering over an earthquake displays information about the earthquake like the magnitude and the location.
