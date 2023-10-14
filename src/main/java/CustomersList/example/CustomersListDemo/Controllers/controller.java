package CustomersList.example.CustomersListDemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
