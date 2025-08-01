<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yeni Ürün Ekle</title>
</head>
<body>
<h2>Yeni Ürün Ekle</h2>

<form action="urunKaydet.html" method="post">
    <label>Ürün Adı:</label><br/>
    <input type="text" name="ad" required/><br/><br/>

    <label>Fiyat:</label><br/>
    <input type="number" step="0.01" name="fiyat" required/><br/><br/>

    <input type="submit" value="Kaydet"/>
    <a href="urunler.html">İptal</a>
</form>

</body>
</html>
