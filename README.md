# Interactive-GUI-Map

The project consists of a map application which reads earthquake data from a live feed in realtime and displays it on the GUI, with the markers organized on the basis of magnitude and depth.The map also showcases the cities in the world map using City Markers.

MODULE 4
----------
Markers are customised with different shapes and colors using the Processing Library to denote the earthquakes of different magnitudes and depths. A List of country markers(through their Point Features) is used to decide whether an earthquake occured on land or not. Different custom Markers are used to denote the earthquakes that occured on land(circle) and in water(square) respectively. A list of countries with the total number of respective earthquake is also obtained.

MODULE 5
----------
The application is made interactive by the addition of event handlers. For example, when an earthquake marker is clicked, all the markers disappear except the city markers that lie in the threat circle(cities that might be affected by the earthquake) of the earthquake and clicking it again unhides all the markers. 
