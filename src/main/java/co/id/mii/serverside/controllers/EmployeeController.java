package co.id.mii.serverside.controllers;

import co.id.mii.serverside.models.Employee;
import co.id.mii.serverside.models.dto.request.EmployeeRequest;
import co.id.mii.serverside.services.EmployeeServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeServices employeeService;

    @Autowired
    public EmployeeController(EmployeeServices employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<co.id.mii.serverside.models.Employee> getById(@PathVariable Long id) {
        return new ResponseEntity(employeeService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeRequest employeeRequest) {
        return new ResponseEntity(employeeService.create(employeeRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id,
            @RequestBody Employee employee) {
        return new ResponseEntity(employeeService.update(id, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        return new ResponseEntity(employeeService.delete(id), HttpStatus.OK);
    }

}
