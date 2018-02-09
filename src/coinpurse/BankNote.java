package coinpurse;
/**
 * BankNote is a class that use to insert money that more than 20.
 * @author Theeruth Borisuth
 *
 */
public class BankNote extends Money  {
	
	//A unique parameter for BankNote.
	private long serialNumber ;
	private static long nextSerialNumber = 1000000;
	
	/**
	 * A banknote with given value and serialNumber.
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency){
		super(value, currency);
		this.serialNumber = nextSerialNumber++;
	}	
	/**
	 * @return serialNumber of the BankNote
	 */
	public long getSerial(){
		return this.serialNumber;
	}
	/**
	 * Convert BankNote to string.
	 * @return BankNote as a string.
	 */
	public String toString(){
		return value+"-"+currency+" note ["+serialNumber+"]";

	}

	

}
