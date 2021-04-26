<%-- 
    Document   : shopping
    Created on : Oct 18, 2020, 3:36:52 AM
    Author     : tamda
--%>

<%@page import="dangddt.book.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Book Market</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <h1 style="display: inline">Book Market</h1>
            <form style ="display: inline; position: absolute; right: 10px"action="DispatchServlet">
                <i class="fa fa-shopping-cart" style="font-size: 35px;margin-right: 10px"></i><input type="submit" value="View your cart" name="btAction" />
            </form>
        </div>
        <!--Choose book <select name ="cboBook">
            <option>Java</option>
            <option>JDK</option>
            <option>Netbeans</option>
            <option>Tomcat</option>
            <option>JSP</option>
            <option>Struts</option>
        </select><br/>-->
        <%
            int count = 0;
            List<BookDTO> bookList = (List<BookDTO>) request.getAttribute("BOOKSHOP");
        %>
        <!--<div id="content" class="container">-->
        <div id = "tableBook" style="display: inline-flex; margin-top: 20px">
            <div><table border="2">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Name of Book</th>
                            <th width = 100px>Price</th>
                            <th>Image</th>
                            <th width = 150px>Add to cart</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (BookDTO dto : bookList) {
                        %>
                    <form action="DispatchServlet">
                        <tr>
                            <td><%= ++count%></td>
                            <td><%= dto.getBookName()%>
                                <input type="hidden" value="<%= dto.getBookId()%>" name="txtItemKey"/>
                                <input type="hidden" value="<%= dto.getBookName()%>" name="txtItemName"/>
                            </td>
                            <td width = 100px><%= dto.getBookPrice()%> $
                                <input type="hidden" value="<%= dto.getBookPrice()%>" name="txtItemPrice"/>
                            </td>
                            <td><img alt = "<%= dto.getBookDescription()%>" src="<%= dto.getBookImg()%>" width="100px" onclick="preview(this)"> 
                                <input type="hidden" value="<%= dto.getBookImg()%>" name="txtItemImg"/>
                            </td>
                            <td><i class="fa fa-cart-plus" style="font-size: 20px;margin-right: 10px"></i><input type="submit" value="Add to Cart" name="btAction"</td>
                        </tr>
                    </form>
                    </tbody>
                    <%
                        }
                    %>

                </table>
            </div>
            <div  id = "detailBook" style="display: none; margin-left: 100px; border: 2px solid black; padding: 20px; width: 700px; height: 500px;"> 
                <div><h1 style="text-align: center">Preview Book</h1></div>
                <div style ="text-align:center"><img  id = "previewPic" src="" width = "200px" height="250px"></div>
                <p id = "description"></p>
            </div>
            <div>
                <div><img src="https://scontent.fsgn5-5.fna.fbcdn.net/v/t1.15752-9/120917142_645660836137700_3588850812620163881_n.jpg?_nc_cat=108&_nc_sid=ae9488&_nc_ohc=uZdaaCJ-USgAX91ys9d&_nc_ht=scontent.fsgn5-5.fna&oh=0d28538f5ef7af318216916f8f085a19&oe=5FB6A99A" style = "display: inline-flex;width:250px;position:absolute;right:20px"></div>
            </div>
        </div>

        <script type="text/javascript">
            function preview(previewPic) {
                var src = previewPic.getAttribute('src');
                document.getElementById('detailBook').style.display = "inline-table";
                document.getElementById('previewPic').src = src;
                var description = previewPic.getAttribute('alt');
                if (description !== "null") {
                    document.getElementById('description').innerHTML = description;
                } else {
                    document.getElementById('description').innerHTML = "Updating";
                }
            }
        </script>



    </body>
</html>
