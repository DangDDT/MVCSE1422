/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.servlet;

import dangddt.book.BookDAO;
import dangddt.book.BookDTO;
import dangddt.cart.CartObject;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tamda
 */
@WebServlet(name = "RemoveItemsFromCartServlet", urlPatterns = {"/RemoveItemsFromCartServlet"})
public class RemoveItemsFromCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = null;
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CUSTCART");
            if (cart != null) {
                Map<String, BookDTO> items = cart.getItems();
                if (items != null) {
                    String[] itemKey = request.getParameterValues("chkAction");
                    if (itemKey != null) {
                        BookDTO[] books = new BookDTO[itemKey.length];
                        for (int i = 0; i < itemKey.length; i++) {
                            books[i] = BookDAO.getBookDTOById(itemKey[i]);
                        }

                        for (int i = 0; i < books.length; i++) {
                            cart.removeItemFromCart(books[i]);

                        }

                    }
                }
            }
            session.setAttribute("CUSTCART", cart);
            url = "DispatchServlet?btAction=View your cart";
        } catch (SQLException ex) {
            Logger.getLogger(RemoveItemsFromCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RemoveItemsFromCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(url);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
