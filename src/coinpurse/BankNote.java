package coinpurse;
/**
 * BankNote is a class that use to insert money that more than 20.
 * @author Theeruth Borisuth
 *
 */
public class BankNote implements Valuable {
	
	//variables
	private String currency;
	private double value;
	//A unique parameter for BankNote.
	private long serialNumber ;
	private static long nextSerialNumber = 1000000;
	
	/**
	 * A banknote with given value and serialNumber.
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency ;
		this.serialNumber = nextSerialNumber++;
	}	
	/**
	 * @return value of the banknote.
	 */

	public double getValue() {
		return this.value ;

	}

	/**
	 * @return currency of the banknote
	 */

	public String getCurrency() {
		return this.currency;
	}
	/**
	 * @return serialNumber of the BankNote
	 */
	public long getSerialNumber(){
		return this.serialNumber;
	}
	/**
	 * Check if the value of the BankNote are equal.
	 * @return true if the object are equal.
	 * @return false if the object are not equal.
	 */
	public boolean equals(Object obj){
		if(obj.getClass() != this.getClass() || obj == null){
			return false;
		}
		BankNote other = (BankNote) obj;
		return this.getValue() == other.getValue() && this.getCurrency().equals(other.getCurrency());
	}
	
	/**
	 * Convert BankNote to string.
	 * @return BankNote as a string.
	 */
	public String toString(){
		return value+"---"+currency+" ["+serialNumber+"]";

	}

	@Override
	public int compareTo(Valuable other) {
		if(this.value < other.getValue()){
			return -1;
		}
		else if(this.value > other.getValue()){
			return 1;
		}
		else{
			return 0;
		}
	}

	

}
