#include "Wolf.h"
#include "World.h"

Wolf::Wolf(World& worldref, int x, int y) :
	Animal(worldref, x, y)
{
	this->power = 9;
	this->initiative = 5;
	this->sign = 'W';
}
Wolf::~Wolf(){}
bool Wolf::specialCollision(Organism* other) {
	return false;
}
bool Wolf::specialAction() {
	return false;
}