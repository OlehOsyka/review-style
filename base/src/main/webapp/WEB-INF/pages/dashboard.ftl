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
                            <span class="text-semibold">Dasboard</span>
                    </div>

                    <div class="heading-elements">
                        <a href="<@spring.url '/project/add'/>" class="btn bg-blue heading-btn">New project</a>
                    </div>
                </div>

            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Basic bar chart -->
                <div id="charts" class="panel panel-flat">
                    <div class="panel-heading">
                        <h5 class="panel-title">Commits for past period</h5>
                    </div>

                    <div class="panel-body">
                        <div class="chart-container">
                            <div class="chart has-fixed-height" id="basic_bars"></div>
                        </div>
                    </div>
                </div>

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
<script type="text/javascript" src="/resources/assets/js/core/pages/dashboard.js"></script>
<#--End main scripts-->
</html>
