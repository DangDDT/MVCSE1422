/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.student;

import dangddt.utilities.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author tamda
 */
public class StudentDAO implements Serializable {

    public StudentDTO checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql String;
                String sql = "SELECT username,password,lastname,isAdmin FROM Student WHERE username = ? AND password = ?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4. Excute Query
                rs = stm.executeQuery();
                //5. Process result
                StudentDTO dto;
                if (rs.next()) {
                    dto = new StudentDTO(rs.getString("username"), rs.getString("password"), rs.getString("lastname"), rs.getBoolean("isAdmin"));
                    return dto;
                }
            } //end if connection
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    private List<StudentDTO> accountList;

    public List<StudentDTO> getAccountList() {
        return accountList;
    }

    public void searchLastname(String searchValue)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql String;
                String sql = "SELECT username,password,lastname,isAdmin FROM Student WHERE lastname LIKE ?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. Excute Query
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    StudentDTO dto = new StudentDTO(username, password, lastname, role);
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();
                    }
                    this.accountList.add(dto);
                }
            } //end if connection
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    public boolean insertRecord (String username, String password, String fullname, boolean isAdmin) throws SQLException,NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.makeConnection();
            if (con!=null){
                String sql = "Insert Student Values (?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullname);
                stm.setBoolean(4, isAdmin);
                int row = stm.executeUpdate();
                if (row>0){
                    return true;
                }
            }
        }finally{
            if (stm!=null) stm.close();
            if (con!=null) con.close();
        }
        return false;
    }
    public boolean deleteRecord (String pk) throws SQLException,NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.makeConnection();
            if (con!=null){
                String sql = "Delete From Student Where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, pk);
                int row = stm.executeUpdate();
                if (row>0){
                    return true;
                }
            }
        }finally{
            if (stm!=null) stm.close();
            if (con!=null) con.close();
        }
        return false;
    }
    public boolean updateRole(String pk, boolean role) throws SQLException,NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try{
            con = DBHelper.makeConnection();
            if (con!=null){
                String sql = "update Student set isAdmin = ? where username = ?";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, role);
                stm.setString(2, pk);
                int row = stm.executeUpdate();
                if (row>0){
                    return true;
                }
            }
        }finally{
            if (stm!=null) stm.close();
            if (con!=null) con.close();
        }
        return false;
    }
    public StudentDTO searchStudent(String pk)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql String;
                String sql = "SELECT username,password,lastname,isAdmin FROM Student WHERE username = ? AND password = ?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, pk);
                //4. Excute Query
                rs = stm.executeQuery();
                //5. Process result
                StudentDTO dto;
                if (rs.next()) {
                    dto = new StudentDTO(rs.getString("username"), rs.getString("password"), rs.getString("lastname"), rs.getBoolean("isAdmin"));
                    return dto;
                }
            } //end if connection
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
