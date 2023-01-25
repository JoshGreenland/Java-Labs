import java.util.*;
class Employee{
	protected String Name;
	protected double Salary;
	protected int ID;
	
	public Employee(String Name, double Salary, int ID){
		this.Name = Name;
		this.Salary = Salary;
		this.ID = ID;
	}

	public String toString(){
		return Name + " , " + "salary: " + Salary + "$ ," + " ID:" +ID;
	}
}

class Salesperson extends Employee{

	private Policy policy1;

	public Salesperson(String Name, double Salary, int ID, Policy policy1){
		super(Name,Salary,ID);
		this.policy1 = policy1;
	}	
	public void sell(){ 
		System.out.println(Name + " sold you a policy: "+ this.policy1);
	}	
}

class Policy{
	private String Beneficiary;
	private double amount;
	private int PID;
	
	public Policy(String Beneficiary, double amount,int PID){
		this.Beneficiary = Beneficiary;
		this.amount = amount;
		this.PID = PID;
	}	
	
	public String toString(){
		return ("amount- " + amount + " PID- " + PID + " Beneficiary- "
		+ Beneficiary);
	}
}		

class Lab41{
	public static void main(String[] args){
		System.out.println();
		Policy policy1 = new Policy("Joshua",45670.9,2022);
		Salesperson q = new Salesperson("Marcus",23.49,1945,policy1);

		System.out.println(q);
		
		q.sell();
		System.out.println();
	}
}


