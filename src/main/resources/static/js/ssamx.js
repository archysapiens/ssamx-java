
    $("#btn-logout").click(function(event) {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url:"../logout.php",
            success: function(result) {
                $('.mb-content').html(result);
                $('.mb-footer').addClass('hidden');       
                $('.mb-title').html('<img style="margin-left:30%;" align="middle"  src="http://www.ran.salud.gob.mx/images/logoSALUD_hoz.png"  class="img-circle"> <h1 style="margin-left:34%;">  Cerrando sesión...</h1><br/>');       
                $('.message-box .mb-container').css('background','transparent');       

                waitingDialog.show();setTimeout(function () {waitingDialog.hide();}, 5000);
            }
        });                                               
       
        return false;
    });


