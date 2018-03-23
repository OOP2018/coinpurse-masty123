package strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * A concrete withdraw for Purse class
 * @author Theeruth Borisuth
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
   /**An Object that come from ValueComparator class. Use to compare money.*/
	private Comparator<Valuable> comp = new ValueComparator();
	
	
	/**
	 * Find and return items from a collection whose total value equals the requested amount.
	 * @param amount : is the amount of money to withdraw, with currency
	 * @param money  : the contents that are available for possible withdraw must not be null, 
	 * 				   but maybe an empty list.
	 * @return if a solution is found, return a List containing references from the money parameter (List)
	 * 		   whose sum equals the amount. If a solution is not found, return null
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
   	 Collections.sort(money, comp);
   	 Collections.reverse(money);
   	 List<Valuable> temp = new ArrayList<Valuable>();
   	 double cash = amount.getValue();
   	 
   		 for (Valuable value : money){
   			 
   			 if (cash - value.getValue() >= 0){
   				 cash -= value.getValue();
   				 temp.add(value);
   			 } 
   		 }
   		 if(cash != 0) return null ;
    	 return temp;
	}

}
