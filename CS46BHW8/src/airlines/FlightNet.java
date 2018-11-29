package airlines;

import java.util.*;;

public class FlightNet extends HashSet<Airport>{
	public boolean nameIsAvailable(String name) {
		for(Airport port : this) {
			if(port.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}
	
	//connects airport a1 and a2
	public void connect(Airport a1, Airport a2) {
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	//disconnects airport a1 and a2
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	
	//first removes removeMe. Then removes all connections in removeMe
	public void removeAndDisconnect(Airport removeMe) {
		this.remove(removeMe);
		List<Airport> connections = removeMe.getConnections();
		for(Airport port : connections) {
			disconnect(port, removeMe);
		}
	}
	
	//returns the first Airport that is within the maximum distance of coordinates x & y
	public Airport getAirportNearXY(int x, int y, int maximumDistance) {
		
		for(Airport port :this) {
			int distanceX = Math.abs(x - port.getX());
			int distanceY = Math.abs(y - port.getY());
			if(Math.hypot(distanceX, distanceY) <= maximumDistance) {
				return port;
			}
		}
		return null;
	}
}
