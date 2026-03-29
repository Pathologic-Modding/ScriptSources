include ui_std.sci

const string c_strTitleFont = "default";
const float c_fTitleColR = 1.0;
const float c_fTitleColG = 1.0;
const float c_fTitleColB = 1.0;

maintask UI_PlayerStatsName
{
	var string strName;
	void init(void) {
		@SetOwnerDraw(true);		
		@ProcessEvents();
	}
	
	void OnDraw()
	{
		if (strName != "")
			@Print(c_strTitleFont, 0, 0, strName, c_fTitleColR, c_fTitleColG, c_fTitleColB);
	}	
	
	void OnMessage(int iMessage, string strSender, object data) {
		if (iMessage != -1) {
			@GetStringByID(strName, iMessage);
			@_strupr(strName);
		}
		else {
			strName = "";
		}
	}	
}
