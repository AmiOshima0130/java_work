<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>掲示板を作成練習</title>
</head>
<body>
    
    <h1>記事を投稿する</h1>

    <div class="form">
        <form action="post.jsp" method="POST"><!--actionで指定するのはデータの送信先 -->
            <p>投稿者：　<input type="text" name="author"></p>
            <p>記事名：　<input type="text" name="postname"></p>
            <p>内容：　<textarea name="posttext" id="" cols="100" row="10"></textarea></p>
            <input type="submit" value="投稿する">
        </form>
    </div>

    <hr>

    <h2>投稿された記事一覧</h2>
    <%
    ArrayList<String[]> posts = (ArrayList<String[]>) application.getAttribute("posts");
    if(posts == null) {//初期化
        posts = new ArrayList<>();
        application.setAttribute("posts", posts);
    }
    %>

    <div class="posts">
        <%
        //iは配列の個数。配列は0から始まるので-1。0以下になるまで減る。配列3210の順番にとる。
        for(int i=posts.size()-1; i>=0; i--) {
            String[] post = posts.get(i);
        %>
        <section>
            <p class="author">投稿者：<%=post[0] %></p>
            <p class="name">記事名：<%=post[1] %></p>
            <p class="text">内容：<%=post[2] %></p>
            <p class="text">投稿日：<%=post[3] %></p>
            <p class="text">IPアドレス：<%=post[4] %></p>
            <p class="text">クライアント名：<%=post[5] %></p>
            <p class="text">URI：<%=post[6] %></p>
        </section>
        <%
        }
        %>
        <section>
            <p class="name">サンプルネーム</p>
            <p class="text">テキストが入ります。テキストが入ります。テキストが入ります。テキストが入ります。テキストが入ります。</p>
        </section>
    </div>
    
</body>
</html>