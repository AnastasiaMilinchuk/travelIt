/**
 * Created by bubble on 09.04.15.
 */

$(document).ready(function(){
    if(navigator.userAgent.toLowerCase().indexOf('chrome') >= 0){
        $(window).load(function(){
            $('input:-webkit-autofill').each(function(){
                $(this).after(this.outerHTML).remove();
                $('input[name='+$(this).attr('name')+']').val($(this).val());
            });
        });
    }
});
