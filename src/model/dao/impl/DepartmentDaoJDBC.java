package model.dao.impl;

import com.mysql.cj.protocol.Resultset;
import dao.DepartmentDao;
import db.DB;
import db.DBException;
import entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Department department) {
        PreparedStatement ps = null;

        try{
        ps = conn.prepareStatement(
                "INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);


                ps.setString(1, department.getName());

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    ResultSet rss = ps.getGeneratedKeys();
                    if (rss.next()) {
                        int id = rss.getInt(1);
                        department.setId(id);

                    }
                }
            System.out.println("Insert Completed! Rows Affected: " + rowsAffected);

        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "UPDATE department SET Name =? WHERE Id =?");
                ps.setString(1, department.getName());
                ps.setInt(2, department.getId());

                int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Updated! Rows Affected: " + rowsAffected);
            }
            else {
                throw new DBException("No rows affected");
            }
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "DELETE FROM department WHERE id =?");
                ps.setInt(1, id);

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("DELETED! Rows Affected: " + rowsAffected);
                }
                else {
                    System.out.println("No rows affected");
                }

        }
        catch (SQLException e ){
            throw new DBException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
        }

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM department WHERE id =?");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                return dep;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM department");
            rs = ps.executeQuery();

            List<Department> list = new ArrayList<>();

            while (rs.next()) {
                Department dep = instantiateDepartment(rs);
                list.add(dep);
            }

            return list;
        }
        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
        finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    public Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;

    }
}
