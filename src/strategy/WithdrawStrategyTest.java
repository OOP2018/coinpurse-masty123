package strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WithdrawStrategyTest {
	
	private WithdrawStrategy strategy ;
	
	@Before
	public void setUp(){
		strategy = new GreedyWithdraw();
	}
	
	

}
