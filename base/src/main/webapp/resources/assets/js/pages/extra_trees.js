/* ------------------------------------------------------------------------------
 *
 *  # Dynamic tree views
 *
 *  Specific JS code additions for extra_trees.html page
 *
 *  Version: 1.0
 *  Latest update: Aug 1, 2015
 *
 * ---------------------------------------------------------------------------- */

$(function () {


    // Basic setup
    // ------------------------------

    // Load JSON data
    $(".tree-ajax").fancytree({
        source: {
            url: $("#tree-url").data('url')
        },
        init: function (event, data) {
            $('.has-tooltip .fancytree-title').tooltip();
            var node = $(".tree-ajax").fancytree("getRootNode");
            node.sortChildren(function (a, b) {
                var x = (a.isFolder() ? "0" : "1") + a.title.toLowerCase(),
                    y = (b.isFolder() ? "0" : "1") + b.title.toLowerCase();
                return x === y ? 0 : x > y ? 1 : -1;
            }, true);
        }
    });

    //
    // Sorting
    //

    // Initialize
    $(".tree-sorting").fancytree();

});
