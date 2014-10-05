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


    <title>电影信息</title>
    <meta name="description" content="新增电影信息！" />

    <meta name="HandheldFriendly" content="True" />
    <meta name="MobileOptimized" content="320" />

    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen" />
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
                <a class="navbar-brand" href="home">FilmView</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="search">查询</a></li>
                    <li><a href="newFilm">新增</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a data-spm-anchor-id="0.0.0.0">你好，LXT</a></li>
                    <li><a target="_top" href="login" data-spm-anchor-id="0.0.0.0">Exit <span class="glyphicon glyphicon-log-out"></span></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>
    <div class="backgr" style="background-image: url(<%=basepath%>img/bg.jpg)">
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="crawl-result">
                        <s:set name="callback" value="callback"/>
                        <s:if test="%{#callback=='true'}">
                            <h1 class="text-center">电影信息</h1>
                            <table class="table">
                                <thead><tr><th style="width:20%">Property</th><th>Content</th></tr></thead>
                                <tr><td>电影名称</td><td><s:property value='filmInfo.filmName'/></td></tr>
                                <tr><td>导演</td><td><s:property value='filmInfo.director'/></td></tr>
                                <tr><td>主演</td><td><s:property value='filmInfo.starring'/></td></tr>
                                <tr><td>电影类型</td><td><s:property value='filmInfo.filmType'/></td></tr>
                                <tr><td>上映时间</td><td><s:property value='filmInfo.filmTime'/></td></tr>
                                <tr><td>电影简介</td><td><s:property value='filmInfo.filmIntro'/></td></tr>
                                <tr><td>评分</td><td><s:property value='filmInfo.score'/></td></tr>
                                <tr><td>评价</td><td><s:property value='filmInfo.filmReview'/></td></tr>
                            </table>
                            <h4 class="text-center">如需保存该电影，请点击保存按钮。</h4>

                            <div class="row">
                                <div class="col-md-6 col-md-offset-2">
                                    <div class="col-md-3">
                                        <form action="save_film.action" method="post">
                                            <input name="url" value="<s:property value='url'/>" type="hidden" />
                                            <button class="btn btn-success"  type="submit" >保存</button>
                                        </form>
                                    </div>
                                    <div class="col-md-3">
                                        <a href="newFilm"><button class="btn btn-danger">返回</button></a>
                                    </div>
                                </div>
                            </div>

                        </s:if>
                        <s:else>
                            <h1 class="text-center" style="color:#fff">抱歉，无法解析该页面。</h1>
                            <a href="newFilm"><button class="btn btn-danger">返回</button></a>
                        </s:else>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
<script src="js/icheck.js"></script>

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