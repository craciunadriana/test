package teste;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.sound.sampled.Line;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import clase.BankAccount;

public class TestFisiere extends TestCase {

	BankAccount b;
	String f="BankAccountValues.txt";
	FileReader reader= null;
	BufferedReader buffer=null;
	
	@Before
	protected void setUp() throws Exception {
		
		b= new BankAccount(100.0, 5000.0, 10.0);
		reader= new FileReader(f);
		buffer= new BufferedReader(reader);
	}
	
	@Test
	public void testFisier() throws IOException
	{
		
		String linie=null;
		
		if((linie= buffer.readLine()) == null)
			System.out.println("fisierul nu a fost gasit");
		else{
		while((linie= buffer.readLine()) != null)
		{
			if(linie.startsWith("#"))
				continue;
			if(linie.isEmpty())
				continue;
			linie= linie.trim();
			
			String[] valori=linie.split(" ");
			double depus= Double.parseDouble(valori[0]);
			double asteptat= Double.parseDouble(valori[1]);
		
			b.deposit(depus);
			
			assertEquals(asteptat, b.getBalance());
			
		}
		
		buffer.close();
		}
	}
	
		
	
}
