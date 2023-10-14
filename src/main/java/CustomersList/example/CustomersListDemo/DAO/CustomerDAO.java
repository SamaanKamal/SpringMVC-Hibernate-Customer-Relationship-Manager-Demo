package CustomersList.example.CustomersListDemo.DAO;

import CustomersList.example.CustomersListDemo.Entities.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
}
