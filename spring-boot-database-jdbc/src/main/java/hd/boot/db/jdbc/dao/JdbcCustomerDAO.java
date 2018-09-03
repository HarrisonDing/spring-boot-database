package hd.boot.db.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.cj.api.jdbc.Statement;

import hd.boot.db.jdbc.entity.Customer;

@Repository
public class JdbcCustomerDAO {

	@Autowired
	private JdbcTemplate		jdbcTemplate;

	private static final String	SQL	= "select * from customer";

	public List<Customer> listData() {
		List<Customer> customers = new ArrayList<Customer>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			customer.setCustNo((int) row.get("Cust_id"));
			customer.setCustName((String) row.get("Cust_name"));
			customer.setCountry((String) row.get("Country"));

			customers.add(customer);
		}

		return customers;
	}

	public Customer create(final Customer cust) {
		final String INSERT_SQL = "INSERT INTO customer(Cust_id,Cust_name,Country) values(?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, cust.getCustNo());
				ps.setString(2, cust.getCustName());
				ps.setString(3, cust.getCountry());
				return ps;
			}

		}, holder);

		return cust;
	}
}
