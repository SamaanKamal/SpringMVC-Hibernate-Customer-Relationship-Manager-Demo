package CustomersList.example.CustomersListDemo.Controllers;

import CustomersList.example.CustomersListDemo.DAO.CustomerDAO;
import CustomersList.example.CustomersListDemo.Entities.Customer;

import CustomersList.example.CustomersListDemo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomers(Model theModel){
        List<Customer> customers = customerService.getCustomers();
        theModel.addAttribute("customers",customers);
        return "list-customers";
    }
}
