package dao.loan;

import java.util.List;

import javax.sql.DataSource;

import dao.loan.mapper.LoanRowMapper;
import models.Loan;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoanDao implements ILoanDao {
    private DataSource dataSource;

    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public void create(String loanType, double interestRate, double originalBalance, double unpaidInterest, double currentBalance, double monthlyPayment) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO LOAN (loan_id, loan_type, interest_rate, original_balance, unpaid_interest, current_balance, monthly_payment) VALUES (loanType,interestRate,originalBalance,unpaidInterest,currentBalance,monthlyPayment)",
                new Object[] { loanType,interestRate,originalBalance,unpaidInterest,currentBalance,monthlyPayment });
    }

    public List<Loan> select(int loanId) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select
                .query(
                        "select  * from LOANS where LOAN_ID = ?",
                        new Object[] { loanId },
                        new LoanRowMapper());
    }

    public List<Loan> select(String loanType) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select
                .query(
                        "select  * from LOANS where LOAN_TYPE = ?",
                        new Object[] { loanType },
                        new LoanRowMapper());
    }

    public List<Loan> selectAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from LOANS",
                new LoanRowMapper());
    }

    public void deleteAll() {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from LOANS");
    }

    public void delete(int loanId) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from LOANS where id= ?",
                loanId);
    }

}