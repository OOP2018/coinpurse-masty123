package strategy;

import java.util.List;

import coinpurse.Valuable;
/**
 * This is the interface that decides what items the purse should withdraw, so we can 
 * change the algorithm any time without change the purse class.
 * @author Theeruth Borisuth
 *
 */
public interface WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals the requested amount.
	 * @param amount : is the amount of money to withdraw, with currency
	 * @param money  : the contents that are available for possible withdraw must not be null, 
	 * 				   but maybe an empty list.
	 * @return if a solution is found, return a List containing references from the money parameter (List)
	 * 		   whose sum equals the amount. If a solution is not found, return null
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money);
}
