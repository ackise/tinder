<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.tinder.repository.models.User" %>
<%@ page import="com.tinder.repository.services.UserService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tinder.repository.services.LikedService" %>
<%@ page import="java.util.ArrayList" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="panel panel-default user_panel">
                <div class="panel-heading">
                    <h3 class="panel-title">User List</h3>
                </div>
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">
                            <%UserService userService = new UserService();%>
                            <%User user = userService.getUserById(5);%>
                            <%ArrayList<Integer> likedList = (ArrayList<Integer>) new LikedService().getUserLikedList(user.getId());%>
                            <tbody>
                                <% for (int i = 0; i < likedList.size(); i += 1) { %>
                                    <%User likedUser = userService.getUserById(likedList.get(i));%>
                                    <tr>
                                        <td width="10">
                                            <div class="avatar-img">
                                                <img class="img-circle" src=<%=likedUser.getAvatar()%> />  
                                            </div>
                                        </td>
                                        <td class="align-middle">
                                            <%=likedUser.getName()%>
                                        </td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>