#pragma once
#include "Plant.h"
class PineBorscht :
	public Plant
{
public:
	PineBorscht(World& world, int x, int y);
	~PineBorscht();
	bool specialCollision(Organism*);
	bool specialAction();
};

