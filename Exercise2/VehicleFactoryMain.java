package eb223db_assign1.Exercise2;



public class VehicleFactoryMain {

public static void manipulate(){
		
		VehicleFactory vehicleFactory = new VehicleFactory();
		Vehicle vehicleCollections=null;
	      String[] vehicles={"BUS", "CAR", "LORRY", "BICYCLE"};
	      for(int i=0;i < vehicles.length;i++){
	    	  vehicleCollections = vehicleFactory.getVehicle(vehicles[i]);
	    	  if(vehicleCollections instanceof Bus){
		    	  System.out.println("Vechile type Bus,"+ " Vechile fee= " 
		    			  		+ vehicleCollections.getVehicleFee()+" , Vechile size "+ vehicleCollections.getVehicleSize()
		    			  		+", passengers "+vehicleCollections.getPassengers().size());
		      }
		      if(vehicleCollections instanceof Car){
		    	  System.out.println("Vechile type Car,"+ " Vechile fee= " 
	    			  		+ vehicleCollections.getVehicleFee()+" , Vechile size "+ vehicleCollections.getVehicleSize()
	    			  		+", passengers "+vehicleCollections.getPassengers().size());
		      }
		      if(vehicleCollections instanceof Bicycle){
		    	  System.out.println("Vechile type Bicycle,"+ " Vechile fee= " 
	    			  		+ vehicleCollections.getVehicleFee()+" , Vechile size "+ vehicleCollections.getVehicleSize()
	    			  		+", passengers "+vehicleCollections.getPassengers().size());
		      }
		      if(vehicleCollections instanceof Lorry){
		    	  System.out.println("Vechile type Lorry,"+ " Vechile fee= " 
	    			  		+ vehicleCollections.getVehicleFee()+" , Vechile size "+ vehicleCollections.getVehicleSize()
	    			  		+", passengers "+vehicleCollections.getPassengers().size());
		      }
		     
	      }
	     
	}
	
	public static void main(String[] args) {
		VehicleFactoryMain.manipulate();
		
	}

}
