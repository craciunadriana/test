package teste;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import clase.BankAccount;

public class TestMokito extends TestCase {

	BankAccount b;
	
	@Before
	protected void setUp() throws Exception {
		b= Mockito.mock(BankAccount.class);
	}

	@Test
	public void test() {
		Mockito.when(b.getBalance()).thenReturn(200.0);

		assertEquals(new BankAccount(b).moneyLeft(b), 200.0);
	}

}
