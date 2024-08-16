package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.Department;

public class DepartmentDao {

    public DepartmentDao() {
        // TODO Auto-generated constructor stub
    }
    public ArrayList<Department> getAllTbDepartment() {
        ArrayList<Department> listDepartment = new ArrayList<Department>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from Department";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String departmentId = rs.getString(1);
                String departmentName = rs.getString(2);
                Department d = new Department(departmentId, departmentName);
                listDepartment.add(d);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listDepartment;
    }

    public static void main(String[] args) throws SQLException {
        ConnectDB.getInstance().connectDataBase();
        System.out.println("get all department: \n" + new DepartmentDao().getAllTbDepartment());

    }

}
