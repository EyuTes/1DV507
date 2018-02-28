package eb223db_assign1.Exercise1;


public class CollectionFactory {
	  //use getCollection method to get object of type collection 
	   public AbstractIntCollection getCollection(String collectionType){
	      if(collectionType == null){
	         return null;
	      }		
	      if(collectionType.equalsIgnoreCase("STACK")){
	         return new ArrayIntList();
	         
	      } else if(collectionType.equalsIgnoreCase("LIST")){
	    	  return new ArrayIntStack();
	      }
	      return null;
	     
	   }
}
