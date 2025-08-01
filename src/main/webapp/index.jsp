<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <title>Hoş Geldiniz</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #6dd5fa, #2980b9);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
        }
        .welcome-container {
            text-align: center;
            background: rgba(255, 255, 255, 0.1);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.3);
        }
        .welcome-container h1 {
            font-size: 36px;
            margin-bottom: 20px;
        }
        .welcome-container p {
            font-size: 18px;
        }
        .btn {
            margin-top: 25px;
            padding: 10px 25px;
            background-color: #ffffff;
            color: #2980b9;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
        }
        .btn:hover {
            background-color: #ecf0f1;
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h1>Uygulamamıza Hoş Geldiniz</h1>
        <p>Spring 2.5 tabanlı bu uygulama size harika özellikler sunar.</p>
        <a href="http://localhost:8016/Spring2_5HelloWorld/urun/listele.html" class="btn">Urun Listesi</a>
          <a href="http://localhost:8016/Spring2_5HelloWorld/adres/adreslistele.html" class="btn">Adresler</a>
            <a href="http://localhost:8016/Spring2_5HelloWorld/urun/urunEkle.html" class="btn">Ürün Ekle</a>
              <a href="adres/listeleme.do" class="btn">Başla</a>
              
    </div>
</body>
</html>
