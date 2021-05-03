#pragma once
#include <iostream>
#include "Organism.h"
class Animal :
	public Organism
{
public:
	Animal(World& worldref, int x, int y);
	~Animal();
	virtual bool Multiply(int ToY, int ToX);
protected:
	void Action();
	void Collision(Organism&);
	virtual void Move(int fields = 1);
};