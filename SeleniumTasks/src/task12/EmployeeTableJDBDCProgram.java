package task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeTableJDBDCProgram {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/my_database";
		String username = "root";
		String password = "root";
		int[] empcode = { 101, 102, 103, 104, 105 };
		String[] empname = { "Jenny", "Jacky", "Joe", "John", "Shameer" };
		int[] empage = { 25, 30, 20, 40, 25 };
		double[] esalary = { 10000, 20000, 40000, 80000, 90000 };
		String query = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement stmt = conn.prepareStatement(query);
			for (int i = 0; i < empcode.length; i++) {
				stmt.setInt(1, empcode[i]);
				stmt.setString(2, empname[i]);
				stmt.setInt(3, empage[i]);
				stmt.setDouble(4, esalary[i]);
				stmt.executeUpdate();
				System.out.println("Inserted employee: " + empname[i]);
			}
			stmt.close();
			conn.close();
			System.out.println("All records inserted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
