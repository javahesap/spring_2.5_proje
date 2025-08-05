<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Kullanıcı Listesi</title></head>
<body>
<h2>Kullanıcı Listesi</h2>
<table border="1">
    <tr><th>ID</th><th>Username</th><th>Email</th><th>Sil</th></tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td><a href="delete.htm?id=${user.id}">Sil</a></td>
        </tr>
    </c:forEach>
</table>

<h3>Yeni Kullanıcı Ekle</h3>
<form method="post" action="save.htm">
    Username: <input type="text" name="username" /><br />
    Password: <input type="password" name="password" /><br />
    Email: <input type="text" name="email" /><br />
    <input type="submit" value="Kaydet" />
</form>
</body>
</html>
