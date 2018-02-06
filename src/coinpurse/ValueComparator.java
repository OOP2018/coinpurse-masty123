package coinpurse;
import java.util.Comparator;
/**
 *   
 * Comparing between 2 object that implement Valuable. First, compare them by currency.
 * If both have the same currency order them by value.
 *
 * @author Theeruth Borisuth
 *
 */
public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Comparing between 2 object that implement Valuable. First, compare them by currency.
	 * If both have the same currency order them by value.
	 * @param Valuable v1 : first valuable that we want to compare.
	 * @param Valuable v2 : second valuable that we want to compare.
	 * @return -1 if : v1 < v2
	 *          1 if : v1 > v2
	 *          0 if : v1 = v2
	 * 									
	 */
	@Override
	public int compare(Valuable v1, Valuable v2) {
		if(v1.getCurrency().compareToIgnoreCase(v2.getCurrency()) == 0){//check from .compareTo() method
			if (v1.getValue() < v2.getValue()) return -1;
			else if (v1.getValue() > v2.getValue()) return 1;
			return 0;
		}
		return v1.getCurrency().compareToIgnoreCase(v2.getCurrency());
	}

}
