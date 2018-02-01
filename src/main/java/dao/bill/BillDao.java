package dao.bill;

import dao.bill.mapper.BillRowMapper;
import models.Bill;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BillDao implements IBillDao {
    private DataSource dataSource;

    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public void create(String company, String type, int dueDate, double amount, boolean autopay) {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO BILL (bill_id, company, type, due_date, amount, autopay) VALUES (company,type,dueDate,amount,autopay)",
                new Object[] {  company, type, dueDate, amount, autopay });
    }

    public List<Bill> select(int billId) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select
                .query(
                        "select  * from BILLS where BILL_ID = ?",
                        new Object[] { billId },
                        new BillRowMapper());
    }

    public List<Bill> select(String billType) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select
                .query(
                        "select  * from BILLS where TYPE = ?",
                        new Object[] { billType },
                        new BillRowMapper());
    }

    public List<Bill> selectAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("select * from BILLS",
                new BillRowMapper());
    }

    public void deleteAll() {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from BILLS");
    }

    public void delete(int billId) {
        JdbcTemplate delete = new JdbcTemplate(dataSource);
        delete.update("DELETE from BILLS where id= ?",
                billId);
    }

}