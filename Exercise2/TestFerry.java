package eb223db_assign1.Exercise2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class TestFerry {
	int count = 0;
	FerrySystem ferry=new FerrySystem();
	/* Executed before every test method. */
	@Before
	public void setUp() {
		System.out.println("Run test method: " + (++count));
	}

	/* Executed after every test method. */
	@After
	public void tearDown() {
		System.out.println(" --- done with test " + count);
	}
	@Test
	public void testCountPassengers(){
		assertEquals(ferry.countPassengers(), 0);
	}
	@Test
	public void testCountVehicleSpace(){
		assertEquals(ferry.countVehicleSpace(), 0);
		boolean isEmpty= true;
		for (int i = 0; i < 5; i++) {
		try {
			ferry.embark(new Car(4));
			} catch (IndexOutOfBoundsException e) {
			isEmpty= false;
			}
	   }
		assertTrue(isEmpty);	
	
		assertEquals(ferry.countVehicleSpace(),25);//5*5=25
		assertEquals(ferry.countPassengers(),20);//4*5=20
		assertEquals(ferry.countMoney(), 800);//5*100+20*15=800
	}
	@Test
	public void testCountMoney(){
	
	}
	@Test
	public void testEmbark(){
		// Embark 10 cars with 4 Passenger each.
		boolean isEmpty= true;
		for (int i = 0; i < 10; i++) {
		try {
			ferry.embark(new Car(4));
			} catch (IndexOutOfBoundsException e) {
			isEmpty= false;
			}
	   }
		assertTrue(isEmpty);	
		
		assertEquals(ferry.countVehicleSpace(),50);//10*5=50
		assertEquals(ferry.countPassengers(),40);//4*10=40
		assertEquals(ferry.countMoney(), 1600);//10*100+40*15=1000+600=1600
		// Embark 1 lorry with 2 Passenger.
			try {
			ferry.embark(new Lorry(2));
				} catch (IndexOutOfBoundsException e) {
				isEmpty= false;
			}
			assertTrue(isEmpty);	
			
			assertEquals(ferry.countVehicleSpace(),90);//40 + previous(cars) 50=90
			assertEquals(ferry.countPassengers(),42);//2*1=2 + + previous(cars) 40=42
			assertEquals(ferry.countMoney(), 1930);//1*300+2*15=330 + + previous(cars) 1600=1930
			
		// Embark 5 buses with 15 Passenger each.
			for (int i = 0; i < 5; i++) {
				try {
					ferry.embark(new Bus(15));
					} catch (IndexOutOfBoundsException e) {
						isEmpty= false;
					}
				}
			assertTrue(isEmpty);
			assertEquals(ferry.countVehicleSpace(),190);//5*20 + previous(cars + lorries) 90=90+100=190
			assertEquals(ferry.countPassengers(),117);//5*15=75 + previous(cars + lorries) 42=75+42=117
			assertEquals(ferry.countMoney(), 3680);//5*200+75*10=1750 + previous(cars + lorries) 1930=1750+1930=3680
			
			// Embark 6 bicycles 
			 for (int i = 0; i < 6; i++) {
				 try {
					ferry.embark(new Bicycle());
						} catch (IndexOutOfBoundsException e) {
					isEmpty=false;
					}
				}
			assertTrue(isEmpty);
			assertEquals(ferry.countVehicleSpace(),196);//6*1 + previous(cars + lorries + buses ) 190=6+190=196
			assertEquals(ferry.countPassengers(),123);//6*1 + previous(cars + lorries + buses ) 117=6+117=123
			assertEquals(ferry.countMoney(), 3920);//6*40=240 + previous(cars + lorries + buses ) 3680=240+3680=3920
		
			
			// Embark 77 passenger.
				for (int i = 0; i < 73; i++) {
					try {
						ferry.embark(new Passenger());				
							} catch (IndexOutOfBoundsException e) {
								isEmpty= false;
							}
						}
				assertTrue(isEmpty);
				assertEquals(ferry.countVehicleSpace(),196);//77*0 + previous(cars + lorries + buses + bicycles) 196=0+196=196 
				assertEquals(ferry.countPassengers(),196);//73*1 + previous(cars + lorries + buses + bicycles) 123=73+123=196
				assertEquals(ferry.countMoney(), 5380);//73*20=1460 + previous(cars + lorries + buses + bicycles) 3920=1460+3920=5380
				
			/* test HasRoom */
			assertEquals(ferry.hasRoomFor(new Passenger()), true);
			/* test HasSpace */
			assertEquals(ferry.hasSpaceFor(new Bicycle()), true);
			// Embark 4 Bicycle .
			for (int i = 0; i < 4; i++) {
				try {
				ferry.embark(new Bicycle());
			} catch (IndexOutOfBoundsException e) {
				isEmpty= false;
			}
		}
		assertEquals(ferry.countVehicleSpace(),200);//200
		assertEquals(ferry.countPassengers(),200);//200
		assertEquals(ferry.countMoney(), 5540);//5380 +4*40=160+5380=5540
		/* test HasRoom */
		assertEquals(ferry.hasRoomFor(new Passenger()), false);
		/* test HasSpace */
		assertEquals(ferry.hasSpaceFor(new Bicycle()), false);	
			
		/* test Disembark */
		ferry.disembark();
		assertEquals(ferry.countVehicleSpace(),0);//200
		assertEquals(ferry.countPassengers(),0);//200
		assertEquals(ferry.countMoney(), 5540);//5540 After disembark the money remains there
		assertEquals(ferry.hasRoomFor(new Passenger()), true);//after 
		/* test HasSpace */
		assertEquals(ferry.hasSpaceFor(new Bicycle()), true);	
	}
	@Test
	public void testDisembark(){
		// Embark 10 cars with 4 Passenger each.
				boolean isEmpty= true;
				for (int i = 0; i < 10; i++) {
				try {
					ferry.embark(new Car(4));
					} catch (IndexOutOfBoundsException e) {
					isEmpty= false;
					}
			   }
				assertTrue(isEmpty);	
				
				assertEquals(ferry.countVehicleSpace(),50);//10*5=50
				assertEquals(ferry.countPassengers(),40);//4*10=40
				assertEquals(ferry.countMoney(), 1600);//10*100+40*15=1000+600=1600
		ferry.disembark();
		assertEquals(ferry.countVehicleSpace(),0);//200
		assertEquals(ferry.countPassengers(),0);//200
		assertEquals(ferry.countMoney(), 1600);//5540 After disembark the money remains there
		
	}
	@Test
	public void testHasSpace(){
		assertEquals(ferry.hasSpaceFor(new Car(1)), true);//before 
		// Embark 200 passenger.
				boolean isEmpty=true;
				for (int i = 0; i < 200; i++) {
					try {
						ferry.embark(new Bicycle());				
							} catch (IndexOutOfBoundsException e) {
								isEmpty= false;
							}
						}
				assertTrue(isEmpty);
				assertEquals(ferry.countPassengers(),200);
				assertEquals(ferry.countVehicleSpace(),200);
				assertEquals(ferry.hasSpaceFor(new Car(1)), false);//no space for vehicle 
	}
	@Test
	public void testHasRoom(){
		assertEquals(ferry.hasRoomFor(new Passenger()), true);//before 
		// Embark 200 passenger.
				boolean isEmpty=true;
				for (int i = 0; i < 200; i++) {
					try {
						ferry.embark(new Passenger());				
							} catch (IndexOutOfBoundsException e) {
								isEmpty= false;
							}
						}
				assertTrue(isEmpty);
				assertEquals(ferry.countPassengers(),200);
				assertEquals(ferry.hasRoomFor(new Passenger()), false);//no room for the passengers 
	}
}
