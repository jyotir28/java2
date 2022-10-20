package com.celestial;

import java.util.ArrayList;
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
        ArrayList<String> lines = new ArrayList<String>(100);
        App app = new App();
    	System.out.println("Enter VAT rate");
    	double vatRate = sc.nextDouble();
        try
        {
            while(prompt() && (lineRead= sc.next())!=null)
            {	
            	if(lineRead.equalsIgnoreCase("quit"))
            		break;
            	lines.add(lineRead);
            	System.out.println(lineRead);
            }
            
        }catch( NoSuchElementException e )
        {}

        
        double totalCost=0;
        for(String s:lines) {
        	double temp= Double.parseDouble(s);
        	totalCost=totalCost+temp;
        }
        System.out.println(totalCost);
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
