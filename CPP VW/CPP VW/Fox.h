#pragma once
#include "Animal.h"

class Fox :
	public Animal
{
public:
	Fox(World &world, int x, int y);
	~Fox();
	bool specialCollision(Organism*);
	bool specialAction();
};