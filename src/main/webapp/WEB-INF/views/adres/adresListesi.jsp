<h2>Adres Listesi</h2>
<a href="ekleForm.html">Yeni Adres Ekle</a>
<table border="1">
<tr><th>ID</th><th>İl</th><th>İlçe</th><th>Detay</th><th>İşlemler</th></tr>
<c:forEach var="a" items="${liste}">
<tr>
    <td>${a.id}</td>
    <td>${a.il}</td>
    <td>${a.ilce}</td>
    <td>${a.adresDetay}</td>
    <td>
        <a href="duzenleForm.html?id=${a.id}">Düzenle</a> |
        <a href="sil.html?id=${a.id}">Sil</a>
    </td>
</tr>
</c:forEach>
</table>
