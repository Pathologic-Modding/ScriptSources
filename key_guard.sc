include bcitizen_stationary.sci
include bcitizen_handle_std.sci
include bcitizen_stat_doidle.sci
include bcitizen_attack_melee.sci
include bcitizen_pdamage_attack.sci
include bcitizen_unload_wait.sci
include bcitizen_use_latent.sci
include bcitizen_steal_none.sci
include bcitizen_message_none.sci

// CONSTANTS
const float c_fAttackNoticeDist = 1000.0;
const float c_fMeleeDamage = 0.07;
// CONSTANTS

var bool g_bDead;

void PerformInit(void)
{
	g_bDead = false;

	string scene_name;
	@GetProperty("guard_scene", scene_name);
	object item;
	@CreateInvItem(item);
	int iItemID;
	@GetInvItemByName(iItemID, "uni_key");
	item->SetItemID(iItemID);
	item->SetProperty("key_scene_name", scene_name);
	bool bAdded;
	@AddItem(bAdded, item, 0);
}

void PerformUse(object actor) 
{
	if (g_bDead) {
		@Barter(actor);
		return;
	}
}

bool citProcessPlayerDamage(object player, object actor)
{
	if (!HasProperty(actor, "class"))
		return false;

	string strClass;
	actor->GetProperty("class", strClass);
	if (strClass != "guard")
		return false;

	bool bCanSee;
	@CanSee(bCanSee, player);
	if (bCanSee || GetActorDistanceSqr(player) <= c_fAttackNoticeDist * c_fAttackNoticeDist) {
		return true;
	}

	return false;
}

void citHandleDeath(object actor)
{
	g_bDead = true;
	@SetRTEnvelope(50, 40);
	object scene;
	@GetScene(scene);
	scene->RemoveStationaryActor(self());
}
