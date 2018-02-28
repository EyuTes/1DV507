package eb223db_assign1.Exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;


public  class FerrySystem implements Ferry{
	
	private static final int MAX_NUMBER_OF_VEHICLES = 200;//40cars=40*5bicycle= 40*5=200
	private static final int MAX_NUMBER_OF_PASSENGERS = 200;
	
	private  List<Passenger> passengers=new ArrayList<>();
	private  List<Vehicle> vehicles=new ArrayList<>();
	private int earnedMoney;
	// Number of passengers on board
	@Override
	public int countPassengers() {
		return passengers.size();
	}
	// Used vehicle space. One car is 1.
	@Override
	public int countVehicleSpace() {
		int count = 0;
		for(Vehicle v: vehicles){
			count+= v.getVehicleSize();
		}
		return count;
		
	}
	// Earned money
	@Override
	public int countMoney() {
	
		return earnedMoney;
	}
	/* Embark passenger, warning if not enough space */
	@Override
	public void embark(Vehicle v) {
		//If vehicle already embarked, do nothing
		//if (!vehicles.contains(v)) {
			//If not space for.
			if(!hasSpaceFor(v)) throw new IndexOutOfBoundsException("No space for ferry: The maximum number of vehicles is reached.");
			// Embark the passenger of the vehicle.
			for (Passenger passenger : v.getPassengers()) {
					embark(passenger);
			 }
			addFee(v.getVehicleFee());// Pay vehicle fee.
			vehicles.add(v);//add the vehicles
		//}
	}
	/* Embark passenger, warning if not enough room */
	@Override
	public void embark(Passenger p) {
		if(!hasRoomFor(p)) throw new IndexOutOfBoundsException("No enough room");
		else{
			addFee(p.getFee());
			passengers.add(p);
		}
	
	}
	
	/* Clear (empty) ferry. */
	@Override
	public void disembark() {
		//As long there is a vehicle remove them each
		while (!vehicles.isEmpty()) {
			vehicles.remove(0);
		}
		passengers.clear();//clear all the passengers
	}
	/* Checks if we can embark Vehicle.*/
	@Override
	public boolean hasSpaceFor(Vehicle v) {
	
		return (v.getVehicleSize()+ countVehicleSpace())<=MAX_NUMBER_OF_VEHICLES;
	}
	/* Checks if we can embark Passenger.*/
	@Override
	public boolean hasRoomFor(Passenger p) {
		
		return passengers.size()< MAX_NUMBER_OF_PASSENGERS;
	}
	/*  Vehicle  Iterator.*/
	@Override
	public Iterator<Vehicle> iterator() {
		
		return new VechileIterator();
	}
	class VechileIterator implements Iterator<Vehicle>{
		
		int count=0;
		@Override
		public boolean hasNext() {
			return count < vehicles.size();
		}
		@Override
		public Vehicle next() {
			return vehicles.get(count);
		}
	}
	// Nice looking ferry status print out
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		String prefix="\n";
		if (vehicles.isEmpty()) {
        	return "Ferry is empty, disembarked or what ever you want it to be.";
        }
		for(Vehicle v : vehicles) {
			buf.append(prefix);
			buf.append(v.toString());
		}
		return buf.toString();
	}
	
	private void addFee(int fee) {
		earnedMoney += fee;
	}
}
