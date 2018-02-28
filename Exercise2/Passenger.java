package eb223db_assign1.Exercise2;

public class Passenger {
	
   private static final int FEE_WITHOUT_VEHICLE = 20;
   private int fee;//passenger fee
   
   public Passenger() {
		this(FEE_WITHOUT_VEHICLE);
	}
   /* Set Passenger fee */
   public Passenger(int fee){
	   this.fee=fee;
   }
   /* Gets the passenger fee.*/
   public int getFee(){
	   return fee;
   }
}
