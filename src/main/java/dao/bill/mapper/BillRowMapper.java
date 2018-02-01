package dao.bill.mapper;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BillRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int line) throws SQLException {
        BillResultSetExtractor extractor = new BillResultSetExtractor();
        return extractor.extractData(rs);
    }

}