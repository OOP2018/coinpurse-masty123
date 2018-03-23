package strategy;
import java.util.List;
import java.util.ArrayList;

import coinpurse.Money;
import coinpurse.Valuable;
/**
 * A withdraw method that using recursive pattern.
 * @author Theeruth Borisuth
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		if(amount.getValue() == 0) return new ArrayList<Valuable>();
		if(money.isEmpty()) return null;
		if(money != null){
		
		//First Case
		Valuable remaining = new Money(amount.getValue() - money.get(0).getValue(), amount.getCurrency());
		List<Valuable> wd1 = withdraw(remaining , money.subList(1, money.size()));
		if(wd1 != null){
			List<Valuable> temp = new ArrayList<Valuable>();
			temp.add(money.get(0));
			temp.addAll(wd1);
			return temp;
		}
		
		//Second Case
		List<Valuable> wd2 = withdraw(amount , money.subList(1, money.size()));
			if(wd2 != null){
			List<Valuable> temp = new ArrayList<Valuable>();
			temp.add(money.get(0));
			temp.addAll(wd2);
			return temp;
			}
		}	
		return null;
	}
}
