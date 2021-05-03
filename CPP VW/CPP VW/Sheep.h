#pragma once
#include "Animal.h"

class Sheep :
	public Animal
{
public:
	Sheep(World &world, int x, int y);
	~Sheep();
	bool specialCollision(Organism*);
	bool specialAction();
};