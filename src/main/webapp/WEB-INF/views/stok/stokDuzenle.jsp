<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Stok Güncelle</title></head>
<body>
<h2>Stok Güncelle</h2>
<form action="guncelle.html" method="post">
    <input type="hidden" name="id" value="${stok.id}">
    Ad: <input type="text" name="ad" value="${stok.ad}"><br>
    Miktar: <input type="number" name="miktar" value="${stok.miktar}"><br>
    Fiyat: <input type="text" name="fiyat" value="${stok.fiyat}"><br>
    <input type="submit" value="Güncelle">
</form>
</body>
</html>
