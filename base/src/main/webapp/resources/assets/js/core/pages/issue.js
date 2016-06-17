/**
 * Created by user on 6/6/2016.
 */
$(document).ready(
    // Highlight nav
    function () {
        $('#nav-issue').addClass('active');
    },

// Print projects
    $.getJSON($('#project-get').data("url") + '/get?email=' + $('#user-email').text(), function (data) {
        var list = $('#project-list-ul');
        jQuery.each(data, function (index, value) {
            list.append('<li><a href="' + $('#project-files').data("url") + '/files?name=' + value.name + '"><i class="icon-folder"></i>' + value.name + '</a></li>');
        });
    })
);