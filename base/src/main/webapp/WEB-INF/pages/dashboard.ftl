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
                                class="text-semibold">Project name</span>
                            - Commits</h4>
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
                        <h5 class="panel-title">Simple panel</h5>
                        <div class="heading-elements">
                            <ul class="icons-list">
                                <li><a data-action="collapse"></a></li>
                                <li><a data-action="close"></a></li>
                            </ul>
                        </div>
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


                <!-- Table -->
                <div class="panel panel-flat">
                    <div class="panel-heading">
                        <h5 class="panel-title">Basic table</h5>
                        <div class="heading-elements">
                            <ul class="icons-list">
                                <li><a data-action="collapse"></a></li>
                                <li><a data-action="close"></a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="panel-body">
                        Starter pages include the most basic components that may help you start your development process
                        - basic grid example, panel, table and form layouts with standard components. Nothing extra.
                    </div>

                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Username</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>Eugene</td>
                                <td>Kopyov</td>
                                <td>@Kopyov</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Victoria</td>
                                <td>Baker</td>
                                <td>@Vicky</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>James</td>
                                <td>Alexander</td>
                                <td>@Alex</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Franklin</td>
                                <td>Morrison</td>
                                <td>@Frank</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /table -->


                <!-- Grid -->
                <div class="row">
                    <div class="col-md-6">

                        <!-- Horizontal form -->
                        <div class="panel panel-flat">
                            <div class="panel-heading">
                                <h5 class="panel-title">Horizontal form</h5>
                                <div class="heading-elements">
                                    <ul class="icons-list">
                                        <li><a data-action="collapse"></a></li>
                                        <li><a data-action="close"></a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form class="form-horizontal" action="#">
                                    <div class="form-group">
                                        <label class="control-label col-lg-2">Text input</label>
                                        <div class="col-lg-10">
                                            <input type="text" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-lg-2">Password</label>
                                        <div class="col-lg-10">
                                            <input type="password" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-lg-2">Select</label>
                                        <div class="col-lg-10">
                                            <select name="select" class="form-control">
                                                <option value="opt1">Basic select</option>
                                                <option value="opt2">Option 2</option>
                                                <option value="opt3">Option 3</option>
                                                <option value="opt4">Option 4</option>
                                                <option value="opt5">Option 5</option>
                                                <option value="opt6">Option 6</option>
                                                <option value="opt7">Option 7</option>
                                                <option value="opt8">Option 8</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-lg-2">Textarea</label>
                                        <div class="col-lg-10">
                                            <textarea rows="5" cols="5" class="form-control"
                                                      placeholder="Default textarea"></textarea>
                                        </div>
                                    </div>

                                    <div class="text-right">
                                        <button type="submit" class="btn btn-primary">Submit form <i
                                                class="icon-arrow-right14 position-right"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- /horizotal form -->

                    </div>

                    <div class="col-md-6">

                        <!-- Vertical form -->
                        <div class="panel panel-flat">
                            <div class="panel-heading">
                                <h5 class="panel-title">Vertical form</h5>
                                <div class="heading-elements">
                                    <ul class="icons-list">
                                        <li><a data-action="collapse"></a></li>
                                        <li><a data-action="close"></a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form action="#">
                                    <div class="form-group">
                                        <label>Text input</label>
                                        <input type="text" class="form-control">
                                    </div>

                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="select" class="form-control">
                                            <option value="opt1">Basic select</option>
                                            <option value="opt2">Option 2</option>
                                            <option value="opt3">Option 3</option>
                                            <option value="opt4">Option 4</option>
                                            <option value="opt5">Option 5</option>
                                            <option value="opt6">Option 6</option>
                                            <option value="opt7">Option 7</option>
                                            <option value="opt8">Option 8</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label>Textarea</label>
                                        <textarea rows="4" cols="4" class="form-control"
                                                  placeholder="Default textarea"></textarea>
                                    </div>

                                    <div class="text-right">
                                        <button type="submit" class="btn btn-primary">Submit form <i
                                                class="icon-arrow-right14 position-right"></i></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- /vertical form -->

                    </div>
                </div>
                <!-- /grid -->


                <!-- Footer -->
            <#include "/base/footer.ftl">
                <!-- /footer -->

            </div>
            <!-- /content area -->

        </div>
        <!-- /main content -->


        <!-- Opposite sidebar -->
        <div class="sidebar sidebar-opposite sidebar-default">
            <div class="sidebar-content">

                <!-- Sidebar search -->
                <div class="sidebar-category">
                    <div class="category-title">
                        <span>Search</span>
                        <ul class="icons-list">
                            <li><a href="#" data-action="collapse"></a></li>
                        </ul>
                    </div>

                    <div class="category-content">
                        <form action="#">
                            <div class="has-feedback has-feedback-left">
                                <input type="search" class="form-control" placeholder="Search">
                                <div class="form-control-feedback">
                                    <i class="icon-search4 text-size-base text-muted"></i>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /sidebar search -->


                <!-- Sub navigation -->
                <div class="sidebar-category">
                    <div class="category-title">
                        <span>Navigation</span>
                        <ul class="icons-list">
                            <li><a href="#" data-action="collapse"></a></li>
                        </ul>
                    </div>

                    <div class="category-content no-padding">
                        <ul class="navigation navigation-alt navigation-accordion">
                            <li class="navigation-header">Category title</li>
                            <li><a href="#"><i class="icon-googleplus5"></i> Link</a></li>
                            <li><a href="#"><i class="icon-googleplus5"></i> Another link</a></li>
                            <li><a href="#"><i class="icon-portfolio"></i> Link with label <span
                                    class="label bg-success-400">Online</span></a></li>
                            <li class="navigation-divider"></li>
                            <li>
                                <a href="#"><i class="icon-cog3"></i> Menu levels</a>
                                <ul>
                                    <li><a href="#"><i class="icon-IE"></i> Second level</a></li>
                                    <li>
                                        <a href="#"><i class="icon-firefox"></i> Second level with child</a>
                                        <ul>
                                            <li><a href="#"><i class="icon-android"></i> Third level</a></li>
                                            <li>
                                                <a href="#"><i class="icon-apple2"></i> Third level with child</a>
                                                <ul>
                                                    <li><a href="#"><i class="icon-html5"></i> Fourth level</a></li>
                                                    <li><a href="#"><i class="icon-css3"></i> Fourth level</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="#"><i class="icon-windows"></i> Third level</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#"><i class="icon-chrome"></i> Second level</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /sub navigation -->


                <!-- Form sample -->
                <div class="sidebar-category">
                    <div class="category-title">
                        <span>Form example</span>
                        <ul class="icons-list">
                            <li><a href="#" data-action="collapse"></a></li>
                        </ul>
                    </div>

                    <form action="#" class="category-content">
                        <div class="form-group">
                            <label>Your name:</label>
                            <input type="text" class="form-control" placeholder="Username">
                        </div>

                        <div class="form-group">
                            <label>Your password:</label>
                            <input type="password" class="form-control" placeholder="Password">
                        </div>

                        <div class="form-group">
                            <label>Your message:</label>
                            <textarea rows="3" cols="3" class="form-control" placeholder="Default textarea"></textarea>
                        </div>

                        <div class="row">
                            <div class="col-xs-6">
                                <button type="reset" class="btn btn-danger btn-block">Reset</button>
                            </div>
                            <div class="col-xs-6">
                                <button type="submit" class="btn btn-info btn-block">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- /form sample -->

            </div>
        </div>
        <!-- /opposite sidebar -->

    </div>
    <!-- /page content -->

</div>
<!-- /page container -->

</body>
<#--Main script-->
<script type="text/javascript" src="/resources/assets/js/core/pages/dashboard.js"></script>
<#--End main scripts-->
</html>
