package teste;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import clase.BankAccount;
import clase.NullException;
import clase.OverBalanceException;
import clase.OverLimitException;
import clase.UnderBalanceException;

public class TestBankAccount extends TestCase {

	BankAccount b;
	
	public TestBankAccount(String string) {
		super(string);
	}

	@Before
	public void setUp() throws Exception {
		b= new BankAccount(200, 1000, 10);
	}

	@Test
	public void testRetragerePesteLimita() throws OverBalanceException, UnderBalanceException, NullException {
		
		try{
			b.withdraw(15000.0);
			assertFalse("Metoda nu arunca exceptie pentru limita depasita", true);
		}
		catch(OverLimitException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testRetragerePesteValoareSold() throws OverLimitException, OverBalanceException, UnderBalanceException, NullException
	{
		try{
			b.withdraw(400.0);
			assertFalse("Metoda retrage peste sold", true);
			
		}
		catch(OverBalanceException e)
		{
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testRetragereSubLimita() throws OverLimitException, OverBalanceException, NullException
	{
		try{
			b.withdraw(5.0);
			assertFalse("A retras sub limita stabilita", false);
		}
		catch(UnderBalanceException e)
		{
			assertTrue(true);
		}
	}
	
	
	@Test
	public void testRetragereAberanta() throws OverLimitException, OverBalanceException, UnderBalanceException
	{
		try{
			b.withdraw(-200.0);
			assertFalse("S-a retras cantitate negativa" , true);
			
		}	
		catch(NullException e)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void testValoareExacta()
	{
		assertEquals(b.getBalance(), 200.0);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
