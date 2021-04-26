/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.book;

import dangddt.student.StudentDTO;
import dangddt.utilities.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author tamda
 */
public class BookDAO implements Serializable{

    public static List<BookDTO> loadBook()
            throws SQLException, ClassNotFoundException {
        List<BookDTO> list = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql String;
                String sql = "SELECT book_id, book_name, book_price, book_image, book_desciption FROM Book";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                //4. Excute Query
                rs = stm.executeQuery();
                //5. Process result
                if (rs != null) {
                    list = new Vector<BookDTO>();
                    BookDTO dto;
                    while (rs.next()) {
                        dto = new BookDTO(rs.getString("book_id"), rs.getString("book_name"), rs.getFloat("book_price"), rs.getString("book_image"),1,rs.getString("book_desciption"));
                        list.add(dto);
                    }
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
        return list;
    }

    public static BookDTO getBookDTOById(String id)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDTO dto = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create sql String;
                String sql = "SELECT book_id, book_name, book_price, book_image FROM Book where book_id = ?";
                //3. Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Excute Query
                rs = stm.executeQuery();
                //5. Process result
                if (rs != null) {
                    if (rs.next()) {
                        dto = new BookDTO(rs.getString("book_id"), rs.getString("book_name"), rs.getFloat("book_price"), rs.getString("book_image"),1);
                    }
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
        return dto;
    }
}
