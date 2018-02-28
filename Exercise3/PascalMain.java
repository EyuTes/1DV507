package eb223db_assign1.Exercise3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program PascalMain that prints the n:th row of Pascal’s Triangle.
 * The program should include a recursive method int[] pascalRow(int n) 
 * computing the n:th row of the triangle. Notice, your program only needs
 *  to print line n, not necessarily the whole triangle.
 *
 */
public class PascalMain {
	
  public static void main(String[] args) {
	  
	  /*Create a Scanner object connected to the keyboard */ 
	     Scanner scan = new Scanner(System.in);
	     System.out.print("Provide an integer: ");
	     int input=scan.nextInt();//accepting input
	     if(input<0){
				System.err.println("Error: N must be a positive integer !!");
				System.exit(1);
			}
	     if(input==0){System.out.println(1); System.exit(1);  }
	     int x[]=pascal(input);
	     System.out.println(Arrays.toString(x));
		 scan.close();//close the scanner object
   }
  
   
  public static int[] pascal(int N){
	  
	 int num[]=new int [N+1];// N+1 elements in the array
	 if(N==0){num=new int[]{1};}//for N=0->[1] and for N=1->[1,1] etc
	 else{
		 int [] prev=pascal(N-1);//looking for the previous array 
		 num[0]=1; num[N]=1;//the first and the last values are always 1
		 for(int i=1;i<=N-1;i++)
			 num[i]=prev[i-1]+prev[i];//
	 }
	 return num;
  }
  
}
 

