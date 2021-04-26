<%-- 
    Document   : search
    Created on : Oct 9, 2020, 11:25:42 AM
    Author     : tamda
--%>


<%@page import="dangddt.student.StudentDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>

    <body>
        <font color ="red">
        Welcome, ${sessionScope.FULLNAME.fullname}
        </font>
        <form action="DispatchServlet">
            <input type="submit" value="Logout" name="btAction" />
        </form>
        <%


        %>
        <h1>Search Page</h1>
        <form action="DispatchServlet">
            Search: <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search" name="btAction" />
        </form>
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Fullname</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action = "DispatchServlet">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.username}
                                    <input type="hidden" name="txtUsername"
                                           value = "${dto.username}"/>
                                </td>
                                <td>${dto.password}
                                    <input type="hidden" name="txtPassword"
                                           value = "${dto.password}"/>
                                </td>
                                <td>${dto.fullname}
                                    <input type="hidden" name="txtFullname"
                                           value = "${dto.fullname}"/>
                                </td>
                                <td><input type="checkbox" name="chkAdmin" value="ON"
                                           <c:if test="${dto.role}"> checked = "checked" </c:if>
                                               />
                                    </td>
                                    <td>
                                    <c:url var = "deleteLink" value = "delete">
                                        <c:param name = "btAction" value = "Delete"/>
                                        <c:param name = "pk" value="${dto.username}"/> 
                                        <c:param name = "lastSearchValue" value = "${searchValue}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>

                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>No record with this keyword</h2>
        </c:if>
    </c:if>
    <%--<%
        String searchValue = request.getParameter("txtSearchValue");
        if (searchValue != null) {
            List<StudentDTO> result = (List<StudentDTO>) request.getAttribute("SEARCHRESULT");
            if (result != null) {
    %>
    <div id = "content" class = "container">
        <div id = "table" style="display: inline-flex">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Full name</th>
                        <th>Role</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 0;
                        for (StudentDTO dto : result) {

                        %>
                    <form action="DispatchServlet">
                        <tr onmouseover= "showDetail('<%= dto.getUsername()%>', '<%= dto.getPassword()%>', '<%= dto.getFullname()%>', '<%= dto.isRole()%>')">
                            <td>
                                <%= ++count%>
                            </td>

                            <td>
    <%--<%=dto.getUsername()%>
    <input type="text" name="txtUsername"
           value = "<%= dto.getUsername()%>"/>
</td>
<td>
    <input type="text" name="txtPassword"
           value = "<%= dto.getPassword()%>"/>
</td>
<td>
    <input type="text" name="txtFullname"
           value = "<%= dto.getFullname()%>"/>
</td>
<td>
    <input type="checkbox" name="chkAdmin"
           value = "<%= dto.isRole()%>"
           <% if (dto.isRole())%> checked = "checked"/>
</td>
<td>
    <input type="submit" value="Delete" name="btAction" />
    <input type="hidden" name="lastSearchName" value="<%= searchValue %>" />
</td>                            
<td>
    <input type="submit" value="Update" name="btAction" />
    <input type="hidden" name="lastSearchName" value="<%= searchValue %>" />
</td>
</tr>

</form>

                    <%
                        }//end for dto
                    %>

                    </tbody>

                </table>
            </div> 

            <div style ="display: inline-table; margin-left: 100px; border: solid 2px black; padding: 10px 100px 10px 10px; width: 300px">
                    <h1>STUDENT DETAIL</h1>
                    <div id="showUsername">Username:</div><br>
                    <div id="showPassword">Password:</div><br>
                    <div id="showFullname">Fullname:</div><br>
                    <div id="showRole">Role:</div><br>
            </div>
            <style> 
                #confirmUpdate{
                    display: none;
                }
            </style>
            <script type="text/javascript">
                function showDetail(username, password, fullname, isAdmin) {
                    var nullString = null;
                    document.getElementById('showUsername').innerHTML = "Username:" + username;
                    document.getElementById('showPassword').innerHTML = "Password:" + password;
                    document.getElementById('showFullname').innerHTML = "Fullname:" + fullname;
                    if (isAdmin==='true') {
                        document.getElementById('showRole').innerHTML = "Role: Admin";
                    } else {
                        document.getElementById('showRole').innerHTML = "Role: User";
                    }
                }
            </script>
        </div>

        <%
        } else {
        %>
        <h2>
            No Record is matched!!!
        </h2>
        <%
                }
            }
        %> --%> 
</body>
</html>
