package com.crudEmployee.Controller;


import com.crudEmployee.entity.Employee;
import com.crudEmployee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



        @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Employee> theEmployees = employeeService.findAll();

        theModel.addAttribute("employees", theEmployees);
//        theModel.addAttribute("name", "John Doe");
        return "employees/listemployees";

    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }


    @PostMapping("/save")
    public String saveEmployee( @ModelAttribute ("employee") Employee theEmployee) {

            // save the employee
            employeeService.save(theEmployee);

            // use a redirect to prevent duplicate submissions
            return "redirect:/employees/list";
    }




@GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@ModelAttribute("employeeId") int theId, Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employees/employee-form";
    }

@GetMapping("/delete")
    public String delete(@ModelAttribute("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/employees/list";

    }



}
