<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Example JSP</title>
</head>
<body>
    <h2>Merhaba Urun!</h2>

    <form method="post">
        İsminiz: <input type="text" name="name" />
        <input type="submit" value="Gönder" />
    </form>

    <%
        String name = request.getParameter("name");
        if (name != null && !name.trim().isEmpty()) {
    %>
        <h3>Merhaba, <%= name %>!</h3>
    <%
        }
    %>
</body>
</html>
