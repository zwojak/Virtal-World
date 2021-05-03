#pragma once
#include "Animal.h"

class Wolf :
	public Animal
{
public:
	Wolf(World &world,int x, int y);
	~Wolf();
	bool specialCollision(Organism*);
	bool specialAction();
};