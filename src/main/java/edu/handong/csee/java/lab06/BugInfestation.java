package edu.handong.csee.java.lab06;
//We need to import Scanner so we can use the Scanner utility to accept user input
import java.util.Scanner;
/**
 * The BugInfestation class allows us to calculate the how long it will take for the
 * bugs to infest the house.
 * @author Admin
 *
 */
public class BugInfestation {
	//We initialize the growth rate and volume here so we can use them later
	final double GROWTH_RATE = 0.95;
	final double ONE_BUG_VOLUME = 0.002;
	
	/**
	 * The main function allows us to create a BugInfestation class which allows us to 
	 * compute the bug infestation.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create a new BugInfestation so that we can interact with it and compute the bugs
		BugInfestation bugInfest = new BugInfestation();
		//Call the computeBugs method to compute the bugs
		bugInfest.computeBugs();
	}
	/**
	 * The computeBugs method is what calculates how much bugs and how long it will take
	 * to infest the house.
	 */
	public void computeBugs()
	{
		//Initialize all the variables to the user inputs and cue user to input the information
		//Needed to calculate the bug infestation.
		Scanner keepWork = new Scanner(System.in);
		
		System.out.println("Enter the total volume of your house in cubic feet: ");
		double houseVolume = keepWork.nextDouble();
		System.out.println("Enter the estimated number of roaches in your house: ");
		double startPopulation = keepWork.nextDouble();
		
		double population = startPopulation;
		double totalBugVolume = population * ONE_BUG_VOLUME;
		
		int countWeeks = 0;
		
		//This while loop allows us to continually update the bugs until the bugs over
		//flow the house which allows us to track how many weeks it will take and how
		//many bugs it will take to overflow the house
		while (totalBugVolume < houseVolume)
		{
			double newBugs = population * GROWTH_RATE;
			double newBugsVolume = newBugs * ONE_BUG_VOLUME;
			population = population + newBugs;
			totalBugVolume = population * ONE_BUG_VOLUME;
			countWeeks = countWeeks + 1;
		}
		
		//These prints print out the result of the method.
		System.out.println("Start with a roach population of " + startPopulation);
		System.out.println("and a house with a volume of  " + houseVolume);
		System.out.println("after " + countWeeks + " weeks");
		System.out.println("They will fill a volume of  " + (int)totalBugVolume);
		System.out.println("Better call Debugging Experts Inc.");
	}
}
