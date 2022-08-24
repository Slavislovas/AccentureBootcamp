package Day_7.JDBC.Service;

import Day_7.JDBC.DataSourceConfig;
import Day_7.JDBC.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private Connection connection = Day_7.JDBC.Connection.connection("jdbc:mysql://localhost:3306/classicmodels");
    private Connection connection2 = Day_7.JDBC.Connection.connection("jdbc:mysql://localhost:3306/test");
    private DataSource dataSourceConfig = DataSourceConfig.mySqlDataSource();

    public Employee getEmployeeByNumber(int number) throws SQLException, DataAccessException{
        String sql = String.format("SELECT * FROM employees WHERE employeeNumber = %d", number);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
    }

    public List<Employee> getEmployees() throws SQLException{
        String sql = "SELECT * FROM employees";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Employee> employeeList = new ArrayList<>();
        while(rs.next()){
            employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
        }
        return employeeList;
    }

    public int addEmployee(Employee employee) throws SQLException {
        String sql = String.format("INSERT INTO employees VALUES(%d,'%s','%s','%s','%s','%s',%d,'%s')", employee.getEmployeeNumber(), employee.getLastName(), employee.getFirstName(), employee.getExtension(),
                employee.getEmail(), employee.getFk_officeCode(), employee.getFk_reportsTo(), employee.getJobTitle());

        PreparedStatement statement = connection.prepareStatement(sql);

        return statement.executeUpdate();
    }

    public int deleteEmployee(int number) throws SQLException {
        String sql = String.format("DELETE FROM employees WHERE employeeNumber=%d", number);
        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeUpdate();
    }

    public int updateEmployee(int number, Employee employee) throws SQLException {
        String sql = String.format("""
                UPDATE employees
                SET
                    lastName='%s',
                    firstName='%s',
                    extension='%s',
                    email='%s',
                    officeCode='%s',
                    reportsTo=%d,
                    jobTitle='%s'
                WHERE
                    employeeNumber=%d
                """, employee.getLastName(), employee.getFirstName(), employee.getExtension(), employee.getEmail(),
                employee.getFk_officeCode(), employee.getFk_reportsTo(), employee.getJobTitle(), number);

        PreparedStatement statement = connection.prepareStatement(sql);
        return statement.executeUpdate();
    }
}
