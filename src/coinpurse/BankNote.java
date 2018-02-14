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
	 * A BankNote with given value and currency.
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency){
		super(value, currency);
		this.serialNumber = nextSerialNumber++;
	}	
	/**
	 * 
	 * A BankNote with given value and serialNumber.
	 *
	 * @param value
	 * @param serialNumber
	 */
	public BankNote(double value, long serialNumber) {
		super(value,"Baht");
		this.serialNumber = serialNumber;
	}
	/**
	 * A BankNote with given value, currency and serialNumber.
	 * @param value
	 * @param currency
	 * @param serialNumber
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value,currency);
		this.serialNumber = serialNumber;
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
		return getValue()+"-"+getCurrency()+" note ["+serialNumber+"]";

	}

	

}
