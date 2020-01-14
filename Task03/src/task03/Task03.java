/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task03;




/**
 *
 * @author Chamodi
 */
import java.util.Scanner;

public class Task03 {
    
    static int power(int x, int y) 
    { 
        if (y == 0) 
            return 1; 
        else if (y % 2 == 0) 
            return power(x, y / 2) * power(x, y / 2); 
        else
            return x * power(x, y / 2) * power(x, y / 2); 
    } 
  
  
    public static void main(String[] args) 
    { 
        Scanner input = new Scanner(System.in);
    	
    	System.out.print("EnterValue for x: ");
    	int x = input.nextInt();
//    	System.out.println("You entered " +x);

        System.out.print("EnterValue for y: ");
    	int y = input.nextInt();
//    	System.out.println("You entered " +y);

  
        System.out.printf(x+" to the power "+y+" is : %d ", power(x, y)); 
    } 
} 

    /**
     * @param args the command line arguments
     */
  
