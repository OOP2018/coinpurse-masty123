package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author your name
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	//TODO follow the steps in the sequence diagram on Lab sheet.
        // 1. create a Purse
    	Purse purse = new Purse(10);
        // 2. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse);
        // 3. run the ConsoleDialog
    	ui.run();
    	
    	List<Coin> coins = new ArrayList<Coin>( );
    	coins.add( new Coin(10.0, "Baht") );
    	coins.add( new Coin(0.5, "Baht") );
    	coins.add( new Coin(2.0, "Baht") ); // the most hated coin
    	coins.add( new Coin(1.0, "Baht") );
    	printCoins( coins ); //TODO write a method to print the coins
    	// This static method sorts any list of Comparable objects
    	java.util.Collections.sort( coins );
    	printCoins( coins ); // the coins should be sorted by value now

    }

	private static void printCoins(List<Coin> coins) {
		for (int i = 0 ; i < coins.size() ;i++){
			System.out.println(coins.indexOf(i));		
		}	
	}
}
