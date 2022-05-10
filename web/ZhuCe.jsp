<%--
  Created by IntelliJ IDEA.
  User: 悦耳
  Date: 2022/4/13
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <!--jQuery-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <!--semantic-UI-->
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</head>
<body>
<form class="ui form" action="/addUser" method="post">


    <div class="field">
        <label>账号</label>
        <div class="field">

        </div>
    </div>

    <div class="field">
        <label>昵称</label>
        <div class="field">
            <input type="text" name="user_nickname" placeholder="用户昵称" style="width:300px;">
        </div>
    </div>

    <div class="field">
        <label>生日</label>
        <div class="field">
            <input type="date" name="user_birthday" placeholder="用户生日" style="width:300px;">
        </div>
    </div>

    <div class="field">
        <label>国家</label>
        <div class="field">
            <input type="text" name="city" placeholder="国家" style="width:300px;">
        </div>
    </div>

    <div class="field">
        <label>密码</label>
        <div class="field">
            <input type="password" name="user_password" placeholder="用户密码"  style="width:300px;">
        </div>
    </div>





    <div class="field">
        <label>电话</label>
        <div class="field">
            <input type="text" name="user_phone" placeholder="用户电话" style="width:300px;">
        </div>
    </div>




    <button class="ui primary button" type="submit">
        提交
    </button>

</form>

<script>
    $('.ui.radio.checkbox')
        .checkbox()
    ;
</script>
</body>
</html>
