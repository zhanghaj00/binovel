<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/tree.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/starter-template.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">JJJ</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${applicationScope['serverurl']}">张浩的小屋</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="${applicationScope['serverurl']}/user/commonlogin.html">主页君</a></li>
            <li><a href="${applicationScope['serverurl']}/user/getblog.html">我的博客</a></li>
            <li><a href="${applicationScope['serverurl']}/contact.jsp">我的联系方式</a></li>
          </ul>
          <form class="navbar-form navbar-right" role="form" action="${applicationScope['serverurl']}/user/searchlist.html">
            <div class="form-group">
              <input type="text" placeholder="输入你想要的内容" class="form-control" name="key">
            </div>
            <button type="submit" class="btn btn-success">搜索一下</button>
          </form>
        </div>
        <!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
    <div class="starter-template" style="margin-right: 100px;float: right">
        <h1>邮箱</h1>
        <p class="lead">414080606@qq.com</p>
        <h1>电话</h1>
        <p class="lead">18635688270</p>
        <h1>地址</h1>
        <p class="lead">帝都</p>
      </div>
    <div style=" padding: 200px 5px;float:left">
    <canvas id="canvastree"></canvas>
    </div>
    </div><!-- /.container -->
	


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.3.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/canvastree.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
