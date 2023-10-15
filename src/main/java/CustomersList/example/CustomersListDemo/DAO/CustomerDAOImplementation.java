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
        Query<Customer> theQuery = session.createQuery("from Customer order by lastName ",Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session session = sessionFactory.openSession();
        System.out.println("customer from saving  "+ theCustomer.getFirstName());
        session.save(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class,id);
        System.out.println("customer from database "+ customer.getFirstName());
        return customer;
    }

    @Override
    public void updateCustomer(Customer theCustomer) {
        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("update Customer set firstName = :newFirstName, lastName = :newLastName, email = :newEmail where id = :theId");
        String first =theCustomer.getFirstName();
        String last =theCustomer.getLastName();
        String email =theCustomer.getEmail();
        System.out.println("hello");
        System.out.println(first);
        System.out.println(last);
        int theId = theCustomer.getId();
//        query.setParameter("newFirstName", first);
//        query.setParameter("newLastName", last);
//        query.setParameter("newEmail", email);
//        query.setParameter("theId", theId);
        Customer customer = session.get(Customer.class,theId);
        session.merge(customer);
        theCustomer.setFirstName(first);
        theCustomer.setLastName(last);
        theCustomer.setEmail(email);
        System.out.println("test");
        System.out.println(theCustomer.getFirstName());
        System.out.println(theCustomer.getLastName());
//        int rowsUpdated = query.executeUpdate();
    }


}
