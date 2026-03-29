include std.sci

maintask TSobor
{
	var bool c_bAglaja;
	
	void init(void) {
		c_bAglaja = false;
		for (;;) {
			@Hold();
		}
	}
	
	void OnLoad(void) {
		if (!c_bAglaja) {
			float fGameTime;
			@GetGameTime(fGameTime);
			if (fGameTime >= 6 * 24) {
				c_bAglaja = true;
				SpawnActor(self(), "pt_Aglaja", "NPC_Aglaja", "NPC_Danko_Aglaja.xml");
			}
		}
	}
	
	void OnTrigger(string name) {
		if (name == "noaglaja") {
			c_bAglaja = true;
		}
	}
}
