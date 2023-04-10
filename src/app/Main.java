package app;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		EmployeeDAO employeeDAO = new EmployeeDAOimpl();
		Employee employee = new Employee(0, 246802, "Marcelo", "Nemer", 5);
		
		int result = employeeDAO.insert(employee);
		
		System.out.println(result);

	}

}
