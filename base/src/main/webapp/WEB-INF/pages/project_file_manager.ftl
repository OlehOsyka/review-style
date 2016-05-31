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
    <script type="text/javascript" src="/resources/assets/js/core/libraries/jquery_ui/core.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/core/libraries/jquery_ui/effects.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/core/libraries/jquery_ui/interactions.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/plugins/extensions/cookie.js"></script>
    <script type="text/javascript" src="/resources/assets/js/plugins/forms/styling/switchery.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/plugins/forms/styling/uniform.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/plugins/trees/fancytree_all.min.js"></script>
    <script type="text/javascript" src="/resources/assets/js/plugins/trees/fancytree_childcounter.js"></script>

    <script type="text/javascript" src="/resources/assets/js/core/app.js"></script>
    <script type="text/javascript" src="/resources/assets/js/pages/extra_trees.js"></script>
    <!-- /theme JS files -->

<#--Link to data-->
    <input id="tree-url" type="hidden" data-url="<@spring.url '/public/project/tree?name='+project.name/>"/>

</head>

<body class="sidebar-opposite-visible">

<#--Custom vars-->
<@security.authentication property="principal" var="username" />
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
                        <h4><i class="icon-arrow-left52 position-left"></i> <span
                                class="text-semibold">${project.name} File Tree</span></h4>
                    </div>
                </div>

            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Form horizontal -->
                <div class="panel panel-flat">

                    <div class="panel-body">

                            <div class="panel-body">
                                <div class="tree-ajax well border-left-info border-left-lg"></div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /form horizontal -->

                <!-- Footer -->
            <#include "/base/footer.ftl">
                <!-- /footer -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->

</body>
<#--Main script-->
<script type="text/javascript" src="/resources/assets/js/core/pages/project_file_manager.js"></script>
<#--End main scripts-->
</html>
