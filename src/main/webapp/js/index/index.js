// JavaScript Document
$(function() {
    $(".sidemenu_p.sidemenu_group").mouseover(function() {
        $(".bodyright_introduce_b").css("display", "block");
        $(".bodyright_introduce_a").css("display", "none");
		$(this).closest("div").css("background-color","#0099FF");
    });
    $(".sidemenu_p.sidemenu_group").mouseout(function() {
        $(".bodyright_introduce_b").css("display", "none");
        $(".bodyright_introduce_a").css("display", "block");
		$(this).closest("div").css("background-color","#111213");
    });
	$(".sidemenu_p.sidemenu_login").mouseover(function() {
		$(this).closest("div").css("background-color","#0099FF");
    });
    $(".sidemenu_p.sidemenu_login").mouseout(function() {
		$(this).closest("div").css("background-color","#111213");
    });
});