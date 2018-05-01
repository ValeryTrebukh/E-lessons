package dao;

import java.sql.*;

public class Ups {

    private DBConnection dbConnection;
    private Statement st;
    private PreparedStatement pst;

    public void main() {
        dbConnection = new DBConnection(DB.MYSQL);
        st = dbConnection.getStatement();

        getAllEmployees();
        getAllTasks();
        getAllEmployeeByDepartmentName("logistic");
        addTaskForEmployee(1001, "weekly report");
        getAllTasksByEmployeeId(1006);
        deleteEmployee(1006);
        getAllTasks();
        getAllEmployees();

        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    private void getAllTasks() {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM tasks");
            printRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private void getAllEmployeeByDepartmentName(String department) {
        try {
            PreparedStatement pst = dbConnection.getPreparedStatement(
                    "SELECT employees.last_name, employees.first_name FROM employees JOIN departments ON " +
                            "employees.dept_id = departments.id WHERE departments.name=?");
            pst.setString(1, department);
            ResultSet rs = pst.executeQuery();
            printRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private boolean addTaskForEmployee(int empId, String task) {

        try {
            pst = dbConnection.getPreparedStatement("INSERT INTO tasks (description, emp_id) VALUES (?, ?)");
            pst.setString(1, task);
            pst.setInt(2, empId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println();
        return true;
    }

    private void getAllTasksByEmployeeId(int empId) {
        try {
            pst = dbConnection.getPreparedStatement("SELECT * FROM tasks WHERE emp_id=?");
            pst.setInt(1, empId);
            ResultSet rs = pst.executeQuery();
            printRow(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private boolean deleteEmployee(int empId) {
        try {
            pst = dbConnection.getPreparedStatement("DELETE FROM employees WHERE id=?");
            pst.setInt(1, empId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println();
        return true;
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
        rs.close();
    }
}
