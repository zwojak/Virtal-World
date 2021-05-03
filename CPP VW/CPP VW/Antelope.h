#pragma once
#include "Animal.h"

class Antelope:
	public Animal
{
public:
	Antelope(World &world, int x, int y);
	~Antelope();
	bool specialCollision(Organism*);
	bool specialAction();
};