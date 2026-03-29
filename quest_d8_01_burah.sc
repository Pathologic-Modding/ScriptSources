include std.sci
include actor_disp_base.sci
include dgame.sci
include NPC_Burah.sci

maintask TBurah : TDispBase
{
	void OnUse(object actor) {
		TDlg_DN8_Danko_Burah{actor};
	}
}
