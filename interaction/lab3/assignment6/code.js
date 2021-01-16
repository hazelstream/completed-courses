$(document).ready(
    $('button').click(function() {

        $("button").animate({
            "border-width" : "0px"
        })
        $("button").next().animate({
            "width": "120px",
            "height":  "120px"
        });

        $(this).animate({
            "border-width" : "10px"
        });
        $(this).next().animate({
            "width": "160px",
            "height":  "160px"
        });
    })
);