function showMyProgress() {
	$("#BgDiv1").css({
		display : "block",
		height : $(document).height()
	});
	var yscroll = document.documentElement.scrollTop;
	var screenx = $(window).width();
	var screeny = $(window).height();
	$(".DialogDiv").css("display", "block");
	$(".DialogDiv").css("top", yscroll + "px");
	var DialogDiv_width = $(".DialogDiv").width();
	var DialogDiv_height = $(".DialogDiv").height();
	$(".DialogDiv").css("left", (screenx / 2 - DialogDiv_width / 2) + "px")
	$(".DialogDiv").css("top", (screeny / 2 - DialogDiv_height / 2) + "px")
	$("body").css("overflow", "hidden");
}

function hideMyProgress() {
	$("#BgDiv1").css({
		display : "none"
	});
	$(".DialogDiv").css("display", "none");
}
function newMyProgress(str) {
	var attr = '<div class="progress_prompt3" id="prompt3">'
			+ '<div class="progress_alertDiv">' + '<p class="progress_detail"><img src="../res/images/waitpic.gif"></p>';
	
	if (str != null && str != '')
	{
		attr +='<p class="progress_detail">'+ str + '</p>' + '</div></div>';
	}
	else
	{
		attr += '</div></div>';;
	}
	$("body").append(attr);
	$(".progress_prompt3").show();
}

function ensureMyProgress() {
	$("#prompt3").remove();
}
