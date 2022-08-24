package Day_7.JDBC.Model;

import Day_7.JDBC.Service.EmployeeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String fk_officeCode;
    private int fk_reportsTo;
    private String jobTitle;

    public Employee(int employeeNumber, String lastName, String firstName, String extension, String email, String fk_officeCode, int fk_reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.fk_officeCode = fk_officeCode;
        this.fk_reportsTo = fk_reportsTo;
        this.jobTitle = jobTitle;
    }

    public Employee(){

    }
}
