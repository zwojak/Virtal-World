#pragma once
#include "Organism.h"
class Plant :
	public Organism
{
public:
	Plant(World& world, int x, int y);
	~Plant();
	void Action();
	virtual bool Multiply(int posX, int posY);
protected:
};

