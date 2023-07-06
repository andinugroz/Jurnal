package co.id.mii.serverside.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.id.mii.serverside.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Boolean existsByName(String name);

    Optional<Employee> findByName(String name);
}
