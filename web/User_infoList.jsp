<%--
  Created by IntelliJ IDEA.
  User: 悦耳
  Date: 2022/4/13
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 导入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 导入时间的格式化标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.1/css/bulma.min.css">
    <!--jQuery-->
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <!--semantic-UI-->
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</head>
<body onload="ShowMsg()">
<%--<% out.print("用户列表："+request.getAttribute("list"));%>--%>
<input type="text" class="ui icon input" placeholder="搜索..." id="select" style="width: 600px;height: 40px">

<button class="ui primary button" onclick="selectUser()">搜索</button>

<button class="ui primary button" onclick="a()">显示全部</button>

<table class="ui celled table" style="width: 900px">
    <thead>
    <tr>
        <th style="width: 100px">编号</th>
        <th style="width: 100px">昵称</th>
        <th style="width: 100px">国家</th>
        <th style="width: 200px">生日</th>
        <th style="width: 120px">删除</th>
        <th style="width: 120px">修改</th>
    </tr></thead>
    <tbody id="test">
    <c:forEach items="${list}" var="user_info" varStatus="vs">
        <tr>
            <input type="text" style="display: none;" value="${user_info.getUser_id()}">
            <td data-label="Name">${vs.count}</td>
            <td data-label="Name">${user_info.getUser_nickname()}</td>
            <td data-label="Age">${user_info.getUser_city()}</td>
            <td data-label="Job">${user_info.getUser_birthday()}</td>
            <td>
                <div class="ui labeled button" tabindex="0" onclick="deleteByUser_id(${user_info.getUser_id()})">
                    <div class="ui red button" >
                        <i class="window close outline icon"></i>
                    </div>
                    <a class="ui basic red left pointing label">
                        删除
                    </a>
                </div>
                </td>
            <td>
                <div class="ui labeled button" tabindex="0" onclick="openUpdateUser(${user_info.getUser_id()});">
                    <div class="ui basic blue button">
                        <i class="edit outline icon"></i>
                    </div>
                    <a class="ui basic left pointing blue label">
                        编辑
                    </a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>


</table>
<nav class="pagination is-centered is-rounded is-small" role="navigation" aria-label="pagination" style="width: 600px">
    <a class="pagination-previous" onclick="previous()">上一页</a>
    <a class="pagination-next" onclick="next()">下一页</a>
    <ul class="pagination-list">
        <li><a class="pagination-link is-current">1</a></li>
        <li><a class="pagination-link">2</a></li>
    </ul>
</nav>

<div class="ui modal">
    <i class="close icon"></i>
    <div class="header">
        修 改 用 户
    </div>
    <div class="content">
        <form action="" method="post">
            <input style="display: none" value="" id="user_id">

            <div class="description" style="padding: 20px">
                <div class="ui action input">
                    <button class="ui primary disabled button">昵称</button>
                    <input type="text" value="昵称" id="user_nickname">
                </div>
            </div>

            <div class="description" style="padding: 20px">
                <div class="ui action input">
                    <button class="ui primary disabled button">国家</button>
                    <input type="text" value="国家" id="user_city">
                </div>
            </div>

            <div class="description" style="padding: 20px">
                <div class="ui action input">
                    <button class="ui primary disabled button">生日</button>
                    <input type="text"  value="生日" id="user_birthday">
                </div>
            </div>
        </form>
    </div>
    <div class="actions">
        <div class="ui black right labeled icon button">
            取 消
            <i class="close icon"></i>
        </div>
        <div class="ui positive right labeled icon button" onclick="updateUser()">
            确 认
            <i class="checkmark icon"></i>
        </div>
    </div>
</div>
<script type="text/javascript">
    var elementById = document.getElementById("user_id");
    var elementById2 = document.getElementById("user_city");
    var elementById3 = document.getElementById("user_birthday");
    var elementById4 = document.getElementById("user_nickname");
    var curr=1;
    function previous() {

     var b=   document.getElementsByClassName("pagination-link is-current");
     var c=   document.getElementsByClassName("pagination-link");

        for(var i=0;i<c.length;i++){
            if(c[i].className==b[0].className && i!=0){
                c[i].className="pagination-link";
                c[i-1].className="pagination-link is-current";
                curr--;
                break;
            }
        }

        window.location.href="${pageContext.request.contextPath}/Paging?curr="+curr+"&size="+3;
    }
    function next() {

        var b=   document.getElementsByClassName("pagination-link is-current");
        var c=   document.getElementsByClassName("pagination-link");

        for(var i=0;i<c.length;i++){
            if(c[i].className==b[0].className && i!=c.length-1){
                c[i].className="pagination-link";
                c[i+1].className="pagination-link is-current";
                curr++;
                break;
            }
        }

        window.location.href="${pageContext.request.contextPath}/Paging?curr="+curr+"&size="+3;

    }
    function  deleteByUser_id(user_id) {
        if(confirm("确定删除此数据吗？")){
            location.href="${pageContext.request.contextPath}/deleteUser?user_id="+user_id
        }
    }
    function ShowMsg() {
        if(${pageContext.request.getAttribute("msg")=="删除失败"}||${pageContext.request.getAttribute("msg")=="删除成功"}){
            var a="${pageContext.request.getAttribute("msg")}";
            alert(a)
        }

        if(${pageContext.request.getAttribute("msg2")=="暂无搜索结果"}){
            var elementById = document.getElementById("msg");
            elementById.innerHTML="${pageContext.request.getAttribute("msg2")}";
        }

        if(${pageContext.request.getAttribute("curr")!=null}){
           curr="${pageContext.request.getAttribute("curr")}";

            var c   =   document.getElementsByClassName("pagination-link");
            var b   =   document.getElementsByClassName("pagination-link is-current");

            b[0].className="pagination-link";
            c[curr-1].className="pagination-link is-current";

        }
    }
    function selectUser(){
        var elementById = document.getElementById("select").valueOf();

        var select=elementById.value;
        if(select!=""&&select!=null){
            document.write("<form action='/selectUser' method='post' name='form1' style='display:none'>");
            document.write("<input type='hidden' name='select' value="+select+">");
            document.write("</form>");
            document.form1.submit();
        }else {
            alert("你搜索内容为空！请重写输入")
        }
    }
    function a() {
        location.href="${pageContext.request.contextPath}/listUser"
    }
    function openUpdateUser(user_id){
        $('.ui.modal')
            .modal('show')
        ;

        console.log(user_id!=null)

        $.ajax({
            url:"${pageContext.request.contextPath}/SelectUserById?user_id="+user_id,
            type:"post",
            dataType:"json",
            error:function () {
                console.log("ajax请求数据失败！");
            },
            success: function (data) {
                elementById.value=data.user_id;
                elementById2.value=data.user_city;
                elementById3.value=data.user_birthday;
                elementById4.value=data.user_nickname;
            }
        });
    }
    function updateUser() {
        var user_id=elementById.value;
        var user_city=elementById2.value;
        var user_birthday=elementById3.value;
        var user_nickname=elementById4.value;

        document.write("<form action='/updateUser' method='post' name='form2' style='display:none'>");
        document.write("<input type='hidden' name='user_id' value="+user_id+">");
        document.write("<input type='hidden' name='user_birthday' value="+user_birthday+">");
        document.write("<input type='hidden' name='user_city' value="+user_city+">");
        document.write("<input type='hidden' name='user_nickname' value="+user_nickname+">");
        document.write("</form>");
        document.form2.submit();
    }
</script>

</body>
</html>
