package strategy;

import java.util.ArrayList;
import java.util.List;
import coinpurse.Valuable;
/**
 * A concrete withdraw for Purse class
 * @author Theeruth Borisuth
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {
	/**
	 * 
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
   	 List<Valuable> temp = new ArrayList<Valuable>();
   	 double cash = amount.getValue();
   		 for (Valuable value : money){
   			 if (amount.getValue() - value.getValue() >= 0){
   				 cash -= value.getValue();
   				 temp.add(value);
   			 } 
   		 }
    	 if (cash > 0) return null;
    	 return temp;
	}

}
