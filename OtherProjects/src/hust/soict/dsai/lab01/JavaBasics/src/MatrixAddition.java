import java.util.Scanner;
public class MatrixAddition {
	 public static void main(String args[])
	   {
	      int rows, cols;
	      Scanner sc = new Scanner(System.in);
	 
	      System.out.println("Input number of rows of matrix");
	      rows = sc.nextInt();
	      System.out.println("Input number of columns of matrix");
	      cols  = sc.nextInt();
	 
	      int matrix1[][] = new int[rows][cols];
	      int matrix2[][] = new int[rows][cols];
	      int sum[][] = new int[rows][cols];
	 
	      System.out.println("Input elements of first matrix");
	 
	      for ( int i = 0 ; i < rows ; ++i )
	         for ( int j = 0 ; j < cols ; ++j )
	        	 matrix1[i][j] = sc.nextInt();
	 
	      System.out.println("Input the elements of second matrix");
	 
	      for ( int i = 0 ; i < rows ; ++i )
	          for ( int j = 0 ; j < cols ; ++j )
	        	  matrix2[i][j] = sc.nextInt();
	 
	      for ( int i = 0 ; i < rows ; ++i )
	          for ( int j = 0 ; j < cols ; ++j )
	             sum[i][j] = matrix1[i][j] + matrix2[i][j]; 
	 
	      System.out.println("Sum of the matrices:-");
	 
	      for ( int i = 0 ; i < rows ; ++i )
	      {
	          for ( int j = 0 ; j < cols ; ++j )
	            System.out.print(sum[i][j]+"\t");
	 
	         System.out.println();
	      }
	   }
}