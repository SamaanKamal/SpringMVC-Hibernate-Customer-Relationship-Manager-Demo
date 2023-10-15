package CustomersList.example.CustomersListDemo.Services;

import CustomersList.example.CustomersListDemo.Entities.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int id);

    void updateCustomer(Customer theCustomer);
}
