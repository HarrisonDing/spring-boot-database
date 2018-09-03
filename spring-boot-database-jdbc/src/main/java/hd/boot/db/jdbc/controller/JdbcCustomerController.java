package hd.boot.db.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hd.boot.db.jdbc.dao.JdbcCustomerDAO;
import hd.boot.db.jdbc.entity.Customer;

@RestController
public class JdbcCustomerController {

	@Autowired
	JdbcCustomerDAO customerDAO;

	@RequestMapping("/getcustInfo")
	public List<Customer> customerInformation() {
		List<Customer> customers = customerDAO.listData();
		return customers;
	}

	@RequestMapping("/crtu")
	public String createCustomer(@RequestParam String name, @RequestParam String country) {
		// Random random = new Random(1000);
		Customer customer = new Customer((int) (System.currentTimeMillis() % 10000), name, country);
		customerDAO.create(customer);

		return "Saved";
	}
}
