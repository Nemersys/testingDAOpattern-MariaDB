package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO{

	@Override
	public Employee get(int id) throws SQLException {
		Connection con = Database.getConnection();
		Employee employee = null;
		
		String sql = "SELECT id, employee_id, first_name, last_name, dept_id FROM employees WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			int oid = rs.getInt("id");
			int employeeId = rs.getInt("employeeId");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("Last_name");
			int deptId = rs.getInt("dept_id");
			
			employee = new Employee (oid, employeeId, firstName, lastName, deptId);
		}
		return employee;
	}

	@Override
	public List<Employee> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Employee employee) throws SQLException {
		Connection con = Database.getConnection();
		
		String sql = "INSERT INTO employees (employee_id, first_name, last_name, dept_id) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, employee.getEmployeeId());
		ps.setString(2, employee.getFirstName());
		ps.setString(3, employee.getLastName());
		ps.setInt(4, employee.getDeptId());
		
		int result = ps.executeUpdate();
		
		Database.closePreparedStatement(ps);
		Database.closeConnection(con);
		
		return result;
		
	}

	@Override
	public int update(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
