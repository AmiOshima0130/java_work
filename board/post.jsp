<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>記事詳細</title>
</head>
<body>
    <%--index.jspから「記事名」と「内容」をとってくる--%>
    <%
    //初期化
    String error = "";//エラーメッセージ用の変数をif文の外で宣言
    String author = request.getParameter("author");
    String postname = request.getParameter("postname");
    String posttext = request.getParameter("posttext");
    String IPaddress = request.getRemoteAddr();//IPアドレスを取得
    String cliantName = request.getRemoteHost();//クライアント名を取得
    String URI = request.getRequestURI();
    Date datetime = new Date();// 現在の日時を取得
    SimpleDateFormat format_date = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");// 日付フォーマット用のオブジェクトを作成
    String formatted_date = format_date.format(datetime);// 日時を指定したフォーマットに変換 
    String[] postDatas = new String[]{author, postname, posttext, formatted_date, IPaddress, cliantName, URI};

    if(postname.isEmpty() || posttext.isEmpty() || author.isEmpty()) {
        error = "投稿者・記事名・内容のどれかが入力されていません";
    } else {
        //記事の処理
        ArrayList<String[]> posts = (ArrayList<String[]>) application.getAttribute("posts");
        if(posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(postDatas);//トピック情報をリストに追加
        application.setAttribute("posts", posts);//更新されたリストをアプリケーションスコープに保存
        error = "記事が投稿されました";//成功メッセージ
    }

        //JSPにおいては、エラーメッセージをリクエストスコープに追加が必要
        //1回の投稿=1回のリクエストなのでrequestスコープを使用
        request.setAttribute("errorMessage", error);
    %>
    
    <!---->
    <% if(!"".equals(error)) { %>
        <h1><%=error %></h1>
    <% } %>
    
    <a href="index.jsp">記事一覧へ戻る</a>

    <p><%=formatted_date %></p>

</body>
</html>