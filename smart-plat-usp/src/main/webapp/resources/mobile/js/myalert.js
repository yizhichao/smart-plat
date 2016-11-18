	function show()
	{
			$("#BgDiv1").css({ display: "block", height: $(document).height() });
			var yscroll = document.documentElement.scrollTop;
			var screenx=$(window).width();
			var screeny=$(window).height();
			$(".DialogDiv").css("display", "block");
 			 $(".DialogDiv").css("top",yscroll+"px");
			 var DialogDiv_width=$(".DialogDiv").width();
			 var DialogDiv_height=$(".DialogDiv").height();
			  $(".DialogDiv").css("left",(screenx/2-DialogDiv_width/2)+"px")
			 $(".DialogDiv").css("top",(screeny/2-DialogDiv_height/2)+"px")
			 $("body").css("overflow","hidden");
	}

	function hide()
	{
		$("#BgDiv1").css({ display: "none"});
		$(".DialogDiv").css("display", "none");
	}
	function newAlert(str){
		var attr = '<div class="prompt3" id="prompt3">'+
				   '<div class="alertDiv">'+
				   '<p class="detail">'+ str +'</p>'+
				   '<p class="ensure" onclick="ensureAlert();">确定</p></div></div>';
		$("body").append(attr);
		$(".prompt3").show();
	}
	
	function ensureAlert(){
		$("#prompt3").remove();
	}
	function checkPhone(){
		var len = $(this).val().length();
		alert(len)
	}
	
	
	