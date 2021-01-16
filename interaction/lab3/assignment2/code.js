$(document).ready(
    $('#dropDown').change(function(){
      for(let i = 1; i <= 6 ; i++){
        $('#sq' + i).css("display", "none");
      }
      for(let i = 1; i <= $('#dropDown').val() ; i++){
          $('#sq' + i).css("display", "flex");
      }
    })
)