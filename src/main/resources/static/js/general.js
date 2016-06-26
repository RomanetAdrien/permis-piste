function detailJeu(elt){
    var id = elt.getAttribute("id");
    id = id.split("_");
    id= id[1];
    $("#toChange").attr("value",id);
}