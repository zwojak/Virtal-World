#include "Sheep.h"
#include "World.h"

Sheep::Sheep(World& worldref, int x, int y) :
	Animal(worldref, x, y)
{
	this->power = 4;
	this->initiative = 4;
	this->sign = 'S';
}
 Sheep::~Sheep() {}
 bool Sheep::specialCollision(Organism* other) {
	 return false;
 }
 bool Sheep::specialAction() {
	 return false;
 }