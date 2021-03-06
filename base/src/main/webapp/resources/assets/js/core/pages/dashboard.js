$(document).ready(
    // Highlight nav
    function () {
        $('#nav-dashboard').addClass('active');
    },

// Print projects
    $.getJSON($('#project-get').data("url") + '/get?email=' + $('#user-email').text(), function (data) {
        var list = $('#project-list-ul');
        if(jQuery.isEmptyObject(list)){
            $('#charts').addClass('hidden');
        }
        jQuery.each(data, function (index, value) {
            list.append('<li><a href="' + $('#project-files').data("url") + '/files?name=' + value.name + '"><i class="icon-folder"></i>' + value.name + '</a></li>');
        });
    })


);