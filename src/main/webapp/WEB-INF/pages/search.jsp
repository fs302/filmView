<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <title>LXT</title>
    <meta name="description" content="LLLLL！" />

    <meta name="HandheldFriendly" content="True" />
    <meta name="MobileOptimized" content="320" />

    <link rel="shortcut icon" type="image/x-icon" href="<%=basepath%>favicon.ico" media="screen" />
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" />


    <link href="<%=basepath%>skin/square/grey.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="<%=basepath%>view.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
<body class="archive-template">



<div class="wrap">
    <nav class="navbar navbar-fixed-top head-nav" role="navigation">
        <div class="container">
            <div class="navbar-header" >
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">FilmView</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">查询</a></li>
                    <li><a href="newFilm">新增</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a data-spm-anchor-id="0.0.0.0">你好，LXT</a></li>
                    <li><a target="_top" href="login" data-spm-anchor-id="0.0.0.0">Exit <span class="glyphicon glyphicon-log-out"></span></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
    <div class="header" style="background-image: url(<%=basepath%>img/bg.jpg)">
        <div class="container">
            <div class="search-bar">
                <form class="form-inline " role="search" action="search" namespace="/" method="get">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3">
                            <input name="query" type="text" class="input-lg input-bigger search" placeholder="Search..." />
                            <button type="submit" class="btn abutton"><span class="glyphicon glyphicon-search"></span> </button>
                        </div>
                    </div>
                    <div class="col-md-4 col-md-offset-4">
                        <input type="radio" name="type" value="all" checked> 全部
                        <input type="radio" name="type" value="name"> 片名
                        <input type="radio" name="type" value="director"> 导演
                        <input type="radio" name="type" value="star"> 主演
                        <input type="radio" name="type" value="type"> 类型
                    </div>
                </form>
            </div>
        </div>
    </div>


    <main class="main" role="main">
        <div class="container">
            <div class="result">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th >FilmName </th>
                        <th style="width:25%">Info </th>
                        <th style="width:60%">Content </th>
                        <th  style="width:10%">Review </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td align="center"><a href="http://movie.douban.com/subject/25789352/"> 心花路放</a></td>
                        <td><s:property value="Context"/></td>
                        <td><s:property value="query"/></td>
                        <td><s:property value="type"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </main>

</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="submit">
                    <p class="text-center"><a href="mailto:lxt@uestc.edu.cn">lxt@uestc.edu.cn</a> </p>
                    <p><h2 class="text-center">Kindle</h2></p>
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.lazyload/1.9.0/jquery.lazyload.min.js"></script>
<script src="http://cdn.bootcss.com/magnific-popup.js/0.9.9/jquery.magnific-popup.min.js"></script>
<script src="<%=basepath%>js/icheck.js"></script>

<script>
    $(document).ready(function(){
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-grey',
            radioClass: 'iradio_square-grey'
        });
    });
</script>

</body>
</html>
