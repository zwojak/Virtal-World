#include "Organism.h"

using namespace std;

Organism::Organism(World& worldref, int x, int y) :
	world(worldref)
{
	this->posX = x;
	this->posY = y;
	this->age = 0;
}
Organism::~Organism() {
}
char Organism::GetSign() {
	return this->sign;
}
void Organism::SetAge(int number) {
	this->age = number;
}
void Organism::SetInitiative(int number) {
	this->initiative = number;
}
int Organism::GetInitiative() {
	return initiative;
}
int Organism::GetAge() {
	return age;
}
int Organism::GetPosX() {
	return this->posX;
}
int Organism::GetPosY() {
	return this->posY;
}
void Organism::SetPosX(int x) {
	this->posX = x;
}
void Organism::SetPower(int p) {
	this->power = p;
	return;
}
void Organism::SetPosY(int y) {
	this->posY = y;
	return;
}
void Organism::IncreaseAge() {
	this->age++;
}
int Organism::GetPower() {
	return this->power;
}
void Organism::setRoundDone(bool x) {
	this->roundDone = x;
}
bool Organism::getRoundDone() {
	return this->roundDone;
}
int Organism::GetFieldInV() {
	return this->fieldinvec;
}
void Organism::SetFieldInV(int n) {
	this->fieldinvec = n;
}