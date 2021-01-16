$(document).ready(
    $('#mytextarea').keyup(function(){
        var text = $('#mytextarea').val();
        $("p").text(text);
        console.log(text);

    }),

    $('button').click(function() {
        console.log('hej');
        $("p").css("font-family", $('.dropdown').val());
    })
);


 //to change the font directly
