<h2>Adres Güncelle</h2>
<form action="guncelle.html" method="post">
    <input type="hidden" name="id" value="${adres.id}" />
    İl: <input type="text" name="il" value="${adres.il}" /><br/>
    İlçe: <input type="text" name="ilce" value="${adres.ilce}" /><br/>
    Detay: <textarea name="adresDetay">${adres.adresDetay}</textarea><br/>
    <input type="submit" value="Güncelle" />
</form>
