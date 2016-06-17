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
    <script type="text/javascript" src="/resources/assets/js/plugins/ui/prism.min.js"></script>
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
                            <span class="text-semibold">app.js</span>
                    </div>
                </div>

            </div>
            <!-- /page header -->


            <!-- Content area -->
            <div class="content">
                <div class="row">

                    <div class="col-md-12">
<pre class="language-java content-group line-numbers" data-line="24"><code>package com.rs.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Oleh Osyka
 * Date: 5/20/2016
 * Time: 3:28 PM
 */
@SpringBootApplication
@Configuration
@PropertySource({"classpath:credentials.properties", "classpath:service.properties"})
@ComponentScan(basePackages = "com.rs.admin")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class adminapplication {

    @Bean
    public RestOperations asyncRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AdminApplication.class);
        application.run(args);
    }

}
</code></pre>

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
<script type="text/javascript" src="/resources/assets/js/core/pages/file.js"></script>
<#--End main scripts-->
</html>
