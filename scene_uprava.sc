include std.sci

maintask TTermitnik
{
	void init(void) {
		for (;;) {
			@Hold();
		}
	}
	
	void OnLoad(void) {
		TriggerActor("quest_d11_02", "uprava_load");
	}
}
