<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>豆瓣电影数据堂</title>

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
                <a class="navbar-brand" href="#">FilmView</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">查询</a></li>
                    <li><a href="gettingStarted">关于</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>


    <div class="container">
        <div class="starter-template">
                <form class="form-inline" role="search" action="hello">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search..." style="width:500px" name="name" />
                    </div>
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Search</button>
                </form>
        </div>


        <div class="result">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th >电影</th>
                    <th style="width:25%">信息</th>
                    <th style="width:60%">简介</th>
                    <th  style="width:10%">评语</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td align="center"><a href="http://movie.douban.com/subject/25789352/"> 触不可及<img src="http://1.fansword.sinaapp.com/img/p2199637691.jpg" /></a></td>
                    <td><table>
                        <tr><td>导演：</td><td>赵宝刚</td></tr>
                        <tr><td>主演：</td><td>孙红雷 / 桂纶镁...</td></tr>
                        <tr><td>类型：</td><td>爱情 / 战争</td></tr>
                        <tr><td>上映时间：</td><td>2014-09-19(中国大陆)</td></tr>
                        <tr><td>评分：</td><td>5.1</td></tr>
                    </table></td>
                    <td>抗日战争时期，地下工作者傅经年（孙红雷 饰）有着双重特工的身份，他和拍档“影子”（徐静蕾 饰）原本要进行最后一次合作，可随着接头人“回声”（黄磊 饰）被傅经年上司——中统特务头子纪曾恩（方中信 饰）捕获，两人均面临重大威胁。危急关头影子牺牲了自己解救了傅经年，真相被影子收养的义妹宁待（桂纶镁 饰）看在眼里，随着深入接触和一系列事件纠葛，宁待与傅经年宿命般地相爱了，可是好景不长，国仇家恨又使两人分离。抗战结束后，纪夫人（蔡少芬 饰）给傅经年介绍了好姐妹卢秋漪（蒋勤勤 饰），此时此刻宁待又出现了，双重身份、国共两党的纠葛使得傅经年面对近在咫尺的爱情却无法触及，组织上的任务让他面临人生中最艰难的抉择，随着内战的白热化，他该何去何从？
                        　　本片是导演赵宝刚的电影处女作，故事时间跨度达70年。融合谍战和爱情元素，诠释了一位地下工作者与一位舞蹈老师的恋情。</td>
                    <td>摩擦，摩擦，是魔鬼的步伐……</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td align="center"><a href="http://movie.douban.com/subject/6874403/">歌曲改变人生 Begin Again <img src="http://1.fansword.sinaapp.com/img/p2180002996.jpg"/></a></td>
                    <td><table>
                        <tr><td>导演：</td><td>约翰·卡尼</td></tr>
                        <tr><td>主演：</td><td> 凯拉·奈特莉 / 马克·鲁弗洛 / 亚当·莱文 / ...</td></tr>
                        <tr><td>类型：</td><td>剧情 / 爱情 / 音乐</td></tr>
                        <tr><td>上映时间：</td><td>2014-07-11(美国)</td></tr>
                        <tr><td>评分：</td><td>8.3</td></tr>
                    </table></td>
                    <td>《歌曲改变人生》是大受影迷喜爱的《曾经》（Once）导演约翰·卡尼2013年自编自导新作，这是一部讲述爱情，失落以及动人音乐的影片。
                        　　格蕾塔（凯拉·奈特莉 Keira Knightley 饰）跟随音乐家男友戴夫（亚当·莱文 Adam Levine 饰）来到美国，在这里戴夫有着更好的事业机会，孰料戴夫来到纽约不久就开始劈腿，令格蕾塔伤心欲绝。失去了爱情，格蕾塔在偌大的陌生城市里找不到方向……
                        　　丹（马克·鲁弗洛 Mark Ruffalo 饰）是个失意的音乐制作人，他的生活也是一团糟：女儿（海莉·斯坦菲尔德 Hailee Steinfeld 饰）正处在青春期，自己仍时不时的惦念前妻（凯瑟琳·基纳 Catherine Keener 饰）。直到有一天，他在酒吧里遇到了偶然登台演唱的格蕾塔…… </td>
                    <td>歌不如once，故事也不如once 自然隽永。但John Carney真是骨子里透出来的小清新啊，内心深处关于爱与伤痛的感悟太让人有共鸣了。</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td align="center"><a href="http://movie.douban.com/subject/25789352/"> 触不可及<img src="http://1.fansword.sinaapp.com/img/p2199637691.jpg" /></a></td>
                    <td><table>
                        <tr><td>导演：</td><td>赵宝刚</td></tr>
                        <tr><td>主演：</td><td>孙红雷 / 桂纶镁...</td></tr>
                        <tr><td>类型：</td><td>爱情 / 战争</td></tr>
                        <tr><td>上映时间：</td><td>2014-09-19(中国大陆)</td></tr>
                        <tr><td>评分：</td><td>5.1</td></tr>
                    </table></td>
                    <td>抗日战争时期，地下工作者傅经年（孙红雷 饰）有着双重特工的身份，他和拍档“影子”（徐静蕾 饰）原本要进行最后一次合作，可随着接头人“回声”（黄磊 饰）被傅经年上司——中统特务头子纪曾恩（方中信 饰）捕获，两人均面临重大威胁。危急关头影子牺牲了自己解救了傅经年，真相被影子收养的义妹宁待（桂纶镁 饰）看在眼里，随着深入接触和一系列事件纠葛，宁待与傅经年宿命般地相爱了，可是好景不长，国仇家恨又使两人分离。抗战结束后，纪夫人（蔡少芬 饰）给傅经年介绍了好姐妹卢秋漪（蒋勤勤 饰），此时此刻宁待又出现了，双重身份、国共两党的纠葛使得傅经年面对近在咫尺的爱情却无法触及，组织上的任务让他面临人生中最艰难的抉择，随着内战的白热化，他该何去何从？
                        　　本片是导演赵宝刚的电影处女作，故事时间跨度达70年。融合谍战和爱情元素，诠释了一位地下工作者与一位舞蹈老师的恋情。</td>
                    <td>摩擦，摩擦，是魔鬼的步伐……</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td align="center"><a href="http://movie.douban.com/subject/6874403/">歌曲改变人生 Begin Again <img src="http://1.fansword.sinaapp.com/img/p2180002996.jpg"/></a></td>
                    <td><table>
                        <tr><td>导演：</td><td>约翰·卡尼</td></tr>
                        <tr><td>主演：</td><td> 凯拉·奈特莉 / 马克·鲁弗洛 / 亚当·莱文 / ...</td></tr>
                        <tr><td>类型：</td><td>剧情 / 爱情 / 音乐</td></tr>
                        <tr><td>上映时间：</td><td>2014-07-11(美国)</td></tr>
                        <tr><td>评分：</td><td>8.3</td></tr>
                    </table></td>
                    <td>《歌曲改变人生》是大受影迷喜爱的《曾经》（Once）导演约翰·卡尼2013年自编自导新作，这是一部讲述爱情，失落以及动人音乐的影片。
                        　　格蕾塔（凯拉·奈特莉 Keira Knightley 饰）跟随音乐家男友戴夫（亚当·莱文 Adam Levine 饰）来到美国，在这里戴夫有着更好的事业机会，孰料戴夫来到纽约不久就开始劈腿，令格蕾塔伤心欲绝。失去了爱情，格蕾塔在偌大的陌生城市里找不到方向……
                        　　丹（马克·鲁弗洛 Mark Ruffalo 饰）是个失意的音乐制作人，他的生活也是一团糟：女儿（海莉·斯坦菲尔德 Hailee Steinfeld 饰）正处在青春期，自己仍时不时的惦念前妻（凯瑟琳·基纳 Catherine Keener 饰）。直到有一天，他在酒吧里遇到了偶然登台演唱的格蕾塔…… </td>
                    <td>歌不如once，故事也不如once 自然隽永。但John Carney真是骨子里透出来的小清新啊，内心深处关于爱与伤痛的感悟太让人有共鸣了。</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td align="center"><a href="http://movie.douban.com/subject/25789352/"> 触不可及<img src="http://1.fansword.sinaapp.com/img/p2199637691.jpg" /></a></td>
                    <td><table>
                        <tr><td>导演：</td><td>赵宝刚</td></tr>
                        <tr><td>主演：</td><td>孙红雷 / 桂纶镁...</td></tr>
                        <tr><td>类型：</td><td>爱情 / 战争</td></tr>
                        <tr><td>上映时间：</td><td>2014-09-19(中国大陆)</td></tr>
                        <tr><td>评分：</td><td>5.1</td></tr>
                    </table></td>
                    <td>抗日战争时期，地下工作者傅经年（孙红雷 饰）有着双重特工的身份，他和拍档“影子”（徐静蕾 饰）原本要进行最后一次合作，可随着接头人“回声”（黄磊 饰）被傅经年上司——中统特务头子纪曾恩（方中信 饰）捕获，两人均面临重大威胁。危急关头影子牺牲了自己解救了傅经年，真相被影子收养的义妹宁待（桂纶镁 饰）看在眼里，随着深入接触和一系列事件纠葛，宁待与傅经年宿命般地相爱了，可是好景不长，国仇家恨又使两人分离。抗战结束后，纪夫人（蔡少芬 饰）给傅经年介绍了好姐妹卢秋漪（蒋勤勤 饰），此时此刻宁待又出现了，双重身份、国共两党的纠葛使得傅经年面对近在咫尺的爱情却无法触及，组织上的任务让他面临人生中最艰难的抉择，随着内战的白热化，他该何去何从？
                        　　本片是导演赵宝刚的电影处女作，故事时间跨度达70年。融合谍战和爱情元素，诠释了一位地下工作者与一位舞蹈老师的恋情。</td>
                    <td>摩擦，摩擦，是魔鬼的步伐……</td>
                </tr>
                </tbody>
            </table>
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