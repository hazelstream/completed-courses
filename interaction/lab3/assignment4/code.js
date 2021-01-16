$(document).ready(
    $('.circles').click(function(){
            $(this).toggleClass("green");
    }),

    $('.squares').click(function(){
        $(this).height(function(n, c){
            return c - c / 4;
        });
        $(this).width(function(n, c){
            return c - c / 4;
        });

        
    }),

    $('.rectangles').click(function(){
        $(this).animate({
           "marginTop" : "+=10px"
        });
    }), 
);

