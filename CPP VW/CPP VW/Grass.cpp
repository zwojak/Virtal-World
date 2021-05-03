#include "Grass.h"

Grass::Grass(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->sign = 'g';
	this->power = 0;
	this->initiative = 0;
}
bool Grass::specialCollision(Organism* other) {
	return false;
}
bool Grass::specialAction() {
	return false;
}

Grass::~Grass(){
}
