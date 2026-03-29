include std.sci
include disp_idle.sci
include bgame.sci
include NPC_Klara.sci

maintask TDisp : TDispIdle
{
	void OnUse(object actor) {
		CancelActivity();
		// TODO
	}
}
