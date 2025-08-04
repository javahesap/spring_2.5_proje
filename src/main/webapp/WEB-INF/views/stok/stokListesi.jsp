<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Stok Listesi</title>
</head>
<body>
<h2>Stok Listesi</h2>
<a href="stok?action=ekleForm">Yeni Stok Ekle</a>
<table border="1">
    <tr><th>ID</th><th>Ad</th><th>Miktar</th><th>Fiyat</th><th>İşlem</th></tr>
    <c:forEach var="s" items="${liste}">
        <tr>
            <td>${s.id}</td>
            <td>${s.ad}</td>
            <td>${s.miktar}</td>
            <td>${s.fiyat}</td>
            <td>
                <a href="stok?action=duzenleForm&id=${s.id}">Düzenle</a> |
                <a href="stok?action=sil&id=${s.id}">Sil</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
