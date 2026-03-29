include ui_events.sci

maintask UI_GameButtonSimple
{
	void init(void) {
		@SetBackground("default");
		@ProcessEvents();
	}
	
	void OnLButtonDown(int x, int y)
	{
		@SendMessageToParent(0);
	}
	
	void OnMouseEnter() 
	{
		@SendMessageToParent(1);
	}	
	
	void OnMouseLeave()
	{
		@SendMessageToParent(2);
	}
}
