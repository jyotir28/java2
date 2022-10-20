package com.celestial;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Keyboard Handler
 *
 */
public class App 
{	
	public double calculateVAT(double a, double b) {
		return (a*(b/100) + a);
	}
    public static void main( String[] args )
    {
        String lineRead;
        Scanner sc = new Scanner(System.in);
        int growBy=3;
        String[] lines = new String[growBy];
        App app = new App();
    	System.out.println("Enter VAT rate");
    	double vatRate = sc.nextDouble();
        try
        {
            for(int x=0; (x<lines.length && prompt() && (lineRead= sc.next())!=null);x++)
            {	
                lines[x] = lineRead;
            	System.out.println(lineRead);
            	
            	if(x == lines.length-1) {
            		lines = Arrays.copyOf(lines, growBy+lines.length);
            	}
            	if(lineRead.equalsIgnoreCase("quit"))
            		break;
            }
            
        }catch( NoSuchElementException e )
        {}
        int k=0;
        double totalCost =0;
        for(String s:lines) {
        	if(s.equalsIgnoreCase("quit")) {
        		break;
        	}
        	k++;
        }
       
        
        for(int i=0;i<k;i++) {
        	double cost = Double.parseDouble(lines[i]);
        	totalCost = totalCost+cost;
        }
        
        System.out.println("totalCost " + totalCost);
        
        double finalValue= 0;
        finalValue= app.calculateVAT(totalCost,vatRate);
        System.out.println("finalCost "+ finalValue);
        
    }
    
    static private boolean prompt()
    {
        System.out.print("Enter cost price:");
        return true;
    }
}
