package CustomersList.example.CustomersListDemo.DAO;

import CustomersList.example.CustomersListDemo.Entities.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int id);

    void updateCustomer(Customer theCustomer);

    void deleteCustomer(int id);
}
