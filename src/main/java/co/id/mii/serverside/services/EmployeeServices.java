package co.id.mii.serverside.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.id.mii.serverside.models.Employee;
import co.id.mii.serverside.models.Role;
import co.id.mii.serverside.models.User;
import co.id.mii.serverside.models.dto.request.EmailRequest;
import co.id.mii.serverside.models.dto.request.EmployeeRequest;
import co.id.mii.serverside.repository.EmployeeRepository;

@Service
public class EmployeeServices {

    private EmployeeRepository employeeRepository;
    private RoleService roleService;
    private JavaMailSenderService javaMailSenderService;

    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository, RoleService roleService,
            JavaMailSenderService javaMailSenderService) {
        this.employeeRepository = employeeRepository;
        this.roleService = roleService;
        this.javaMailSenderService = javaMailSenderService;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not Found"));
    }

    public Employee create(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmail(employeeRequest.getEmail());
        employee.setName(employeeRequest.getName());
        employee.setNumber(employeeRequest.getNumber());

        User user = new User();
        user.setUsername(employeeRequest.getUsername());
        user.setPassword(employeeRequest.getPassword());

        List<Role> role = new ArrayList();
        role.add(roleService.getById(1L)); // Role User
        user.setRoles(role);

        employee.setUser(user);
        user.setEmployee(employee);

        Employee e = employeeRepository.save(employee);

        javaMailSenderService.sendSimpleEmail(new EmailRequest(employeeRequest.getEmail(),
                "Welcome Home " + employeeRequest.getUsername(),
                "Selamat Anda Telah berhasil terdaftar pada program kami."));

        return e;

    }

    public Employee update(Long id, Employee employee) {
        Employee oldEmployee = getById(id);
        employee.setId(id);
        employee.setUser(oldEmployee.getUser());
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }

    public void findByName(String name) {
        if (employeeRepository.findByName(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exists");
        }
    }
}
