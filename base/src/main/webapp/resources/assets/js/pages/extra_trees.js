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

$(function() {


    // Basic setup
    // ------------------------------

    // Load JSON data
    $(".tree-ajax").fancytree({
        source: {
            url: $("#tree-url").data('url')
        },
        init: function(event, data) {
            $('.has-tooltip .fancytree-title').tooltip();
            var node = $(".tree-ajax").fancytree("getRootNode");
            node.sortChildren(null, true);
        }
    });

    //
    // Sorting
    //

    // Initialize
    $(".tree-sorting").fancytree();

    // Sort tree
    $('.sort-tree').on('click', function() {
        var node = $(".tree-sorting").fancytree("getRootNode");
        node.sortChildren(null, true);
    });

    
});
