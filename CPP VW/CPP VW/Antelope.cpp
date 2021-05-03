#include "Antelope.h"
#include "World.h"

Antelope::Antelope(World& worldref, int x, int y) :
	Animal(worldref, x, y)
{
	this->power = 4;
	this->initiative = 4;
	this->sign = 'A';
}
Antelope::~Antelope() {}
bool Antelope::specialCollision(Organism* other){
	int a = rand() % 2,x,y;
	int tempX, tempY;
	if (a == 1) {
		do {
			x = (rand() % 3 - 1);
			y = (rand() % 3 - 1);
		} while (!world.InBorders(this->posX + x, this->posY + y) || x == 0 && y == 0 || !world.IsEmpty(this->posX + x, this->posY + y));
		tempX = this->posX;
		tempY = this->posY;
		world.WorldMove(this->posX, this->posY, this->posX + x, this->posY + y);
		world.WorldMove(other->GetPosX(), other->GetPosY(), tempX, tempY);
		return true;
	}
	else {
		return false;
	}
}
bool Antelope::specialAction(){
	this->Move(2);
	return true;
}