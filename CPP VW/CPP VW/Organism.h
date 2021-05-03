#pragma once
#include "World.h"
#include <string>

class World;
class Organism {
protected:
	World& world;
	int power;
	int initiative;
	int posX;
	int posY;
	int age;
	bool roundDone;
	char sign;
	int fieldinvec;
public:
	virtual void Action()=0;
	virtual bool Multiply(int x, int y)=0;
	int GetPosX();
	int GetPosY();
	void SetPosX(int x);
	void SetAge(int n);
	void SetInitiative(int n);
	void SetPosY(int y);
	int GetPower();
	int GetAge();
	char GetSign();
	int GetFieldInV();
	void SetFieldInV(int);
	void IncreaseAge();
	void SetPower(int p);
	int GetInitiative();
	Organism(World&,int,int);
	virtual bool specialAction()=0;
	virtual bool specialCollision(Organism*)=0;
	~Organism();
	void setRoundDone(bool);
	bool getRoundDone();
};
