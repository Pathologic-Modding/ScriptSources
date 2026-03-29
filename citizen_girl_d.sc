include bcitizen_handle_undead.sci
include bcitizen_wanderer_notice.sci
include bcitizen_notice_look.sci
include bcitizen_attack_wretreat.sci
include bcitizen_pdamage_retreat.sci
include bcitizen_steal_none.sci
include bcitizen_message_none.sci
include bcitizen_use_latent.sci
include bcitizen_unload_none.sci
include item_base.sci
include NPC_girl.sci

const float c_fAttackNoticeDist = 700.0;
const float c_fAttackNoticeRepChange = -0.2;
const float c_fDeathRepChange = -0.3;

var bool g_bDead;

void PerformInit() 
{
	g_bDead = false;
	GenerateTeenagerItems(false);
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
	return true;
}

bool citIsZombieEnemy(object actor)
{
	bool bPlayer;
	@IsPlayerActor(actor, bPlayer);
	return bPlayer;
}

int citFilterZombieAttacked(object actor)
{
	return 0;
}

void citHandleZombieAttacked(object actor)
{
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