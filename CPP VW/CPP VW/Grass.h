#pragma once
#include "Plant.h"
class Grass :
	public Plant
{
public:
	Grass(World& world, int x, int y);
	~Grass();
	bool specialCollision(Organism*);
	bool specialAction();
private:
	void spread();
};

