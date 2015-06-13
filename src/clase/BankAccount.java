package clase;

public class BankAccount {
	double balance;
	double limit;
	double lowestBalance;
	
	public BankAccount(double b, double l, double lb){
		balance=b;
		limit=l;
		lowestBalance=lb;
	}
	
	public BankAccount()
	{
		this.balance=0.0;
		this.limit=0.0;
		this.lowestBalance=0.0;
	}
	
	public BankAccount(BankAccount b)
	{
		this.balance= b.balance;
		this.limit=b.limit;
		this.lowestBalance= b.lowestBalance;
	}
	
	
	//Retrage bani
	public void withdraw(double amount) throws OverLimitException, OverBalanceException, UnderBalanceException, NullException{
			
		if(amount >= this.limit) throw new OverLimitException();
		
		if(amount > this.balance ) throw new OverBalanceException();
		 
		//if(amount <= this.lowestBalance) throw new UnderBalanceException();
		
		if(amount <= 0 ) throw new NullException();
		
		balance=balance-amount;
	}
	
	//Depozit
	public void deposit(double amount){
		balance=balance+amount;
	}
	
	//Get the value of balance
	public double getBalance(){
		return balance;
	}
	
	public boolean moneyLeft(BankAccount b)
	{
		
		if(b.balance != 0 )
			return true;
		else return false;
	}

}
