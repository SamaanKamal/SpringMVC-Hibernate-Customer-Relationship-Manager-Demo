package CustomersList.example.CustomersListDemo.Services;

import CustomersList.example.CustomersListDemo.DAO.CustomerDAO;
import CustomersList.example.CustomersListDemo.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImp  implements  CustomerService{

    @Autowired
    private CustomerDAO customerDAO;
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}