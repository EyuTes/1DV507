package eb223db_assign1.Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public abstract class Vehicle {
	private static final int MIN_NUM_OF_PASSANGERS = 1;
	//protected Set<Passenger> passengers = new HashSet<Passenger>();
	protected int vehicleSize;
	protected int vehicleFee;

	protected List<Passenger> passengers=new ArrayList<Passenger>();

	public Vehicle(int vehicleFee, int passengerFee, int MAX_NUM_OF_PASSANGERS,
			int vehicleSize, int numOfPassengers) {
		// If the passengers cannot fit in the Vehicle.
		if (numOfPassengers < MIN_NUM_OF_PASSANGERS
				|| numOfPassengers > MAX_NUM_OF_PASSANGERS) {
			throw new IndexOutOfBoundsException("This vehicle can only take "
					+ MIN_NUM_OF_PASSANGERS + " - " + MAX_NUM_OF_PASSANGERS
					+ " passenger.");
		}
		this.vehicleFee = vehicleFee;
		this.vehicleSize = vehicleSize;
		for (int i = 0; i < numOfPassengers; i++) {
			passengers.add(new Passenger(passengerFee));
		
		}

	}

	/* Get the size of the Vehicle. */
	public int getVehicleSize() {
		return vehicleSize;
	}

	/* Get the fee of the Vehicle. */
	public int getVehicleFee() {
		return vehicleFee;
	}

	/* Get the list of passengers. */
	public List<Passenger> getPassengers() {
		return passengers;
	}

}
