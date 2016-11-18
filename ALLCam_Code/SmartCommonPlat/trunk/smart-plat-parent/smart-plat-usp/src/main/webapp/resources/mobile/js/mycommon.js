function goBackHistory()
{
	history.back();
}
function getPhoneType() 
{
	var phoneType = "";
	var ua = (navigator.userAgent || navigator.vendor || window.opera);
	if (ua != null) 
	{
		var uaName = ua.toLowerCase();
		if (/android/i.test(uaName))
		{
			phoneType = "android";
		} 
		else 
		{
			if (/ip(hone|od)/i.test(uaName)) 
			{
				phoneType = "iphone";
			} 
			else 
			{
				if (/symbian/i.test(uaName)) 
				{
					phoneType = "symbian";
				} 
				else 
				{
					if (/windows (ce|phone)/i.test(uaName)) 
					{
						phoneType = "windows";
					} 
					else 
					{
						phoneType = "android";
					}
				}
			}
		}
	}
	
	return phoneType;
}