include std.sci
include item_slow.sci

maintask TEffect: TSlow
{
	void init(void) {
		float fImmunity;
		@GetProperty("immunity", fImmunity);
		if (fImmunity < c_fImmunityTo) {
			@SetProperty("immunity", c_fImmunityTo);
		}
		ModPropertyF("health", c_fHealthIncrease, 0, 1);
		
		super.init(c_fWorkTime);
	}
	
	bool Tick(float fDeltaTime) {
		ModPropertyF("immunity", fDeltaTime * c_fImmunityProgress, 0, c_fImmunityTo);
		ModPropertyF("health", fDeltaTime * c_fHealthProgress, 0, 1);
		return false;
	}
}
