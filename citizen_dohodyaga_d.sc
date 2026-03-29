include bcitizen_handle_std.sci
include bcitizen_wanderer_notice.sci
include bcitizen_notice_look.sci
include bcitizen_attack_melee.sci
include bcitizen_pdamage_retreat.sci
include bcitizen_steal_none.sci
include bcitizen_message_none.sci
include bcitizen_use_latent.sci
include bcitizen_unload_none.sci
include item_base.sci
include NPC_dohodyaga.sci

const float c_fAttackNoticeDist = 500.0;
const float c_fAttackNoticeRepChange = -0.1;
const float c_fDeathRepChange = -0.1;
const float c_fMeleeDamage = 0.03;

var bool g_bDead;

void PerformInit() 
{
	g_bDead = false;
}

void PerformUse(object actor) 
{
	if (g_bDead) {
		bool bActive;
		@IsOverrideActive(bActive);
		if (!bActive)
			@Barter(actor);
		return;
	}
}

bool citNeedNoticeLook(void)
{
	return false;
}

bool citProcessPlayerDamage(object player, object actor)
{
	return pdamageVictim(player, actor, c_fAttackNoticeDist, c_fAttackNoticeRepChange);
}

void citHandleDeath(object actor)
{
	if (IsPlayerActor(actor))
		@ReportReputationChange(actor, self(), c_fDeathRepChange);
	g_bDead = true;
	@SetRTEnvelope(50, 40);
}