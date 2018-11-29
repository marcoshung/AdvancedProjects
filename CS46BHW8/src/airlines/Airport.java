package airlines;

import java.util.*;


public class Airport implements Comparable<Airport>
{
	private String					name;
	private int						x;
	private int						y;
	private Set<Airport>			connections;	// all airports with a direct route to/from this airport
	
	
	public Airport(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	
	public int getY()
	{
		return y;
	}
	
	
	public List<Airport> getConnections()
	{
		return new ArrayList<>(connections);
	}
	
	
	// Adds that airport to the list of connections. Only one-way
	public void connectTo(Airport that)
	{
		this.connections.add(that);
	}
	
	
	//Disconnects the airport from this airport. Only one-way
	// Does nothing if this airport is not connected to that.
	//
	public void disconnectFrom(Airport that)
	{
		if(!connections.contains(that)) {
			return;
		}
		connections.remove(that);
	}
	
	
	// tests if the objects are equal
	public boolean equals(Object x){
		if(this.compareTo((Airport) x) == 0) {
			return true;
		}
		return false;
	}
	
	
	//  compares by airport name.
	public int compareTo(Airport that)
	{
		return this.name.compareTo(that.getName());
	}
	
	//returns true if that airport is in this connections.
	public boolean isConnectedTo(Airport that)
	{
		if(connections.contains(that)) {
			return true;
		}
		return false;
	}
	
	
	public String toString()
	{
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}