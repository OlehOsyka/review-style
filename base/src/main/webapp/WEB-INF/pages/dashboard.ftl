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
    <script type="text/javascript" src="/resources/assets/js/core/libraries/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/core/libraries/bootstrap.min.js"></script>
    <!-- /core JS files -->

    <!-- Theme JS files -->
    <script type="text/javascript" src="/resources/assets/js/core/app.js"></script>
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

                <!-- Simple panel -->
                <div class="panel panel-flat">
                    <div class="panel-heading">
                        <h5 class="panel-title">Here should be dashboard</h5>
                    </div>

                    <div class="panel-body">
                        <h6 class="text-semibold">Start your development with no hassle!</h6>
                        <p class="content-group">Common problem of templates is that all code is deeply integrated into
                            the core. This limits your freedom in decreasing amount of code, i.e. it becomes pretty
                            difficult to remove unnecessary code from the project. Limitless allows you to remove
                            unnecessary and extra code easily just by removing the path to specific LESS file with
                            component styling. All plugins and their options are also in separate files. Use only
                            components you actually need!</p>

                        <h6 class="text-semibold">What is this?</h6>
                        <p class="content-group">Starter kit is a set of pages, useful for developers to start
                            development process from scratch. Each layout includes base components only: layout, page
                            kits, color system which is still optional, bootstrap files and bootstrap overrides. No
                            extra CSS/JS files and markup. CSS files are compiled without any plugins or components.
                            Starter kit was moved to a separate folder for better accessibility.</p>

                        <h6 class="text-semibold">How does it work?</h6>
                        <p>You open one of the starter pages, add necessary plugins, uncomment paths to files in
                            components.less file, compile new CSS. That's it. I'd also recommend to open one of main
                            pages with functionality you need and copy all paths/JS code from there to your new page,
                            it's just faster and easier.</p>
                    </div>
                </div>
                <!-- /simple panel -->

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
