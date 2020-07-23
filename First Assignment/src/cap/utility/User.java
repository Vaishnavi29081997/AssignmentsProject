package cap.utility;

import java.util.Scanner;

import cap.bean.Account;
import cap.bean.Loan;
import cap.bean.Transaction;
import cap.service.Service;
import cap.service.ServiceImpl;

public class User {
	static Service service = new ServiceImpl();
	static Transaction transaction = new Transaction();
	static Scanner sc = new Scanner(System.in);
	static Account[] accounts = new Account[10];
	static Loan[] loans = new Loan[10];
	public static void main(String[] args) {
		String AccountId, AccountName, loanType,LoanAccountId;
		double originalBalance,loanAmount = 0.0,finalBalance;
		Integer amount,loanId;
		int  a=0,k = 0;
		while (true) {
			System.out.println("Enter your choice: \n 1.Create Account \n 2.Deposit Amount"
					+ " \n 3.Withdraw amount \n 4.Show Account Details\n 5.Apply loan\n 6.Pay Loan\n 7.Show Loan details");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				
				Account account=new Account();
			
				System.out.println("enter your AccountId");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						account.setAccountid(AccountId);
						break;
					} else
						System.out.println("Please enter valid account id");
				}

				System.out.println("Enter AccountName");
				while (true) {
					AccountName = sc.next();
					if (service.accountNameIsValid(AccountName)) {
						account.setAccountname(AccountName);
						break;
					}else
						System.out.println("Please enter valid account name");
				}

				System.out.println("Enter Address ");

				account.setAddress(sc.next());

				System.out.println("Enter Amount");

				account.setDepositAmount(sc.nextDouble());
				
				
			accounts[a]=account;
			a++;
				
				
				System.out.println("Account created successfully");
				System.out.println(accounts[--a]);


				break;
			}
			case 2: {
				System.out.println("enter your AccountId");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						for(Account acc:accounts) {
							if(acc.getAccountid().equals(AccountId)) {
								System.out.println("Enter deposit Amount");
								amount = sc.nextInt();
								originalBalance=acc.getDepositAmount();
								finalBalance=transaction.depositAmount(originalBalance, amount);
							acc.setDepositAmount(finalBalance);
							System.out.println("balance after depositing is"+finalBalance);
								break;
							}
							
						}
						
					} else {
						System.out.println("Please enter valid account id");
				}

				break;
			}
			
			break;
			
			}
			case 3: {
				System.out.println("enter your AccountId");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						for(Account acc:accounts) {
                         if(acc.getAccountid().equals(AccountId)) {
								System.out.println("Enter withdrawal Amount");
								amount = sc.nextInt();
								originalBalance=acc.getDepositAmount();
								finalBalance=transaction.withdrawAmount(originalBalance, amount);
							acc.setDepositAmount(finalBalance);
							System.out.println("balance after withdrawal is"+finalBalance);
								break;
							}
							
						}
						
					} else {
						System.out.println("Please enter valid account id");
				}

				break;
			}
			
			break;
			
			}
			case 4: {
				System.out.println("enter your AccountId ");

				while (true) {
					AccountId = sc.next();
					if (service.accountIdIsValid(AccountId)) {
						break;
					} else
						System.out.println("Please enter your valid account id");
				}
				transaction.showDetails(AccountId, accounts);

				break;

			}
		case 5: {
				Loan loan=new Loan();
			
				System.out.println("enter loan id");
				loanId = sc.nextInt();

				System.out.println("Enter LoanAmount ");
				loanAmount = sc.nextDouble();

				System.out.println("Enter Loan Type: 1.Home 2.Car 3.Education");
			
					loanType = sc.next();
					System.out.println("Enter your accountID");
					LoanAccountId=sc.next();
				outer:	for(Account acc:accounts) {

						if(acc.getAccountid().equals(LoanAccountId)) {
							
							loan=transaction.getLoan(loanId,loanAmount,loanType);
							System.out.println(loan);
							loans[k]=loan;
							k++;
							System.out.println("Loan Applied successfully");
						break outer;
						}
					}
	
				break;
			}
			case 6: {
				System.out.println("enter loan Id: ");
				loanId = sc.nextInt();
				
				outer1:for(Loan acc:loans) {
					if(acc.getLoanId().equals(loanId)) {
						System.out.println("amount to be paid"+acc.getLoanAmount());
						System.out.println("enter the amount you want to pay");
						loanAmount=sc.nextDouble();
				
						System.out.println("paid successfully");
						break outer1;
					}
					else {
						System.out.println("enter loan id correctly");
					}
				}

				break;
			}
			
			case 7: {

				System.out.println("enter your Loan id ");
				loanId = sc.nextInt();
					outer2:for(Loan loan:loans)
					{

						if(loan.getLoanId().equals(loanId)) {
						System.out.println(transaction.showLoanDetails(loan));

							break outer2;
						}
					}
			break;
				
	}
			
			
	}
	}
}
}
