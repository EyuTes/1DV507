package eb223db_assign1.Exercise1;


public class CollectionFactoryMain {
	
	public static void manipulate(){
		
		CollectionFactory collectionFactory = new CollectionFactory();
		AbstractIntCollection abstractCollections=null;
	      String[] collections={"STACK","LIST"};
	      for(int i=0;i<collections.length;i++){
	    	  abstractCollections = collectionFactory.getCollection(collections[i]);
	    	  if(abstractCollections instanceof ArrayIntStack){
		    	  System.out.println(abstractCollections.toString());
		      }
		      if(abstractCollections instanceof ArrayIntList){
		    	  System.out.println(abstractCollections.toString());
		      }
		     
	      }
	     
	}
	
	public static void main(String[] args) {
		CollectionFactoryMain.manipulate();
	}
}
