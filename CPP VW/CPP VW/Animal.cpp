#include <iostream>
#include "Animal.h"
#include <time.h>

Animal::Animal(World& worldref, int x, int y) :
	Organism(worldref, x, y)
{
}
void Animal::Action() {
	if (this->specialAction())
		return;
	this->Move();
};
void Animal::Collision(Organism& Organism) {};
Animal::~Animal() {};

bool Animal::Multiply(int posX, int posY) {
	for (int y = -1; y < 2; y++) {
		for (int x = -1; x < 2; x++) {
			if (world.InBorders(posX + x, posY + y) && world.IsEmpty(posX + x, posY + y)) {
				world.AddOrganism(posX + x, posY + y, this->GetSign());
				return true;
			}
		}
	}
	return false;
};
void Animal::Move(int fields) {
	int x, y;
	do {
		x = (rand() % 3 - 1)*fields;
		y = (rand() % 3 - 1)*fields;
	} while (!world.InBorders(this->posX + x, this->posY + y) || x==0 && y==0);
		world.WorldMove(this->posX, this->posY, this->posX + x, this->posY + y);
};