package dao;

import java.sql.*;
import java.util.ResourceBundle;

public class Ups {

    private ResourceBundle rb;
    private Connection con;
    private Statement st;
    {
        rb = ResourceBundle.getBundle("mysqldb");
        try {
            con = DriverManager.getConnection(
                    rb.getString("database.url"),
                    rb.getString("database.username"),
                    rb.getString("database.password"));
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void main() {

        getAllEmployees();
        getAllTasks();
        getAllEmployeeByDepartmentId("logistic");
        addTaskForEmployee(1001, "weekly report");
        getAllTasksForEmployee(1001);
        deleteEmployee(1006);
        getAllEmployees();
    }

    private void deleteEmployee(int empId) {
        try {
            st.executeUpdate("DELETE FROM employees WHERE id=" + empId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private void getAllTasksForEmployee(int empId) {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM tasks WHERE emp_id=" + empId);
            printRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private boolean addTaskForEmployee(int empId, String task) {

        try {
            st.executeUpdate("INSERT INTO tasks (description, emp_id) VALUES ('" + task + "', " + empId + ")");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println();
        return true;
    }

    private void getAllEmployeeByDepartmentId(String department) {
        try {
            ResultSet rs = st.executeQuery("SELECT employees.last_name, employees.first_name FROM employees JOIN departments ON " +
                    "employees.dept_id = departments.id WHERE departments.name='" + department + "'");
            printRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private void getAllTasks() {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM tasks");
            printRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private void getAllEmployees() {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM employees");
            printRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private void printRow(ResultSet rs) throws SQLException {
        StringBuilder sb;
        while(rs.next()) {
            sb = new StringBuilder();
            int i = 0;
            try {
                while(true) {
                    sb.append("'" + rs.getString(++i)).append("'\t");
                }
            } catch (SQLException e) {
                System.out.println(sb.toString());
            }
        }
    }
}
