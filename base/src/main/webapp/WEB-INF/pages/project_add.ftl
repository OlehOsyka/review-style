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
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
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
    <script type="text/javascript" src="/resources/assets/js/plugins/forms/styling/uniform.min.js"></script>

    <script type="text/javascript" src="/resources/assets/js/core/app.js"></script>
    <script type="text/javascript" src="/resources/assets/js/pages/form_inputs.js"></script>
    <!-- /theme JS files -->

</head>

<body class="sidebar-xs sidebar-opposite-visible">

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
                        <h4><i class="icon-arrow-left52 position-left"></i> <span class="text-semibold">Add project</span>
                            - Commits</h4>
                    </div>
                </div>

            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">

                <!-- Form horizontal -->
                <div class="panel panel-flat">

                    <div class="panel-body">
                        <form class="form-horizontal" action="#">
                            <fieldset class="content-group">
                                <legend class="text-bold">Add projects</legend>

                                <div class="form-group">
                                    <label class="control-label col-lg-2">Project name</label>
                                    <div class="col-lg-6">
                                        <input type="text" class="form-control" name="project-name">
                                    </div>
                                    <span class="label bg-teal help-inline">Only latin chars, numbers, [ ] - </span>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-lg-2">Owner</label>
                                    <div class="col-lg-8">
                                        <input type="text" class="form-control" readonly="readonly" value="${username}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-lg-2">VCS</label>
                                    <div class="col-lg-8">
                                        <select name="project-vcs" class="form-control">
                                            <option value="opt1">Git</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-lg-2">VCS Adress</label>
                                    <div class="col-lg-8">
                                        <input type="url" class="form-control" placeholder="ex. https://github.com/OlehOsyka/review-style.git" name="project-vcs-adress">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="control-label col-lg-2">Description</label>
                                    <div class="col-lg-8">
                                        <textarea rows="5" cols="5" class="form-control" placeholder="Project description" name="project-description"></textarea>
                                    </div>
                                </div>
                            </fieldset>

                            <div class="text-right">
                                <button type="submit" class="btn btn-primary">Submit <i class="icon-arrow-right14 position-right"></i></button>
                            </div>
                        </form>
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
<script type="text/javascript" src="/resources/assets/js/core/pages/dashboard.js"></script>
<#--End main scripts-->
</html>
