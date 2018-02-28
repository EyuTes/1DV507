package eb223db_assign1.Exercise3;

import java.util.Scanner;

/**
 * Write a program SumMain, that includes a recursive method computing 
 * the sum of the integers 1, 2, 3, ..., N. The computation should be 
 * based on the following principle: the sum of the integers from 1 to N 
 * is equal to the sum of the integers from 1 to N/2 added with the sum of
 *  the integers from N/2+1 to N. 
 *  Is this a good solution strategy? Motivate your answer!
 *  @author eyuel
 */

public class SumMain {

	/**
	 * Sum(N)=1+2+...+(N/2-1)+ (N/2) +(N/2-1)+....+(N-1) + N
	 * 		 =sum(1,N/2) +  sum(N/2+1,N)
	 * sum(1,N/2)=either 1, if N=1 or sum(1,N/2-1)+N/2 if N!=1
	 * sum(N/2+1,N)=either 1, if N=1 or sum(N/2+1,N-1)+ N if N!=1
	 * @param args
	 */
	
	/**
	 * f(N)=1+2+3+. . .+(N-1) +N 
	 *  sum(N)=sum(N-1)+N  or sum(N)=SUM(1,N/2)+SUM(N/2+1,N) where 
	 *  SUM(1,N/2)= SUM(1,N/2-1)+N/2 and  SUM(N/2+1,N)= SUM(N/2+1,N-1)+N 
	 *  
	 *  The answer 
	 *  A single task is divided into two parts and delegates the task for others to finish it. 
	 *  And I would say this is the good strategy for efficiency concern as compare to
	 *  doing the whole task once. Thinking about efficiency is a good strategy 
	 *  while designing or writing code. It is advisable to use iterative than recursive 
	 *  since performance is a big issue but in some cases recursive is the best candidate
	 *  to solve problems easily as compared to iterative, good example for this is binary tree. 
	 *  For instance, in binary tree the root node delegate the task for left and/or right tree node.
	 *  So what I think is dividing the task into parts and give it others to complete it in order 
	 *  to make fast. Computer usually divides the task into sub parts or different parts 
	 *  then delegates others to make the job done fast. Good example are,
	 *   parallel programming, operating system, some algorithm like Merge sort etc. In parallel programming or operating system or merge sort tasks are subdivided into different parts and let others to process and finish it fast. Merge sort is efficient, as compare to other sorting algorithms that sorts the whole input without divides it into subparts, since it split the task into subparts until we get the indivisible part then sort each part then merge them to get the whole part. 
	 */
	public static int sum(int N){
		if(N < 1) throw new IllegalArgumentException("Wrong input:Input must be >=1");
		if(N==1) return 1;
		else
			return sumHalfLower(1,N/2)+sumHalfUpper(N/2+1, N);//Sum(N)=sum(1,N/2) + sum(N/2+1,N)
	}
	private static int sumHalfLower(int lowerBound,int upperBound ){
		
		if(upperBound==1) return 1;
		else
			return sumHalfLower(1,upperBound-1)+ upperBound ;
	}
	private static int sumHalfUpper(int lower,int upper){
		if(lower==upper) return lower;
		return sumHalfUpper(lower,upper-1)+ upper;
	}
	
	public static void main(String[] args) {
		/*Create a Scanner object connected to the keyboard */ 
	     Scanner scan = new Scanner(System.in);
	     System.out.print("Provide an integer: ");
	     int input=scan.nextInt();//accepting input
	     if(input<0){
				System.err.println("Error: N must be a positive integer !!");
				System.exit(1);
			}
	     if(input==0){System.out.println(0); System.exit(0);  }
	     
		
		System.out.println(SumMain.sum(input));
		scan.close();//close the the keyboard object(scan);
	}

}
