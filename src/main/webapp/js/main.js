// JavaScript Document
function rotate(t){
	$(t).click(function(){
		var n = parseInt($(this).data('n'), 10) || 0; //0是默认值，当然也可能是1
		if(n==0){
			$(this).parent().find("div.text").slideDown(200);
			$(this).parent().find("i").addClass("rotate");
			n=1;
		}else if(n==1){
			$(this).parent().find("div.text").slideUp(200);
			$(this).parent().find("i").removeClass("rotate");
			n=0;
		}
		$(this).data('n', n);

	});
}

$(function(){
	rotate(".dl_box");
})