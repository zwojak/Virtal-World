#include "PineBorscht.h"

PineBorscht::PineBorscht(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->sign = 'p';
	this->power = 0;
	this->initiative = 0;
}
bool PineBorscht::specialCollision(Organism* other) {
	world.DeleteOrganism(*other, other->GetPosX(), other->GetPosY());
	return true;
}
bool PineBorscht::specialAction() {
	for (int y = -1; y < 2; y++) {
		for (int x = -1; x < 2; x++) {
			if (world.InBorders(this->posX + x, this->posY + y) && world.GetInitiativeOfField(this->posX + x, this->posY + y) > 0) {
				world.PlantKillCom(this->posX, this->posY, this->posX + x, this->posY + y);
				world.DeleteOrganism(*world.GetOrganismOfField(posX + x, posY + y), posX + x, posY + y);
			}
		}
	}
	return false;
}

PineBorscht::~PineBorscht() {
}
