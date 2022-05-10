<%--
  Created by IntelliJ IDEA.
  User: 悦耳
  Date: 2022/4/20
  Time: 16:18
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

    <style>
        *{
            letter-spacing: 4px;
            font-weight: 400;
        }

        img{
            margin-top: 15px;
            border: 1px solid #ccc;
            width: 100%;
            height: 100%;
            max-width: 150px;
            max-height: 150px;
            background-size: contain;
            background-repeat: no-repeat;
            background-position: center center;
        }
    </style>

    <script type="text/javascript">
        $(function(){
            $('#upLoad').on('change',function(){
                var filePath = $(this).val(),         //获取到input的value，里面是文件的路径
                    fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(),
                    imgBase64 = '',      //存储图片的imgBase64
                    fileObj = document.getElementById('upLoad').files[0]; //上传文件的对象,要这样写才行，用jquery写法获取不到对象

                // 检查是否是图片
                if( !fileFormat.match(/.png|.jpg|.jpeg/) ) {
                    alert('上传错误,文件格式必须为：png/jpg/jpeg');
                    return;
                }

                // 调用函数，对图片进行压缩
                compress(fileObj,function(imgBase64){
                    imgBase64 = imgBase64;    //存储转换的base64编码
                    $('#viewImg').attr('src',imgBase64); //显示预览图片
                });
            });

            // 不对图片进行压缩，直接转成base64
            function directTurnIntoBase64(fileObj,callback){
                var r = new FileReader();
                // 转成base64
                r.onload = function(){
                    //变成字符串
                    imgBase64 = r.result;
                    console.log(imgBase64);
                    callback(imgBase64);
                }
                r.readAsDataURL(fileObj);    //转成Base64格式
            }

            // 对图片进行压缩
            function compress(fileObj, callback) {
                if ( typeof (FileReader) === 'undefined') {
                    console.log("当前浏览器内核不支持base64图标压缩");
                    //调用上传方式不压缩
                    directTurnIntoBase64(fileObj,callback);
                } else {
                    try {
                        var reader = new FileReader();
                        reader.onload = function (e) {
                            var image = $('<img/>');
                            image.load(function(){
                                square = 700,   //定义画布的大小，也就是图片压缩之后的像素
                                    canvas = document.createElement('canvas'),
                                    context = canvas.getContext('2d'),
                                    imageWidth = 0,    //压缩图片的大小
                                    imageHeight = 0,
                                    offsetX = 0,
                                    offsetY = 0,
                                    data = '';

                                canvas.width = square;
                                canvas.height = square;
                                context.clearRect(0, 0, square, square);

                                if (this.width > this.height) {
                                    imageWidth = Math.round(square * this.width / this.height);
                                    imageHeight = square;
                                    offsetX = - Math.round((imageWidth - square) / 2);
                                } else {
                                    imageHeight = Math.round(square * this.height / this.width);
                                    imageWidth = square;
                                    offsetY = - Math.round((imageHeight - square) / 2);
                                }
                                context.drawImage(this, offsetX, offsetY, imageWidth, imageHeight);
                                var data = canvas.toDataURL('image/jpeg');
                                //压缩完成执行回调
                                callback(data);
                            });
                            image.attr('src', e.target.result);
                        };
                        reader.readAsDataURL(fileObj);
                    }catch(e){
                        console.log("压缩失败!");
                        //调用直接上传方式  不压缩
                        directTurnIntoBase64(fileObj,callback);
                    }
                }
            }
        });
    </script>
</head>
<body onload="">

<!-- Page Contents -->
<div class="pusher">
    <div class="ui inverted vertical masthead center aligned segment">

        <div class="ui container">
            <div class="ui large secondary inverted pointing menu">
                <a class="toc item">
                    <i class="sidebar icon"></i>
                </a>
                <a class="active item">主页</a>
                <a class="item">用户列表</a>
                <a class="item">添加产品</a>
                <div class="right item">
                    <a class="ui inverted button">登录</a>
                    <a class="ui inverted button">注册</a>
                </div>
            </div>
        </div>

        <div class="ui text container">
            <h1 class="ui inverted header">
                添加产品
            </h1>
            <h2>你可以添加本公司的产品</h2>
            <div class="ui huge primary button">开始！<i class="right arrow icon"></i></div>
        </div>

    </div>

    <div class="ui vertical stripe quote segment">
        <div class="ui equal width stackable internally celled grid">
            <div class="center aligned row">
                <div class="column">
                    <h4 class="ui horizontal divider header">
                        <i class="tag icon"></i>
                        添加产品
                    </h4>
                    <form class="ui form" enctype="multipart/form-data" action="/addProduct" method="post">
                        <div class="ui segment" style="width: 75%;margin: 0 auto;text-align: center">
                            <div class="ui two column very relaxed grid">
                                <div class="column">
                                    <div class="field" style="width: 50%">
                                        <label>产品名称</label>
                                        <input type="text" name="productName" placeholder="产品名称">
                                    </div>
                                    <div class="field" style="width: 50%">
                                        <label>产品价格</label>
                                        <input type="text" name="productPrice" placeholder="产品价格">
                                    </div>
                                    <div class="field" style="width: 50%">
                                        <label>产品数量</label>
                                        <input type="text" name="productNumber" placeholder="产品数量">
                                    </div>
                                </div>
                                <div class="column">
                                    <input type="file" id="upLoad" name="image" >
                                    <!-- 显示上传之后的图片 -->
                                    <div id='previewImg'>
                                        <img src="" id='viewImg'/>
                                    </div>
                                </div>
                            </div>
                            <div class="ui vertical divider">
                                and
                            </div>
                        </div>
                        <button class="ui primary button" type="submit">提交</button>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <div class="ui inverted vertical footer segment">
        <div class="ui container">
            <div class="ui stackable inverted divided equal height stackable grid">
                <div class="three wide column">
                    <h4 class="ui inverted header">About</h4>
                    <div class="ui inverted link list">
                        <a href="#" class="item">Sitemap</a>
                        <a href="#" class="item">Contact Us</a>
                        <a href="#" class="item">Religious Ceremonies</a>
                        <a href="#" class="item">Gazebo Plans</a>
                    </div>
                </div>
                <div class="three wide column">
                    <h4 class="ui inverted header">Services</h4>
                    <div class="ui inverted link list">
                        <a href="#" class="item">Banana Pre-Order</a>
                        <a href="#" class="item">DNA FAQ</a>
                        <a href="#" class="item">How To Access</a>
                        <a href="#" class="item">Favorite X-Men</a>
                    </div>
                </div>
                <div class="seven wide column">
                    <h4 class="ui inverted header">Footer Header</h4>
                    <p>Extra space for a call to action inside the footer that could help re-engage users.</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
