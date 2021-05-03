#include "WolfBerries.h"

WolfBerries::WolfBerries(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->sign = 'b';
	this->power = 99;
	this->initiative = 0;
}
bool WolfBerries::specialCollision(Organism* other) {
	world.PlantKillCom(this->posX, this->posY, other->GetPosX(), other->GetPosY());
	world.DeleteOrganism(*other,other->GetPosX(),other->GetPosY());
	return true;
}
bool WolfBerries::specialAction() {
	return false;
}

WolfBerries::~WolfBerries() {
}
