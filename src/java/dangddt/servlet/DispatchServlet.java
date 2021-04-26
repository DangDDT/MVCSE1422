/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dangddt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tamda
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String SEARCH_CONTROLLER = "SearchLastnameServlet";
    private final String DELETE_CONTROLLER = "DeleteServlet";
    private final String UPDATE_CONTROLLER = "UpdateServlet";
    private final String START_UP_CONTROLLER = "StartUpServlet";
    private final String ADD_TO_CART_CONTROLLER = "AddToCartServlet";
    private final String VIEW_CART_CONTROLLER = "cart.jsp";
    private final String LOG_OUT_CONTROLLER = "LogoutServlet";
    private final String REMOVE_ITEM_FROM_CART_CONTROLLER = "RemoveFromCartServlet";
    private final String INCREASE_ITEMS_CONTROLLER = "IncreaseFromCartServlet";
    private final String DESCREASE_ITEMS_CONTROLLER = "DescreaseFromCartServlet";
    private final String SHOPPING_CONTROLLER = "ShoppingServlet";
    private final String REMOVE_ITEMS_FROM_CART_CONTROLLER = "RemoveItemsFromCartServlet";
    private final String CHECK_OUT_CONTROLLER = "CheckOutServlet";
    private final String SIGN_UP_CONTROLLER = "SignUpServlet";
    
    

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
        String url = LOGIN_PAGE;
        String button = request.getParameter("btAction");

        try {
            if (button == null) {
                url = START_UP_CONTROLLER;
            } else if ("Login".equals(button)) {
                url = LOGIN_CONTROLLER;
            } else if ("Search".equals(button)) {
                url = SEARCH_CONTROLLER;
            } else if ("Delete".equals(button)) {
                url = DELETE_CONTROLLER;
            } else if ("Update".equals(button)) {
                url = UPDATE_CONTROLLER;
            } else if ("Add to Cart".equals(button)){
                url = ADD_TO_CART_CONTROLLER;
            } else if ("View your cart".equals(button)){
                url = VIEW_CART_CONTROLLER;
            } else if ("Logout".equals(button)){
                url = LOG_OUT_CONTROLLER;
            } else if ("Delete".equals(button)){
                url = REMOVE_ITEM_FROM_CART_CONTROLLER;
            } else if ("+".equals(button)){
                url = INCREASE_ITEMS_CONTROLLER;
            } else if ("-".equals(button)){
                url = DESCREASE_ITEMS_CONTROLLER;
            } else if ("Go to shopping book now".equals(button)){
                url = SHOPPING_CONTROLLER;
            } else if ("Remove".equals(button)){
                url = REMOVE_ITEMS_FROM_CART_CONTROLLER;
            } else if ("Check out".equals(button)){
                url = CHECK_OUT_CONTROLLER;
            } else if ("Sign up".equals(button)){
                url = SIGN_UP_CONTROLLER;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
