package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Theeruth Borisuth
 */
public class Purse {
    /** Collection of objects in the purse. */
    private List<Valuable> money ;
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Valuable>(this.capacity);
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double sum = 0 ;
    	for( Valuable c : money){
			sum = sum + c.getValue();
		}
		return sum;
	}

    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return this.capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        return count() >= capacity;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Valuable coin ) {
        // if the purse is already full then can't insert anything.
    	if (!isFull() && coin.getValue() != 0 && coin != null) {
    		money.add(coin);
    		return true;
    	}
        return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
        if (amount < 0) {return null ;}
	  
        Collections.sort(money);	
        ArrayList<Valuable> cash = new ArrayList<Valuable>();
        if (getBalance() >= amount){
        	for (int i = money.size()-1 ; i >=0 ; i--){
        		if (amount - money.get(i).getValue() >= 0){
        			amount -= money.get(i).getValue();
        			cash.add(money.get(i));
        		}
        	}
        }
	
		if ( amount > 0 ){	
			// failed. Don't change the contents of the purse.
			return null;			
		}	
		for (int i = 0 ; i < cash.size() ; i++ ){
			money.remove(cash.get(i));
		}

		Valuable [] array = new Valuable[ cash.size() ]; // create the array
		cash.toArray(array);
		return array;
	}
	/**
	 * Print the all the coin in the purse.
	 * @param coins : An object called "coins".
	 */
	public static void printCoins(List<Valuable> coins) {
		for (int i = 0 ; i < coins.size() - 1 ;i++){
			System.out.println(coins.indexOf(i));		
		}	
	}
    /** 
     * toString returns a string description of the purse contents.
     * @return It can return whatever is a useful description.
     */
    public String toString() {
    	return money.size() + " coins with value " + this.getBalance();
    }
    
  

}
