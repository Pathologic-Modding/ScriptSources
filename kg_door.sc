include std.sci
include outdoor_door_base.sci
include key_logic.sci

maintask TDoor : TDoorBase
{
	void OnUse(object actor) {
		if (IsLocked()) {
			if (HasSceneKey(actor, GetDoorTargetScene(), true)) {
				Lock(false);
			}
			else {
				return;
			}
		}
		
		super.OnUse(actor);
	}	
}
