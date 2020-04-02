package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Employee;
import dmacc.beans.Position;
import dmacc.repository.EmployeeRepository;
import dmacc.repository.PositionRepository;

@Controller
public class WebController {
	@Autowired
	EmployeeRepository repo;
	@Autowired
	PositionRepository posRepo;
	@GetMapping({ "/" })
	public String index() {
		return "index.html";
	}
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
	
	/////////////////////////////////////////////
	////////////////////////////////////////////
	@GetMapping({ "/viewAllPositions" })
	public String viewAllPositions(Model model) {
		if(posRepo.findAll().isEmpty()) {
			return addNewPosition(model);
		}
		
		model.addAttribute("Positions", posRepo.findAll());
		return "posResults";
	}

	@GetMapping("/inputPosition")
	public String addNewPosition(Model model) {
		Position p = new Position();
		model.addAttribute("newPosition", p);
		return "posInput";
	}

	@GetMapping("/editPosition/{id}")
	public String showUpdatePosition(@PathVariable("id") long id, Model model) {
		Position p = posRepo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + p.toString());
		model.addAttribute("newPosition", p);
		return "posInput";
	}

	@PostMapping("/updatePosition/{id}")
	public String revisePosition(Position p, Model model) {
		posRepo.save(p);
		return viewAllPositions(model);
	}
	
	@GetMapping("/deletePosition/{id}")
	public String deletePositionUser(@PathVariable("id") long id, Model model) {
		Position p = posRepo.findById(id).orElse(null);
	    posRepo.delete(p);
	    return viewAllPositions(model);
	}
	
	////////////
	/*
	
	@GetMapping("/connectPositionEmployee1/{empId}")
	public String connectPositionEmployee1(@PathVariable("empId") long id, Model modelEmployee) {
		Employee e = repo.findById(id).orElse(null);
	    repo.delete(p);
	    return "posSelect";
	}
	@GetMapping("/connectPositionEmployee1/{empId}")
	public String showUpdateEmployee(@PathVariable("id") long id, Model model) {
		Employee c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("newEmployee", c);
		return "input";
		*/
}
