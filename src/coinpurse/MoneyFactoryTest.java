
package coinpurse;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test the Purse using JUnit.
 * This is a JUnit 4 test suite.  
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4,
 * but you have to tell the IDE to add it to your project as a "Library".
 * To run these tests, right click on this file (in Project panel)
 * and choose Run As -> JUnit test
 * 
 * @author  Theeruth Borisuth
 */
public class MoneyFactoryTest {
	/** tolerance for comparing two double values */

	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "Baht";
	
    /**
     * Sets up the test fixture.
     * Called before every test method.
     */
    
    public void setUp() {
    	// nothing to initialize
    }
    
    
    @Test
    public void testSetAndgetInstance(){
    	MoneyFactory.setMoney(new ThaiMoneyFactory());
    	assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(),"ThaiMoneyFactory");
   
    }
    
    @Test
    public void testCreateMoneySerial(){
    	MoneyFactory.setMoney(new ThaiMoneyFactory());
    	MoneyFactory mf = MoneyFactory.getInstance();
    	Valuable bk1 = mf.createMoney(100);
    	Valuable bk2 = mf.createMoney("500");
    	assertEquals(((BankNote)bk1).getSerial(), 1000000);
    	assertEquals(((BankNote)bk2).getSerial(), 1000001);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCreateMoney(){
    	MoneyFactory.setMoney(new ThaiMoneyFactory());
    	MoneyFactory mf = MoneyFactory.getInstance();
    	Valuable bk3 = mf.createMoney("hello");
    	assertEquals(((BankNote)bk3).getSerial(), 1000000);

    }
    
    
}



