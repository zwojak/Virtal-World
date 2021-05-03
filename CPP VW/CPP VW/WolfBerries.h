#pragma once
#include "Plant.h"
class WolfBerries :
	public Plant
{
public:
	WolfBerries(World& world, int x, int y);
	~WolfBerries();
	bool specialCollision(Organism*);
	bool specialAction();
};
