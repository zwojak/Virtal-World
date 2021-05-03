#include "SowThistle.h"
#define SOW_PROBABILITY 3

SowThistle::SowThistle(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->sign = 's';
	this->power = 0;
	this->initiative = 0;
}
SowThistle::~SowThistle(){
}
bool SowThistle::specialAction(){
	for (int i = 0; i < 3; i++)
		this->Multiply(this->posX, this->posY);
	return true;
}
bool SowThistle::specialCollision(Organism* other) {
	return false;
}