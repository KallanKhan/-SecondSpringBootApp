package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EmployeeModel;
import com.example.repository.EmployeeRepo;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/ang")
public class AppController {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping(path="/saveEmp")
	public EmployeeModel addEmployees(@RequestBody EmployeeModel employeeModel) {
		
		
		return employeeRepo.save(employeeModel);
	}

	
	/*
	 * @GetMapping(path="/getEmpById/{empId}") public EmployeeModel
	 * getEmpoloyee(@PathVariable("empId") Integer empId) { Optional<EmployeeModel>
	 * empModelOptional = employeeRepo.findById(empId);
	 * if(!empModelOptional.isPresent()) throw new
	 * RuntimeException("Record not found"); return empModelOptional.get();
	 * 
	 * }
	 */
	  
	  @GetMapping("/getEmpById/{id}")
	    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable(value = "id") Integer empId)
	  {
		  EmployeeModel employee = employeeRepo.findById(empId).orElse(null);
	        return ResponseEntity.ok().body(employee);
	    }
	 
	  @GetMapping(path = "/getEmp")
		public List<EmployeeModel> getEmpoloyee() {
			
			return employeeRepo.findAll();
		}
	
	@PutMapping(path = "/updateEmp")
	public EmployeeModel saveOrUpdateEmpoloyee(@RequestBody EmployeeModel employeeModel) {
  System.out.println(employeeModel.getEmpId());
  System.out.println(employeeModel.getFirstName());
		employeeRepo.save(employeeModel);
		return employeeModel;
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public String deleteAll(@PathVariable int empId) {
		
		EmployeeModel employeeModel = employeeRepo.getOne(empId);
		employeeRepo.delete(employeeModel);
		return "delete";
	}
	

}
