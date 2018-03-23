package strategy;

import java.util.List;
import java.util.ArrayList;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * A withdraw method that using recursive pattern.
 * 
 * @author Theeruth Borisuth
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {
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
		if (amount.getValue() == 0) return new ArrayList<Valuable>();
		if (money.isEmpty() || amount.getValue() < 0) return null;
	
			// First Case
			Valuable remaining = new Money(amount.getValue() - money.get(0).getValue(), amount.getCurrency());
			List<Valuable> wd1 = withdraw(remaining, money.subList(1, money.size()));
				if (wd1 != null) {
					List<Valuable> temp = new ArrayList<Valuable>();
					temp.add(money.get(0));
					temp.addAll(wd1);
					return temp;
				}

			// Second Case
			List<Valuable> wd2 = withdraw(amount, money.subList(1, money.size()));
				if (wd2 != null) {
					List<Valuable> temp = new ArrayList<Valuable>();
					//ignore the first one because it was already checked.
					//temp.add(money.get(0));
					temp.addAll(wd2);
					return temp;
				}
		return null;
	}
}
