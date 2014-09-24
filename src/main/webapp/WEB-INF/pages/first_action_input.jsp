<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Dream is a good thing</title>

    <!-- Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="view.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
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
                <li><a href="home">查询</a></li>
                <li class="active"><a href="gettingStarted">关于</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
    <div class="container">
        <div class="starter-template">
        <form class="form-inline" role="search" action="myFirstAction" namespace="/" method="post">
            <div class="form-group">
                <input name="myName" type="text" class="form-control" placeholder="Name" style="width:500px">
            </div>
            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Submit</button>
        </form>
        </div>
        <div class="thumbnail" >
            <img src="http://blog.findshine.com/images/smile-the-world.jpg" class="img-center" />

        </div>
        <div class="footer">
            <p>Powered by <a href="http://example.com/" target="_blank">LXT</a> © 2014 lxt.com All rights reserved.</p>
        </div>
    </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
</body>
</html>