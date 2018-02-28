package eb223db_assign1.Exercise2;



public class VehicleFactory {
	//use getCollection method to get object of type collection 
	   public Vehicle getVehicle(String vehicleType){
	      if(vehicleType == null){
	         return null;
	      }		
	      if(vehicleType.equalsIgnoreCase("Car")){
	         return new Car(4);
	         
	      } else if(vehicleType.equalsIgnoreCase("Bicycle")){
	    	  return new Bicycle();
	      }
	      else if(vehicleType.equalsIgnoreCase("Bus")){
	    	  return new Bus(15);
	      }
	      else if(vehicleType.equalsIgnoreCase("Lorry")){
	    	  return new Lorry(2);
	      }
	      return null;
	     
	   }
}
