package Day_7.JDBC.Service;

import Day_7.JDBC.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Employee getEmployeeByNumber(int number) throws SQLException, DataAccessException{
        String sql = String.format("SELECT * FROM employees WHERE employeeNumber = %d", number);

        return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
            @Override
            public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
            }
        });
    }

    public List<Employee> getEmployees() throws SQLException{
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
            }
        });
    }

    public int addEmployee(Employee employee){
        String sql = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, employee.getEmployeeNumber(), employee.getLastName(), employee.getFirstName(), employee.getExtension(),
                                    employee.getEmail(), employee.getFk_officeCode(), employee.getFk_reportsTo(), employee.getJobTitle());
    }

    public int deleteEmployee(int number){
        String sql = "DELETE FROM employees WHERE employeeNumber=?";
        return jdbcTemplate.update(sql, number);
    }

    public int updateEmployee(int number, Employee employee){
        String sql = """
                UPDATE employees
                SET
                    lastName=?,
                    firstName=?,
                    extension=?,
                    email=?,
                    officeCode=?,
                    reportsTo=?,
                    jobTitle=?
                WHERE
                    employeeNumber=?
                """;
        return jdbcTemplate.update(sql, employee.getLastName(), employee.getFirstName(), employee.getExtension(), employee.getEmail(),
                                    employee.getFk_officeCode(), employee.getFk_reportsTo(), employee.getJobTitle(), number);
    }
}
