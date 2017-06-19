/**
 * Created by theo.
 */
$(document).ready( function () {
    $('#buttonNext').click(function() {
        $('html,body').animate({scrollTop: $("#one").offset().top}, 'slow'      );
    });

    $('#buttonAscend').click(function() {
        $('html,body').animate({scrollTop: $("#banner").offset().top}, 'slow'      );
    });

    var height = $( window ).outerHeight() - $('html').outerHeight();
    if(height > 0){
        var $footer = $('#footer');
        $footer.css("margin-top","calc("+height+"px + "+$footer.prev().css("margin-bottom")+")");
    }
})