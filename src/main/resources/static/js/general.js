/**
 * Created by hagoterio on 18/06/17.
 */
$(document).ready( function () {
    $('#buttonNext').click(function() {
        $('html,body').animate({scrollTop: $("#one").offset().top}, 'slow'      );
    });

    $('#buttonAscend').click(function() {
        $('html,body').animate({scrollTop: $("#banner").offset().top}, 'slow'      );
    });
})