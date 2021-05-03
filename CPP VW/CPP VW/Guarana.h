#pragma once
#include "Plant.h"
class Guarana :
	public Plant
{
public:
	Guarana(World& world, int x, int y);
	~Guarana();
	bool specialCollision(Organism*);
	bool specialAction();
};

