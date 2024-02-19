<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <title>お問い合わせフォーム</title>
</head>
<body>
    
    <h1>確認画面</h1>
    <div class="form">
        <form action="thanks.jsp" method="POST">
            <div>
                <% 
                String name = request.getParameter("name");
                %>
                <p>名前：　<%=name %>です</p>
            </div>
            <div>
                <% 
                String tel = request.getParameter("tel");
                %>
                <p>電話番号：　<%=tel %>です</p>
            </div>
            <div>
                <% 
                String prefecture = request.getParameter("prefecture");
                %>
                <p>住んでいる県：　<%= prefecture%>です</p>
            </div>
            <div>
                <% 
                String bloodtype = request.getParameter("bloodtype");
                %>
                <p>血液型：　<%= bloodtype%>型です</p>
            </div>

            <input type="submit" value="送信してよいですか">
        </form>
    </div>

</body>
</html>