package eb223db_assign1.Exercise2;

public class Bicycle extends Vehicle{
	
	private static final int VEHICLE_FEE=40;
	private static final int PASSANGER_FEE=0;
	private static final int MAX_NUM_OF_PASSANGER=1;
	private static final int VEHICLE_SIZE=1;
	/* Calls the super class (Vehicle) with the Bicycles unique properties. */
	public Bicycle(){
		//numberOfPassenger min=1, max=1. I don't think min=0 ;
		super(VEHICLE_FEE,  PASSANGER_FEE,  MAX_NUM_OF_PASSANGER,  VEHICLE_SIZE,  1);
	} 
}
