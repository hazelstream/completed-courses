$(document).ready(
    $('.dropdown').mouseenter(function(){
        $(this).animate({
           "height" : "550px",
        }); 
    }), 

    $('.dropdown').mouseleave(function(){
        $(this).stop(true).animate({
           "height" : "50px",
        });
    }), 
)