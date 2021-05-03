#pragma once
#include "Animal.h"

class Turtle :
	public Animal
{
public:
	Turtle(World &world, int x, int y);
	~Turtle();
	bool specialCollision(Organism*);
	bool specialAction();
};