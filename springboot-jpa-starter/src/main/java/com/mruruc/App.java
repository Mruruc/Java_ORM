package com.mruruc;

import com.mruruc.model.Employee;
import com.mruruc.repository.EmployeeRepository;
import com.mruruc.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;

@SpringBootApplication
@EnableTransactionManagement
public class App {

    public static void main(String[] args) {
        //     Employee employee = new Employee("Alice","Doe","alice@doe",2100.0, LocalDate.now());
//        Employee employee2 = new Employee("Alice","Doe","alice21@doe",2100.0, LocalDate.now());
//
//       Department department  =new Department("HR");
//        Department department1 = new Department("Dev");
//
        //     employee.setDepartment(department);
//        employee2.setDepartment(department1);

        var applicationContext = SpringApplication.run(App.class, args);
        // EmployeeService service = run.getBean(EmployeeService.class);

        //  service.saveEmployee(employee);
//        service.saveEmployee(employee2);
        //   service.findAllEmployee().forEach(System.out::println);
        //service.deleteEmployeeByEmail("alice21@doe");

        EmployeeRepository repository = applicationContext.getBean(EmployeeRepository.class);

//        System.out.println(repository.findFirstByOrderByEmailAsc());
//        System.out.println("-------------------------------------");
//        System.out.println(repository.findTopByOrderByHireDateDesc());
        //repository.findFirst2BySalaryIsGreaterThan(5000.0, Sort.by(Sort.Order.desc("salary"))).forEach(System.out::println);

//        repository.findEmployeeByEmailIsLikeIgnoreCase("%doe%")
//                .stream()
//                .toList()
//                .forEach(System.out::println);


//        repository.findByHireDateAfter(LocalDate.of(2018,1,1))
//                .forEach(s-> System.out.println(s.getFirstName() + " " + s.getInfo()));


        System.out.println(repository.updateEmail("bob@builder","aliceANDbob.pl@doe"));

        applicationContext.close();
    }


}
