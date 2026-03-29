include ui_std.sci

maintask UI_Corpse
{
	void init(void) {
		@SetOwnerDraw(false);
		InitTools();
		@ProcessEvents();
	}
	
	void OnMessage(int iMessage, string strSender, object data) 
	{
		if (strSender == "scalpel") {
			if (HasEmptySlot()) {
				@UITrace("has slot");
			}
		}
		else
		if (strSender == "squirt") {
			if (HasEmptySlot()) {
				@UITrace("has slot");
			}
		}
	}		
	
	bool HasEmptySlot()
	{
		int iItems, iSize;
		@GetContainerItemCount(iItems);
		@GetContainerSize(iSize);
		if (iItems >= iSize)
			return false;
		return true;
	}
	
	void InitTools() {
/*		if (PlayerHasItem(c_iScalpelID)) {
			@SendMessage(1, "scalpel");
		}
		else {
			@SendMessage(0, "scalpel");
		}
		
		if (PlayerHasItem(c_iSquirtID)) {
			@SendMessage(1, "squirt");
		}
		else {
			@SendMessage(1, "squirt");
		}*/
	}
}
