package cap.dao;

import cap.bean.Account;
import cap.bean.Loan;

public class DaoImpl implements Dao{

	@Override
	public Account getDetails(String accountId, Account[] accounts) {
		for(Account temp:accounts) {
//			System.out.println("$$$$"+temp.getAccountid());
			if(temp.getAccountid().equals(accountId)) {
				System.out.println(temp.getAccountid());
				System.out.println(temp.getAccountname());
				System.out.println(temp.getAddress());
				System.out.println(temp.getDepositAmount());
				return temp;
			}
			
		}
		return null;
		
	}

	@Override
	public Loan getLoan(Integer loanId, Double loanAmount, String loanType) {
		System.out.println("inside daoimpl");
		Loan loan=new Loan();
		loan.setLoanId(loanId);
		loan.setLoanAmount(loanAmount);
		loan.setLoanType(loanType);
		System.out.println("exit daoimpl");
//		System.out.println(loan);
		return loan;
		
	}

	@Override
	public Loan showLoanDetails(Loan loan) {
		
			// TODO Auto-generated method stub
			System.out.println(loan.getLoanId());
			System.out.println(loan.getLoanAmount());
			System.out.println(loan.getLoanType());
			return loan;
			
		}


	@Override
	public Double depositAmount(Double originalamount, Integer amount) {
			return originalamount+amount;
			// TODO Auto-generated method stub
			
		}


	@Override
	public Double withdrawAmount(Double originalamount, Integer amount) {
		return originalamount-amount;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Loan payLoan(Loan loan, Double loanamount) {
		loan.setLoanAmount(loan.getLoanAmount()-loanamount);
		return loan;
		
	
	}
	
}

	




