package dao.loan;

import models.Loan;

import javax.sql.DataSource;
import java.util.List;

public interface ILoanDao {

    void setDataSource(DataSource ds);

    void create(String loanType, double interestRate, double originalBalance, double unpaidInterest, double currentBalance, double monthlyPayment);

    List<Loan> select(String loanType);

    List<Loan> select(int loanId);

    List<Loan> selectAll();

    void deleteAll();

    void delete(int loanId);
}
