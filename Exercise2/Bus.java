package eb223db_assign1.Exercise2;

public class Bus extends Vehicle{
	
	private static final int VEHICLE_FEE=200;
	private static final int PASSANGER_FEE=10;
	private static final int MAX_NUM_OF_PASSANGER=20;
	private static final int VEHICLE_SIZE=20;
	/* Calls the super class (Vehicle) with the Bus unique properties. */
	public Bus(int numberOfPassenger){
		//numberOfPassenger min=1, max=20
		super(VEHICLE_FEE,  PASSANGER_FEE,  MAX_NUM_OF_PASSANGER,  VEHICLE_SIZE,  numberOfPassenger);
	} 
}
