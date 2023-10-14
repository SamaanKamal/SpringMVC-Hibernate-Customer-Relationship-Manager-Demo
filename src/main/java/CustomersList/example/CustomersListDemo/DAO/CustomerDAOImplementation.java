package CustomersList.example.CustomersListDemo.DAO;

import CustomersList.example.CustomersListDemo.Entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.openSession();
        Query<Customer> theQuery = session.createQuery("from Customer ",Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }
}
