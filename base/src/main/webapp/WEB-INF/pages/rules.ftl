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
                            <span class="text-semibold">Rules</span>
                    </div>

                    <div class="heading-elements">
                        <a href="<@spring.url '/rule/add'/>" class="btn bg-blue heading-btn">New rule</a>
                    </div>
                </div>

            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Task manager table -->
                <div id="rules" class="panel panel-white">
                    <div class="panel-heading">
                        <h6 class="panel-title">Rules</h6>
                    </div>

                    <table class="table tasks-list table-lg">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Period</th>
                            <th>Rule name</th>
                            <th>Latest update</th>
                            <th class="text-center text-muted" style="width: 30px;"><i class="icon-checkmark3"></i></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>#25</td>
                            <td>Today</td>
                            <td>
                                <div class="text-semibold"><a href="task_manager_detailed.html">Class name in CamelStyle</a></div>
                            </td>
                            <td>
                                <div class="input-group input-group-transparent">
                                    <div class="input-group-addon"><i class="icon-calendar2 position-left"></i></div>
                                    <input type="text" class="form-control datepicker" value="12 June, 16">
                                </div>
                            </td>
                            <td class="text-center">
                                <ul class="icons-list">
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-menu9"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-right">
                                            <li><a href="#"><i class="icon-alarm-add"></i> Check in</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#"><i class="icon-cross2"></i> Remove</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>
                <!-- /task manager table -->


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
<script type="text/javascript" src="/resources/assets/js/core/pages/rules.js"></script>
<#--End main scripts-->
</html>
