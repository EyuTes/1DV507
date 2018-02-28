package eb223db_assign1.Exercise2;

public class Car extends Vehicle{
	
	private static final int VEHICLE_FEE=100;
	private static final int PASSANGER_FEE=15;
	private static final int MAX_NUM_OF_PASSANGER=4;
	private static final int VEHICLE_SIZE=5;
	/* Calls the super class (Vehicle) with the Car unique properties. */
	public Car(int numberOfPassenger){
		//numberOfPassenger min=1, max=4
		super(VEHICLE_FEE,  PASSANGER_FEE,  MAX_NUM_OF_PASSANGER,  VEHICLE_SIZE,  numberOfPassenger);
	} 
}
