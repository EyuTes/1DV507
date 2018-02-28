package eb223db_assign1.Exercise2;

public class Lorry extends Vehicle{
	
	private static final int VEHICLE_FEE=300;
	private static final int PASSANGER_FEE=15;
	private static final int MAX_NUM_OF_PASSANGER=2;
	private static final int VEHICLE_SIZE=40;
	
	/* Calls the super class (Vehicle) with the Lorry unique properties. */
	public Lorry(int numberOfPassenger){
		//numberOfPassenger min=1, max=2.
		super(VEHICLE_FEE,  PASSANGER_FEE,  MAX_NUM_OF_PASSANGER,  VEHICLE_SIZE,  numberOfPassenger);
	} 
}
