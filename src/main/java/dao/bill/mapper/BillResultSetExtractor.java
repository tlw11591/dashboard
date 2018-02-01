package dao.bill.mapper;

import models.Bill;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillResultSetExtractor implements ResultSetExtractor {

    public Object extractData(ResultSet rs) throws SQLException {

        Bill Bill = new Bill();

        Bill.setId(rs.getInt("BILL_ID"));
        Bill.setCompany(rs.getString("COMPANY"));
        Bill.setType(rs.getString("TYPE"));
        Bill.setDueDate(rs.getInt("DUE_DATE"));
        Bill.setAmount(rs.getDouble("AMOUNT"));
        Bill.setAutopay(rs.getBoolean("AUTOPAY"));

        return Bill;
    }
}