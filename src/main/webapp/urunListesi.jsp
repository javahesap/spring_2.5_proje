<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Urun" %>

<html>
<head><title>Ürün Listesi</title></head>
<body>
  <h2>Ürünler</h2>
  <table border="1">
    <tr>
      <th>ID</th>
      <th>Ad</th>
      <th>Fiyat</th>
    </tr>
    <%
      List<Urun> urunler = (List<Urun>) request.getAttribute("liste");
      for (Urun u : urunler) {
    %>
    <tr>
      <td><%= u.getId() %></td>
      <td><%= u.getAd() %></td>
      <td><%= u.getFiyat() %></td>
    </tr>
    <% } %>
  </table>
</body>
</html>
