package transport;

public class Vehicle {
	private int nWheels;
	private double xPosition;
	private double yPosition;
	public Vehicle(int nWheels) {
		this.nWheels = nWheels;
		System.out.println("Vehicle ctor");
	}
	
	public void setPosition(double xPosition,double yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public double getXPosition() {
		return this.xPosition;
	}
	
	public double getYPosition() {
		return this.yPosition;
	}
	
	public void changePositionBy(double xDelta, double yDelta) {
		this.xPosition += xDelta;
		this.yPosition += yDelta;
	}
}
