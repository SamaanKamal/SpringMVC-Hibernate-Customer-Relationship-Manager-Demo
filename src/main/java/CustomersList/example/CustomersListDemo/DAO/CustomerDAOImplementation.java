package CustomersList.example.CustomersListDemo.DAO;

import CustomersList.example.CustomersListDemo.Entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        session.save(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class,id);
        return customer;
    }

    @Override
    public void updateCustomer(Customer theCustomer) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("update Customer set firstName = :newFirstName, lastName = :newLastName, email = :newEmail where id = :theId");
        String first =theCustomer.getFirstName();
        String last =theCustomer.getLastName();
        String email =theCustomer.getEmail();
        int theId = theCustomer.getId();
        query.setParameter("newFirstName", first);
        query.setParameter("newLastName", last);
        query.setParameter("newEmail", email);
        query.setParameter("theId", theId);
        session.joinTransaction();
        query.executeUpdate();
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("delete from Customer where id = :theId");
        query.setParameter("theId", id);
        session.joinTransaction();
        query.executeUpdate();
    }

}
