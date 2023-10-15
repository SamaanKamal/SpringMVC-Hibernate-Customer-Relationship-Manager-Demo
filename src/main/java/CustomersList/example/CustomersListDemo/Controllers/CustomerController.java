package CustomersList.example.CustomersListDemo.Controllers;

import CustomersList.example.CustomersListDemo.DAO.CustomerDAO;
import CustomersList.example.CustomersListDemo.Entities.Customer;

import CustomersList.example.CustomersListDemo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,Model theModel){
        Customer customer = customerService.getCustomer(id);
        theModel.addAttribute("customer",customer);
        return "customer-form";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.updateCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id){
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }

}
