<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Review Style</title>

    <!-- Global stylesheets -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet"
          type="text/css">
    <link href="/resources/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
    <link href="/resources/assets/css/minified/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/assets/css/minified/core.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/assets/css/minified/components.min.css" rel="stylesheet" type="text/css">
    <link href="/resources/assets/css/minified/colors.min.css" rel="stylesheet" type="text/css">
    <!-- /global stylesheets -->

    <!-- Core JS files -->
    <script type="text/javascript" src="/resources/assets/js/plugins/loaders/pace.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/core/libraries/bootstrap.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/plugins/loaders/blockui.min.js"></script>
    <!-- /core JS files -->

    <!-- Theme JS files -->
    <script type="text/javascript" src="/resources/assets/js/plugins/visualization/echarts/echarts.js"></script>
    <script type="text/javascript" src="/resources/assets/js/core/app.js"></script>
    <script type="text/javascript" src="/resources/assets/js/charts/echarts/bars_tornados.js"></script>
    <!-- /theme JS files -->
</head>

<body class="sidebar-opposite-visible">

<#--Custom vars-->
<@security.authentication property="principal" var="username" />
<input type="hidden" id="project-get" data-url="<@spring.url '/public/project/'/>"/>
<input type="hidden" id="project-files" data-url="<@spring.url '/project/'/>"/>
<#--/custom vars-->

<!-- Main navbar -->
<#include "/base/navbar.ftl">
<!-- /main navbar -->


<!-- Page container -->
<div class="page-container">

    <!-- Page content -->
    <div class="page-content">

        <!-- Main sidebar -->
        <div class="sidebar sidebar-main">
            <div class="sidebar-content">

                <!-- User menu -->
            <#include "/base/user_menu.ftl">
                <!-- /user menu -->


                <!-- Main navigation -->
            <#include "/base/navigation.ftl">
                <!-- /main navigation -->

            </div>
        </div>
        <!-- /main sidebar -->


        <!-- Main content -->
        <div class="content-wrapper">

            <!-- Page header -->
            <div class="page-header">
                <div class="page-header-content">
                    <div class="page-title">
                        <h4><i class="icon-arrow-left52 position-left"></i>
                            <span class="text-semibold">Issue - 000021</span>
                    </div>
                </div>

            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Detailed task -->
                <div class="row">
                    <div class="col-lg-8">

                        <!-- Task overview -->
                        <div class="panel panel-flat">
                            <div class="panel-heading mt-5">
                                <h5 class="panel-title">#21: Class name not in Camel Case Style</h5>
                                <div class="heading-elements">
                                    <a href="#" class="btn bg-teal-400 btn-sm btn-labeled btn-labeled-right heading-btn">Check in <b><i class="icon-alarm-check"></i></b></a>
                                </div>
                            </div>

                            <div class="panel-body">
                                <h6 class="text-semibold">Overview</h6>
                                <p class="content-group">Please write you class name in camelCase style. See https://en.wikipedia.org/wiki/CamelCase</p>

                            </div>

                            <div class="panel-footer">
                                <ul>
                                    <li><span class="status-mark border-blue position-left"></span> Status:</li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Open <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li class="active"><a href="#">Open</a></li>
                                            <li><a href="#">On hold</a></li>
                                            <li><a href="#">Resolved</a></li>
                                            <li><a href="#">Closed</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Dublicate</a></li>
                                            <li><a href="#">Invalid</a></li>
                                            <li><a href="#">Wontfix</a></li>
                                        </ul>
                                    </li>

                                </ul>

                                <ul class="pull-right">
                                    <li><a href="#"><i class="icon-compose"></i></a></li>
                                    <li><a href="#"><i class="icon-trash"></i></a></li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-grid-alt"></i> <span class="caret"></span></a>
                                        <ul class="dropdown-menu dropdown-menu-right">
                                            <li><a href="#"><i class="icon-alarm-add"></i> Check in</a></li>
                                            <li><a href="#"><i class="icon-attachment"></i> Attach screenshot</a></li>
                                            <li><a href="#"><i class="icon-user-plus"></i> Assign users</a></li>
                                            <li><a href="#"><i class="icon-warning2"></i> Report</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- /task overview -->


                        <#--<!-- Comments &ndash;&gt;-->
                        <#--<div class="panel panel-flat">-->
                            <#--<div class="panel-heading">-->
                                <#--<h5 class="panel-title text-semiold"><i class="icon-bubbles4 position-left"></i> Comments</h5>-->
                                <#--<div class="heading-elements">-->
                                    <#--<a href="#" class="btn bg-blue btn-xs btn-icon"><i class="icon-plus2"></i></a>-->
                                <#--</div>-->
                            <#--</div>-->

                            <#--<div class="panel-body">-->
                                <#--<ul class="media-list content-group-lg stack-media-on-mobile">-->
                                    <#--<li class="media">-->
                                        <#--<div class="media-left">-->
                                            <#--<a href="#"><img src="/resources/assets/images/image.png" class="img-circle img-sm" alt=""></a>-->
                                        <#--</div>-->

                                        <#--<div class="media-body">-->
                                            <#--<div class="media-heading">-->
                                                <#--<a href="#" class="text-semibold">OlehOsyka</a>-->
                                                <#--<span class="media-annotation dotted">Just now</span>-->
                                            <#--</div>-->

                                            <#--<p>He moonlight difficult engrossed an it sportsmen. Interested has all devonshire difficulty gay assistance joy. Unaffected at ye of compliment alteration to.</p>-->

                                            <#--<ul class="list-inline list-inline-separate text-size-small">-->
                                                <#--<li><a href="#">Reply</a></li>-->
                                                <#--<li><a href="#">Edit</a></li>-->
                                            <#--</ul>-->
                                        <#--</div>-->
                                    <#--</li>-->

                                    <#--<li class="media">-->
                                        <#--<div class="media-left">-->
                                            <#--<a href="#"><img src="/resources/assets/images/image.png" class="img-circle img-sm" alt=""></a>-->
                                        <#--</div>-->

                                        <#--<div class="media-body">-->
                                            <#--<div class="media-heading">-->
                                                <#--<a href="#" class="text-semibold">JSmirnova</a>-->
                                                <#--<span class="media-annotation dotted">5 minutes ago</span>-->
                                            <#--</div>-->

                                            <#--<p>Place voice no arise along to. Parlors waiting so against me no. Wishing calling are warrant settled was luckily. Express besides it present if at an opinion visitor.</p>-->

                                            <#--<ul class="list-inline list-inline-separate text-size-small">-->
                                                <#--<li><a href="#">Reply</a></li>-->
                                                <#--<li><a href="#">Edit</a></li>-->
                                            <#--</ul>-->
                                        <#--</div>-->
                                    <#--</li>-->

                                <#--</ul>-->

                                <#--<div class="text-right">-->
                                    <#--<button type="button" class="btn bg-blue"><i class="icon-plus22"></i> Add comment</button>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<!-- /comments &ndash;&gt;-->

                    </div>

                    <div class="col-lg-4">

                        <!-- Task details -->
                        <div class="panel panel-flat">
                            <div class="panel-heading">
                                <h6 class="panel-title"><i class="icon-files-empty position-left"></i> Task details</h6>
                                <div class="heading-elements">
                                    <ul class="icons-list">
                                        <li><a data-action="collapse"></a></li>
                                        <li><a data-action="reload"></a></li>
                                        <li><a data-action="close"></a></li>
                                    </ul>
                                </div>
                            </div>

                            <table class="table table-borderless table-xs content-group-sm">
                                <tbody>
                                <tr>
                                    <td><i class="icon-briefcase position-left"></i> Project:</td>
                                    <td class="text-right"><span class="pull-right"><a href="#">OlehOsyka/BugzTracker</a></span></td>
                                </tr>
                                <tr>
                                    <td><i class="icon-alarm-add position-left"></i> Updated:</td>
                                    <td class="text-right">12 June, 2016</td>
                                </tr>
                                <tr>
                                    <td><i class="icon-alarm-check position-left"></i> Created:</td>
                                    <td class="text-right">12 June, 2016</td>
                                </tr>
                                <tr>
                                    <td><i class="icon-circles2 position-left"></i> Priority:</td>
                                    <td class="text-right">
                                        <div class="btn-group">
                                            <a href="#" class="label label-danger dropdown-toggle" data-toggle="dropdown">Highest <span class="caret"></span></a>
                                            <ul class="dropdown-menu dropdown-menu-right">
                                                <li><a href="#"><span class="status-mark position-left bg-danger"></span> Highest priority</a></li>
                                                <li><a href="#"><span class="status-mark position-left bg-info"></span> High priority</a></li>
                                                <li><a href="#"><span class="status-mark position-left bg-primary"></span> Normal priority</a></li>
                                                <li><a href="#"><span class="status-mark position-left bg-success"></span> Low priority</a></li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td><i class="icon-history position-left"></i> Revisions:</td>
                                    <td class="text-right">2</td>
                                </tr>
                                <tr>
                                    <td><i class="icon-file-plus position-left"></i> Added by:</td>
                                    <td class="text-right"><a href="#">System-bot</a></td>
                                </tr>
                                <tr>
                                    <td><i class="icon-file-check position-left"></i> Status:</td>
                                    <td class="text-right">Published</td>
                                </tr>
                                </tbody>
                            </table>

                            <div class="panel-footer">
                                <ul>
                                    <li><a href="#"><i class="icon-pencil7"></i></a></li>
                                    <li><a href="#"><i class="icon-bin"></i></a></li>
                                </ul>

                                <ul class="pull-right">
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-gear"></i><span class="caret"></span></a>
                                        <ul class="dropdown-menu dropdown-menu-right">
                                            <li><a href="#"><i class="icon-alarm-add"></i> Check in</a></li>
                                            <li><a href="#"><i class="icon-attachment"></i> Attach screenshot</a></li>
                                            <li><a href="#"><i class="icon-user-plus"></i> Assign users</a></li>
                                            <li><a href="#"><i class="icon-warning2"></i> Report</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- /task details -->

                    </div>
                </div>
                <!-- /detailed task -->


                <!-- Footer -->
            <#include "/base/footer.ftl">
                <!-- /footer -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->


    <#include "/base/opposite_sidebar.ftl">

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->

</body>
<#--Main script-->
<script type="text/javascript" src="/resources/assets/js/core/pages/issue.js"></script>
<#--End main scripts-->
</html>
