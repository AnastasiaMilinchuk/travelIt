/**
 * Created by milinchuk on 4/17/15.
 */
$(document).ready(function(){
    $('.bwWrapper').BlackAndWhite({
        hoverEffect: true
    });

    $(".imag").hover(function(){
        $(".main-img").css({"-webkit-filter": "grayscale(0%)",
        "transition": "1s"} );
        $(".imag").css({  "width": "36%",
        "margin-left": "32%",  "transition": "1s"} );
    });
    $('#begin').mouseout(function(){
        $(".main-img").css({"-webkit-filter": "grayscale(100%)",
            "transition": "3s"} );
        $(".imag").css({  "width": "30%",
            "margin-left": "34%",  "transition": "1s"} );
    });

    $(".what-it-about-content").mouseover(function(){
        $(this).children("img:first").css({"-webkit-filter": "grayscale(0%)",
            "transition": "1s", "-webkit-transform": "scale(1.1, 1.1, 1.1)",
            "-ms-transform": "scale(1.1, 1.1)",
            "transform": "scale(1.1, 1.1)" });
        $(this).children('div:first').css({"opacity": "0",
            "transition": "1s" , "visibility": "hidden"} );

    });

    $('.what-it-about-content').mouseout(function(){
        $(this).children("img:first").css({"-webkit-filter": "grayscale(100%)",
            "transition": "2s", "-webkit-transform": "scale(1, 1, 1)",
            "-ms-transform": "scale(1, 1)",
            "transform": "scale(1, 1)"  } );
        $(this).children('div:first').css({"opacity": "1",
            "transition": "1s" , visibility: "visible"} );
    });

});

