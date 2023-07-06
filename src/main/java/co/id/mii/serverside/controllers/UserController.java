package co.id.mii.serverside.controllers;

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

import co.id.mii.serverside.models.Employee;
import co.id.mii.serverside.models.User;
import co.id.mii.serverside.models.dto.request.AddRoleUserRequest;
import co.id.mii.serverside.models.dto.request.EmployeeRequest;
import co.id.mii.serverside.services.EmployeeServices;
import co.id.mii.serverside.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private EmployeeServices EmployeeService;

    @Autowired
    public UserController(UserService userService, EmployeeServices EmployeeService) {
        this.userService = userService;
        this.EmployeeService = EmployeeService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return new ResponseEntity(userService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody EmployeeRequest employee) {
        return new ResponseEntity(EmployeeService.create(employee), HttpStatus.CREATED);
    }

    @PostMapping("/addRole")
    public ResponseEntity<Employee> AddRoles(@RequestBody AddRoleUserRequest addRoleUserRequest) {
        return new ResponseEntity(userService.addRole(addRoleUserRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity(userService.update(id, user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        return new ResponseEntity(userService.delete(id), HttpStatus.OK);
    }
}
