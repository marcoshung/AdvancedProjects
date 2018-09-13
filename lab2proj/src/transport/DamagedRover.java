package transport;

public class DamagedRover extends MarsRover {
	private final static int MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY = 10000;
	private final static int METERS_FROM_START_TO_CLIFF = 1000;
	private final static int N_SIMULATIONS = 5000;

	// Distance from start. Range is
	// -1000 to +1000. If Rover travels // beyond this range, it falls off // a
	// cliff.
	private double position;
	// Total meters traveled
	// back and forth.
	private double metersTraveled = 0;
	// If true, an expensive loss.
	private boolean fell = false;

	// Simulates travel under damage conditions. In each turn, travels forward or
	// backward either 1, 2, 3, or 4 meters. Continues until there's no more power
	// in the battery, or we fall off a cliff. Cliffs are at position = 1000 or
	// position = -1000.
	//
	public void simulateStormDamageTravel() {
		position = 0;
		while (metersTraveled < MAX_TRAVEL_METERS_BEFORE_EMPTY_BATTERY || fell) {
			double distanceNextTurn = (int)(1 + 4*Math.random()); 
			boolean forwardNotBack = (Math.random() > 0.5);
			// Adjust position and metersTraveled.
			if (forwardNotBack) {
				position += distanceNextTurn;
			}else {
				position -= distanceNextTurn; 			
			}
			metersTraveled += distanceNextTurn;
			// Check for falling off cliff. If Rover fell, set fell to true and // terminate (break out of) the loop.
			if (position >= METERS_FROM_START_TO_CLIFF || position <= METERS_FROM_START_TO_CLIFF * (-1)){
				fell = true;
				System.out.println("fell " + metersTraveled);
			}
		} 
		if(!fell) {
			System.out.println("No More Power");
		}
	}
	
	public double getMetersTraveled() {
		return this.metersTraveled;
	}
	public boolean getFell() {
		return this.fell;
	}
	
	public static void main(String[] args) {
		DamagedRover r = new DamagedRover();
		int counter = 0;
		for(int i = 0; i < N_SIMULATIONS;i++) {
			r.simulateStormDamageTravel();
			if(r.getFell()) {
				counter++;
			}
		}
		System.out.println("Number of Times Fell : " + counter);
	}
}
