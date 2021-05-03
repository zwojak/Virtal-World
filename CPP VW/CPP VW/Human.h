#pragma once
#include "Animal.h"
class Human :
	public Animal
{
public:
	Human(World& world, int x, int y);
	~Human();
	bool isAlive();
	int getSuperPowerCd();
	int getSuperPowerCount();
	void SetSuperPowerCd(int);
	void SetSuperPowerCount(int);
	bool specialCollision(Organism*);
	bool specialAction();
	void SetAlive(int number);
private:
	bool alive;
	int superPowerCounter;
	int superPowerWaitCounter;
};

