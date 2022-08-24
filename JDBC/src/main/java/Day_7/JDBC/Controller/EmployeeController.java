package Day_7.JDBC.Controller;

import Day_7.JDBC.Model.Employee;
import Day_7.JDBC.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{number}")
    public ResponseEntity<Employee> getEmployeeByNumber(@PathVariable("number") int number){
        try {
            return new ResponseEntity<Employee>(employeeService.getEmployeeByNumber(number), HttpStatus.OK);
        } catch (SQLException | DataAccessException e) {
            return new ResponseEntity<Employee>(new Employee(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        try {
            return new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<List<Employee>>(Collections.emptyList(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/newEmployee")
    public ResponseEntity<Integer> addEmployee(@RequestBody Employee employee){
        try {
            return new ResponseEntity<Integer>(employeeService.addEmployee(employee), HttpStatus.OK);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<Integer>(0, HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteEmployee/{number}")
    public ResponseEntity<Integer> deleteEmployee(@PathVariable int number){
        try {
            return new ResponseEntity<Integer>(employeeService.deleteEmployee(number), HttpStatus.OK);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Integer>(0, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/updateEmployee/{number}")
    public ResponseEntity<Integer> updateEmployee(@PathVariable("number") int number, @RequestBody Employee employee){
        try {
            return new ResponseEntity<Integer>(employeeService.updateEmployee(number, employee), HttpStatus.OK);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Integer>(0, HttpStatus.CONFLICT);
        }
    }
}
