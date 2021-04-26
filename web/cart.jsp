<%-- 
    Document   : cart
    Created on : Oct 16, 2020, 11:54:34 AM
    Author     : tamda
--%>

<%@page import="dangddt.book.BookDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="dangddt.cart.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
    </head>
    <body>
        <h1>Your Cart</h1>
        <%
            //1.Cust goes to cart place
            if (session != null) {
                //2.Cust takes his/her cart
                CartObject cart = (CartObject) session.getAttribute("CUSTCART");
                if (cart != null) {
                    //3.Check items are existed
                    Map<String, BookDTO> items = cart.getItems();
                    if (items != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Image</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <!--<th>Remove</th>-->
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <form action = "DispatchServlet">
                <%
                    int count = 0;
                    float totalPrice = 0;
                    for (String itemKey : items.keySet()) {
                %>
                <tr>
                    <td><%= ++count%></td>
                    <td><%= items.get(itemKey).getBookName()%>
                        <input type="hidden" value="<%= items.get(itemKey).getBookId()%>" name="txtItemKey"/>
                    </td>
                    <td><img src ="<%= items.get(itemKey).getBookImg()%>" width=100></td>
                    <td><%= items.get(itemKey).getQuantity()%></td>
                    <td><%= items.get(itemKey).getBookPrice()%> $ </td>
                    <td><%= items.get(itemKey).getBookPrice() * items.get(itemKey).getQuantity()%> $</td>
                    <td><input type="checkbox" name="chkAction" value="<%= items.get(itemKey).getBookId()%>" /> </td>
                        <% totalPrice = totalPrice + items.get(itemKey).getBookPrice() * items.get(itemKey).getQuantity(); %>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td colspan="5" style ="font-weight: bolder">Total Price</td>
                    <td style ="font-weight: bolder"><%=totalPrice%> $</td>
                    <td><input type="submit" value="Remove" name="btAction" /></td>
                </tr>
                <tr> <td colspan="7"><a href="DispatchServlet?btAction=Go to shopping book now">Add more item</a></td> </tr>
            </form>
        </tbody>
    </table>
    <form action = "DispatchServlet">
        <input type="submit" value="Check out" name="btAction" />
    </form>

    <%
    } else {
    %>
    <h2>No existed item in your cart</h2>
    <a href="DispatchServlet?btAction=Go to shopping book now">Return shopping page</a>
    <%
        }
    } else {
    %><h2>No existed item in your cart</h2>
    <a href="DispatchServlet?btAction=Go to shopping book now">Return shopping page</a>
    <%
            }

        }
    %>

</body>
</html>
