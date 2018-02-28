package eb223db_assign1.Exercise6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;

public class Histogram {
	/**
	 * Read only integer with range from 1 to 200 from the file and add to the
	 * array list
	 */
	public static List<Integer> findIntegers(Scanner sc) {

		List<Integer> list = new ArrayList<Integer>();
		while (sc.hasNext()) {
			int nextInt = sc.nextInt();
			if (nextInt >= 1 && nextInt <= 200) {
				list.add(nextInt);
			}
		}
		sc.close();
		return list;
	}

	/**
	 * Counts how many integers found on specific interval.
	 */
	private static int getIntegersInTheInterval(List<Integer> listOfInts,int min, int max) {
		int count = 0;
		for (int num : listOfInts) {
			if (num >= min && num <= max) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Get file path from the user
	 */
	private static void getPathFromUser() {
		
		ArrayList<String> listX = new ArrayList<String>();
		ArrayList<Integer> listY = new ArrayList<Integer>(Collections.nCopies(1000, 0));
		for(int i = 0; i < 100; i= i + 10){ //1-10,11-20,... and add to listX
			listX.add(String.valueOf(i +1) +" - " + String.valueOf(i +10) );
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("\t please enter path for the file");
		String path = scan.nextLine();
		try {
			// "C:..\\2DV600\\src\\assignment1\\nums"
			scan = new Scanner(new File(path));
			List<Integer> numbers = findIntegers(scan);
			System.out
					.println("\t Reading integers from the file: \n\t\t" + path);
			if (numbers.isEmpty()) {
				System.out.println("No Integer were found in " + path);
			} else {
				System.out.println("Found Integers: " + numbers.toString());
				System.out.println("Number of integers in the interval [1, 100]: "
						+ getIntegersInTheInterval(numbers, 1, 100));
				System.out.println("in the interval [101, 200]: "
						+ getIntegersInTheInterval(numbers, 101, 200));
				System.out.println();
				System.out.println("\t Histogram \n");
				for (int i = 0; i < numbers.size(); i++) {
					for (int j = 0; j < 10; j++) { //add the number counts to listY from 1-10 11-20 to 91-100
						if (numbers.get(i) >= (j * 10 + 1) && numbers.get(i) <= (j * 10 + 10)) {
							listY.set(j, listY.get(j) + 1); //increase value of listY index 0+1 1+1 2+1 to count numbers for each period 1-10,..//
						}
					}
				}
				/*get pie chart*/
			    PieChart chart = getChart(listX,listY);
			    new SwingWrapper<PieChart>(chart).displayChart();
	            /*get bar chart*/
			    CategoryChart chart2 = getBarChart(listX,listY);
			    new SwingWrapper<CategoryChart>(chart2).displayChart();
				scan.close();
			}
		}
			catch (IOException e) {
				e.printStackTrace();
		}
		}
	public static void main(String[] args) throws IOException {
			getPathFromUser();
		
		}
	public static  PieChart getChart(ArrayList<String> listX, ArrayList<Integer> listY) {
	    // Create Chart
	    PieChart chart = new PieChartBuilder().width(800).height(600).title("Pie Histogram").build();
	    for(String i : listX){
	    	chart.addSeries(String.valueOf(i), listY.get(listX.indexOf(i)));
	    }
	    return chart;
	  }
	
	public static CategoryChart getBarChart(ArrayList<String> listX, ArrayList<Integer> listY) {
	    //Create BarChart//
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Bar Histogram").xAxisTitle("Score").yAxisTitle("Number").build();
	    //Customize Chart//
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	   	chart.getStyler().setHasAnnotations(true);
	   	// Series
		ArrayList<Integer> listYNew = new ArrayList<Integer>();
		for(String i : listX){
	    	listYNew.add(listY.get(listX.indexOf(i)));
	    }
	    chart.addSeries(" ", listX, listYNew);
	    return chart;
	  }
}
