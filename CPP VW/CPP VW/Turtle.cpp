#include "Turtle.h"
#include "World.h"

Turtle::Turtle(World& worldref, int x, int y) :
	Animal(worldref, x, y)
{
	this->power = 2;
	this->initiative = 1;
	this->sign = 'T';
}
Turtle::~Turtle() {}
bool Turtle::specialCollision(Organism* other) {
	if (other->GetPower() >= 5)
		return false;
	else {
		return true;
	}
}
bool Turtle::specialAction() {
	int x = rand() % 4;
	if (x == 0)
		this->Move();
	return true;
}