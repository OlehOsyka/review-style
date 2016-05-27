$(document).ready(
    // Highlight nav
    function () {
        $('#nav-dashboard').addClass('active');
    },

// Print projects
    $.ajax({
        url: $('#project-get').data("url") + $('#user-email').text() + '/get',
        type: 'GET',
        dataType: 'application/json',
        success: function (data) {
            var list = $('#project-list-ul');
            var result = data.data;
            jQuery.each(result, function (index, value) {
                list.append('<li><a href="' + $('#project-files').data("url") + value.name + '/files"><i class="icon-googleplus5"></i>' + value.name + '</a></li>');
            });
        }
    })
)
;