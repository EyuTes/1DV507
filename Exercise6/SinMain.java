package eb223db_assign1.Exercise6;
/**
 * To be submitted: Write a program SinMain.java plotting the curve 
 * y = (1 + x/pi)*cos(x)*cos(40*x) in the range 0 <= x <= 2*pi.
 * To be submitted: In the previous course you wrote the program Histogram.java 
 * showing a very primitive bar chart of a number of integers. Change the program 
 * to use XChart to present a bar chart and a pie chart of the same set of data.
 */
import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
/**
 * Write a program SinMain.java plotting the curve 
 * y = (1 + x/pi)*cos(x)*cos(40*x) in the range 0 <= x <= 2*pi.
 * @author eyuel
 *
 */
public class SinMain {
	
	public static void main(String[] args) {
		// Create and Customize Chart
		XYChart chart = new XYChartBuilder().width(800).height(600).build();
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
	    chart.getStyler().setMarkerSize(1);
	    
	    // Generate data
	    List<Double> xData = new ArrayList<Double>();
		List<Double> yData = new ArrayList<Double>();
		double lowerBound = 0.0;
		double upperBound = 2 * Math.PI;
		double xValue = lowerBound;
		
		while((xValue += 0.01) <= upperBound){
			xData.add(xValue);
			yData.add(calculateY(xValue));
		}
		
		// Display sin plot
	    chart.addSeries("Sine Curve", xData, yData);
	    new SwingWrapper<XYChart>(chart).displayChart();
		
	}
	private static double calculateY(double x)
	{
		return (1 + x/Math.PI)*Math.cos(x)*Math.cos(40*x);
	}
}
