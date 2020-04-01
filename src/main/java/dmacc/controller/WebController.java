package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Employee;
import dmacc.repository.EmployeeRepository;

@Controller
public class WebController {
	@Autowired
	EmployeeRepository repo;

	@GetMapping({ "/viewAll" })
	public String viewAllEmployees(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewEmployee(model);
		}
		
		model.addAttribute("Employees", repo.findAll());
		return "results";
	}

	@GetMapping("/inputEmployee")
	public String addNewEmployee(Model model) {
		Employee c = new Employee();
		model.addAttribute("newEmployee", c);
		return "input";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateEmployee(@PathVariable("id") long id, Model model) {
		Employee c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("newEmployee", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseEmployee(Employee c, Model model) {
		repo.save(c);
		return viewAllEmployees(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Employee c = repo.findById(id).orElse(null);
	    repo.delete(c);
	    return viewAllEmployees(model);
	}
}
