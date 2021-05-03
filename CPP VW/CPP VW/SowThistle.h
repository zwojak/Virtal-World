#pragma once
#include "Plant.h"
class SowThistle :
	public Plant
{
public:
	SowThistle(World& world, int x, int y);
	~SowThistle();
	bool specialCollision(Organism*);
	bool specialAction();
private:
	void spread();
};

