<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8" />
    <title>Adres Listesi</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div class="container mt-4">
    <h2>Adres Listesi</h2>
    <a href="ekleForm.html" class="btn btn-primary mb-3">Yeni Adres Ekle</a>
    
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>İl</th>
            <th>İlçe</th>
            <th>Adres Detay</th>
            <th>İşlemler</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="adres" items="${liste}">
            <tr>
                <td>${adres.id}</td>
                <td>${adres.il}</td>
                <td>${adres.ilce}</td>
                <td>${adres.adresDetay}</td>
                <td>
                    <a href="duzenleForm.html?id=${adres.id}" class="btn btn-sm btn-warning">Düzenle</a>
                    <a href="sil.html?id=${adres.id}" class="btn btn-sm btn-danger" 
                       onclick="return confirm('Silmek istediğinize emin misiniz?');">Sil</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
