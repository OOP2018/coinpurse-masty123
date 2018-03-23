package strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Purse;
import coinpurse.Valuable;

public class WithdrawStrategyTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "Baht";
	/**withdraw object**/
	private WithdrawStrategy strategy ;
	
	@Before
	public void setUp() throws Exception {
		strategy = new RecursiveWithdraw();
	}
	
	 /** Make a coin with the default currency. To save typing "new Coin(...)" */
    private Coin makeCoin(double value) {
		return new Coin(value,CURRENCY);
	}
    
    /** Make a coin with the default currency. To save typing "new Coin(...)" */
    private BankNote makeBankNote(double value) {
		return new BankNote(value,CURRENCY);
	}
    
	

	
	@Test
	public void testNormalWithdraw() {
		List<Valuable> money = Arrays.asList(makeCoin(1.0), makeCoin(0.5), makeCoin(10.0), makeCoin(0.25), makeCoin(5.0));
		strategy.withdraw(makeCoin(5), money);
		assertEquals(10, strategy.withdraw(makeCoin(10), money).get(0).getValue(),TOL);
	}
	
	@Test
	public void testImpossibleWithdraw(){        
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> wd = new ArrayList<Valuable>();
		money.add(makeBankNote(20));
		money.add(makeBankNote(100));
		wd = strategy.withdraw(makeBankNote(500), money);
		assertNull(wd);
	}
	
	@Test
	public void testRecursiveWithdraw(){
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> temp = new ArrayList<Valuable>();
		Valuable amount = new Money(6, CURRENCY);
		money.add(makeCoin(5));
		money.add(makeCoin(2));
		money.add(makeCoin(2));
		money.add(makeCoin(2));
		temp = strategy.withdraw(amount, money);
		double result = 0;
		for(Valuable v : temp){
			result += v.getValue();
		}
		assertEquals(6, result,TOL);

		
	}
	
	
	@Test
	public void testWithdrawFirst(){
		List<Valuable> money = new ArrayList<Valuable>();
		Valuable target = makeCoin(5);
		money.add(target);
		money.add(makeCoin(2));
		money.add(makeCoin(3));
		List<Valuable> temp = strategy.withdraw(target, money);
		double value = temp.get(0).getValue();
		assertEquals(value, target.getValue(),TOL);
		
	}
	
	@Test
	public void testWithdrawCoin() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> wd = new ArrayList<Valuable>();
		money.add(makeCoin(5));
		money.add(makeCoin(1));
		money.add(makeCoin(10));
		wd = strategy.withdraw(makeCoin(10), money);
		assertTrue( wd != null );
		assertEquals(1, wd.size());
	}
	
	@Test
	public void testWithdrawBankNote() {
		List<Valuable> money = new ArrayList<Valuable>();
		List<Valuable> wd = new ArrayList<Valuable>();
		money.add(makeBankNote(100));
		money.add(makeBankNote(500));
		money.add(makeBankNote(20));
		wd = strategy.withdraw(makeBankNote(500), money);
		assertTrue( wd != null );
		assertEquals(1, wd.size());
	}
	
	/**
	 * Sum the value of some coins.
	 * @param wd1 array of coins
	 * @return sum of values of the coins
	 */
	private double sum(Valuable[] wd1)  {
		if (wd1 == null) return 0.0;
		double sum = 0;
		for(Valuable c: wd1) if (c != null) sum += c.getValue();
		return sum;
	}

	
	

}
