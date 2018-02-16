package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    
    /**An Object that come from ValueComparator class. Use to compare money.*/
	private Comparator<Valuable> comp = new ValueComparator();

    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Valuable>();
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
     * @param val is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Valuable val ) {
        // if the purse is already full then can't insert anything.
    	if (!isFull() && val.getValue() > 0 ) {
    		money.add(val);
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
    public Money[] withdraw( double amount ) {
    	Valuable money = new Money(amount,"Baht");
    	return withdraw(money);
    	
	}
    
    /**
     * Withdraw the amount using only items that have the same currency as the parameter(amount) 
     * @param amount : amount of the money that we are going to withdraw.
     * @return remaining money 
     */
    public Money[] withdraw( Valuable amount ) {
    	if(amount == null || amount.getValue() <= 0 ) return null;
    	
    	 double cash = amount.getValue();
    	 Collections.sort(money, comp);
    	 Collections.reverse(money);
    	 List<Valuable> m =  MoneyUtil.filterByCurrency(money,amount.getCurrency());
    	 List<Valuable> temp = new ArrayList<Valuable>();
   
    	 if(getBalance() >= amount.getValue()){
    		 for (Valuable value : m){
    			 if (cash - value.getValue() >= 0){
    				 cash -= value.getValue();
    				 temp.add(value);
    			 } 
    		 }
    	 }
    	 if (cash != 0) return null;
    	 for (Valuable value : temp){
    		 money.remove(value);
    	 }
    	 
    	 Money[] array = new Money[temp.size()];// create the array
         temp.toArray(array);
         return array;  
	}
    
    
    /*
	 * returns a string description of the purse contents. 
	 */
    public List<Valuable> getMoney() {
		return money;
	}

    /** 
     * toString returns a string description of the purse contents.
     * @return It can return whatever is a useful description.
     */
    public String toString() {
    	return count() + " coins with value " + this.getBalance();
    }
  

}
