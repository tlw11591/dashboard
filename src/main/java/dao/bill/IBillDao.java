package dao.bill;

import models.Bill;

import javax.sql.DataSource;
import java.util.List;

public interface IBillDao {

    void setDataSource(DataSource ds);

    void create(String company, String type, int dueDate, double amount, boolean autopay);

    List<Bill> select(String billType);

    List<Bill> select(int id);

    List<Bill> selectAll();

    void deleteAll();

    void delete(int billId);
}
