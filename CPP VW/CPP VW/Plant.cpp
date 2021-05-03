#include "Plant.h"
#include <iostream>
#include <time.h>

Plant::Plant(World& world, int x, int y) :
	Organism(world, x, y){
	this->initiative = 0;
	this->power = 0;
}
Plant::~Plant(){
}
void Plant::Action(){
	if (this->specialAction())
		return;
	this->Multiply(this->GetPosX(),this->GetPosY());
}
bool Plant::Multiply(int posX, int posY){
	int x = rand() % 20;
	if(x==0){
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++) {
				if (world.InBorders(posX + x, posY + y) && world.IsEmpty(posX + x, posY + y)) {
					world.AddOrganism(posX + x, posY + y, this->GetSign());
					world.PlantSpreadCom(posX, posY);
					return true;
				}
			}
		}
	}
	return false;
}