function AddFavorite(sURL, sTitle) {
    try {
        window.external.addFavorite(sURL, sTitle);
    } catch (e) {
        try {
            window.sidebar.addPanel(sTitle, sURL, "");
        } catch (e) {
            alert("加入收藏失败,请手动添加.");
        }
    }
}

$(function(){
	$(".nav2").hover(function(){
		$(this).children("ul").show();
	},function(){
		$(this).children("ul").hide();
	});
	
	$(".snav").hover(function(){
		$(this).children("a").addClass('cur');
		$(this).children("ul").show();
	},function(){
		$(this).children("a").removeClass('cur');
		$(this).children("ul").hide();
	});
});