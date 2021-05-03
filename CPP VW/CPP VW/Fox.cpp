#include "Fox.h"
#include "World.h"

Fox::Fox(World& worldref, int x, int y) :
	Animal(worldref, x, y)
{
	this->power = 3;
	this->initiative = 7;
	this->sign = 'F';
}
Fox::~Fox() {}
bool Fox::specialCollision(Organism* other) {
	return false;
}
bool Fox::specialAction() {
	int x, y;
	do {
		x = (rand() % 3 - 1);
		y = (rand() % 3 - 1);
	} while (!world.InBorders(this->posX + x, this->posY + y) || x == 0 && y == 0);
	if (world.IsEmpty(this->posX + x, this->posY + y)|| world.GetPowerOfField(this->posX + x, this->posY + y) <= this->GetPower())
		world.WorldMove(this->posX, this->posY, this->posX + x, this->posY + y);
	return true;
}