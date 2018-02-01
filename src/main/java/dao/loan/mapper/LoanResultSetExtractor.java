package dao.loan.mapper;

import models.Loan;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanResultSetExtractor implements ResultSetExtractor {

    public Object extractData(ResultSet rs) throws SQLException {
        Loan Loan = new Loan();
        Loan.setId(rs.getInt(1));
        Loan.setLoanType(rs.getString(2));
        Loan.setInterestRate(rs.getDouble(3));
        Loan.setOriginalBalance(rs.getDouble(4));
        Loan.setUnpaidInterest(rs.getDouble(5));
        Loan.setCurrentBalance(rs.getDouble(6));
        Loan.setMonthlyPayment(rs.getDouble(7));
        return Loan;
    }
}