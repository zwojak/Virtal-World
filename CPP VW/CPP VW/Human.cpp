#include "Human.h"
#include <conio.h>
#define SUPER_POWER_TIME 5
#define SUPER_POWER_WAIT_TIME 5
Human::Human(World& world, int x, int y) :
	Animal(world, x, y)
{
	this->alive = 1;
	this->sign = 'H';
	this->initiative = 4;
	this->power = 5;
	this->superPowerCounter = 0;
	this->superPowerWaitCounter = 0;
}

void Human::SetAlive(int number) {
	this->alive=number;
}

bool Human::isAlive(){
	return this->alive;
}

bool Human::specialCollision(Organism* other){
	return false;
}
bool Human::specialAction() {
	int fields, x, y;
	world.DrawWorld();
	do {
		x = 0;
		y = 0;
		char ch = _getch();
		if (ch == 'x'){
			if (_kbhit())ch = _getch();
			if (this->superPowerWaitCounter == 0 && superPowerCounter==0) {
				this->SetSuperPowerCount(SUPER_POWER_TIME);
				world.DrawWorld();
			}
		}
		if (ch == 's') {
			world.Save();
		}
		if (ch == 'l') {
			world.Load();
		}
		if (this->superPowerCounter > 0) {
			if (this->superPowerCounter > 2)
				fields = 2;
			if (this->superPowerCounter <= 2)
				fields = rand() % 2 + 1;
		}
		else
			fields = 1;
		if (_kbhit())ch = _getch();
		switch (ch)
		{
		case 72:		//UP
		{
			y = -1 * fields;
			break;
		}
		case 80:	    //DOWN
		{
			y = 1 * fields;
			break;
		}
		case 77:		//RIGHT
		{
			x = 1 * fields;
			break;
		}
		case 75:		//LEFT
		{
			x = -1 * fields;
			break;
		}
		}
	} while (!world.InBorders(this->GetPosX() + x, this->GetPosY() + y) || (x==0 && y==0));
	if (x != 0 || y != 0) {
		if (this->superPowerWaitCounter > 0) {
			this->SetSuperPowerCd(this->superPowerWaitCounter - 1);
		}
		if (this->superPowerCounter > 0) {
			this->SetSuperPowerCount(this->superPowerCounter - 1);
			if (this->superPowerCounter == 0)
				this->SetSuperPowerCd(SUPER_POWER_WAIT_TIME);
		}
		world.WorldMove(this->GetPosX(), this->GetPosY(), this->GetPosX() + x, this->GetPosY() + y);
	}
	return true;
}

Human::~Human(){
}

void Human::SetSuperPowerCd(int number){
	this->superPowerWaitCounter = number;
}

void Human::SetSuperPowerCount(int number){
	this->superPowerCounter = number;
}

int Human::getSuperPowerCd(){
	return this->superPowerWaitCounter;
}

int Human::getSuperPowerCount(){
	return this->superPowerCounter;
}