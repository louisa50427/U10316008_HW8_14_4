import java.lang.IllegalArgumentException;
import java.util.*;


class Loan {
	
	private double annualInterestRate;
	private int numOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public Loan() {
		this(2.5, 1, 1000);
	}

	//constructor
	public Loan(double annualInterestRate, int numOfYears,double loanAmount) {
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("AnnualInterestRate is less than or equal to 0");
		if (numOfYears <= 0)
			throw new IllegalArgumentException("NumberOfYears is less than or equal to 0");
		if (loanAmount <= 0)
			throw new IllegalArgumentException("LoanAmountis less than or equal to 0");

	setAnnualInterestRate(annualInterestRate);
	setNumOfYears(numOfYears);
	setLoanAmount(loanAmount);
	}
	
	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	/** Set a new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		this.annualInterestRate = annualInterestRate;
	}
	/** Return numOfYears */
	public int getNumOfYears() {
		return numOfYears;
	}
	/** Set a new numOfYears */
	public void setNumOfYears(int numOfYears) {
		if (numOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");
			this.numOfYears = numOfYears;
	}
	/** Return loanAmount */
	public double getLoanAmount() {
		return loanAmount;
	}
	/** Set a newloanAmount */
	public void setLoanAmount(double loanAmount) {
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");
		this.loanAmount = loanAmount;
	}
	/** Find monthly payment */
	public double monthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		return loanAmount * monthlyInterestRate / (1 -
		(Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
	}
	/** Find total payment */
	public double totalPayment() {
		return monthlyPayment() * numOfYears * 12;
	}
	//return loan date
	public java.util.Date getLoanDate(){
		return loanDate;
	}
}

public class Test{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		System.out.print("ENTER annualInterestRate:");
		double x = input.nextDouble();

		System.out.print("ENTER numOfYears:");
		int y = input.nextInt();

		System.out.print("ENTER loanAmount:");
		double z = input.nextDouble();

		try {
		
			Loan a = new Loan(x, y, z);
			
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
