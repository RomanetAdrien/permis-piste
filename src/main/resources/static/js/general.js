function detailJeu(elt){
    var id = elt.getAttribute("id");
    id = id.split("_");
    id= id[1];
    $("#toChange").attr("value",id);
}


$(document).ready( function () {
    $('#buttonNext').click(function() {
        $('html,body').animate({scrollTop: $("#one").offset().top}, 'slow'      );
    });

    $('#buttonAscend').click(function() {
        $('html,body').animate({scrollTop: $("#banner").offset().top}, 'slow'      );
    });
})