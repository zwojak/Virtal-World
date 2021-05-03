#include "Guarana.h"

Guarana::Guarana(World& world, int x, int y) :
	Plant(world, x, y)
{
	this->sign = 'x';
	this->power = 0;
	this->initiative = 0;
}
bool Guarana::specialCollision(Organism* other) {
	other->SetPower(other->GetPower() + 3);
	return false;
}
bool Guarana::specialAction() {
	return false;
}
Guarana::~Guarana() {
}
