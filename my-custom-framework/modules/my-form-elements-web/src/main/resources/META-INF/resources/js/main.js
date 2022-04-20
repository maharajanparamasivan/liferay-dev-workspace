$(".custom-tab > li").on("click",function(){
	
	$(this).parent().find('a').each(function(){
		
		$(this).removeClass("active");
	})
	
	$(this).children().addClass("active");
	
});