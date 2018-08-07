package form;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FormController {
	
	@Autowired
	FormRepository formRepository;
	
	@RequestMapping("/")
    public String homepage(){
        return "form";
    }
	
	@RequestMapping("/submit")
	@ResponseBody
	public int Submit(@RequestBody Customer customer ) {
		formRepository.save(customer);
		return 1;
		
	}
	
	@RequestMapping("/getCustomer")
	@ResponseBody
	public List<Customer> GetCustomer() {
		List<Customer> customer = formRepository.findAll();
		return customer;
	}
	
	@RequestMapping("/deleteCustomer/{id}")
	@ResponseBody
	public int DeleteCustomer(@PathVariable int id) {
		formRepository.deleteById(id);
		return 1;
	}

}
