package teste;


import junit.framework.TestSuite;

import org.junit.Test;

public class Suita extends TestSuite {

	
	@Test
	public static Suita suite()
	{
		Suita ts= new Suita();
		ts.addTest(new TestBankAccount("testRetragereSubLimita"));
		return ts;
		
	}

}
