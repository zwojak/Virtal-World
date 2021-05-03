#include "World.h"
#include "Organism.h"
#include <iostream>
#include <time.h>
#include "WolfBerries.h"
#include "Grass.h"
#include "Guarana.h"
#include "PineBorscht.h"
#include "SowThistle.h"
#include "Turtle.h"
#include "Wolf.h"
#include "Sheep.h"
#include "Antelope.h"
#include "Fox.h"
#include "Human.h"
#include <windows.h>
#include <vector>
#include <conio.h>
#include <fstream>

#define NUMBER_OF_ORGANISMS_AT_START 7
#define AMOUNT_OF_ORG_TYPES 10
#define MAX_INITIATIVE 8
using namespace std;


World::World(int width, int height)
{
	this->width = width;
	this->height = height;
	this->round = 0;
	this->HumanAlive = 1;
	this->organisms = new Organism**[height];
	for (int y = 0; y < height; y++) {
		this->organisms[y] = new Organism*[width];
		for (int x = 0; x < width; x++) {
			this->organisms[y][x] = NULL;
		}
	}
}
bool World::IsEmpty(int posX,int posY) {
	if (organisms[posY][posX] == NULL)
		return true;
	else 
		return false;
}
int World::GetWidth() {
	return width;
}
int World::GetHeight() {
	return height;
}
void World::DoRound(bool loaded) {								//TUROWANIE
		for (int y = 0; y < this->height; y++) {
			for (int x = 0; x < this->width; x++) {
				if (organisms[y][x] != NULL) {
					this->organisms[y][x]->setRoundDone(0);
				}
			}
		}
	for (int i = MAX_INITIATIVE - 1; i >= 0; i--) {				//PO INICJATYWIE
		for (int age = 0; age < orgVector[i].size(); age++) {   //PO WIEKU
			if(!loaded || loaded && orgVector[i][age]==this->humanPtr){
					if (!this->orgVector[i][age]->getRoundDone()) {
						this->orgVector[i][age]->setRoundDone(1);
						this->orgVector[i][age]->IncreaseAge();
						this->orgVector[i][age]->Action();
						loaded = 0;
				}
			}
		}
	}
	this->round++;
	if (!this->HumanAlive) {
		Sleep(150);
		this->DrawWorld();
	}
	this->DoRound(0);
}

void World::PlantKillCom(int fromX, int fromY, int DestX, int DestY) {
	this->comments.createFightLog(this->organisms[fromY][fromX], this->organisms[DestY][DestX]);
}

int World::GetRound() {
	return round;
}
World::~World(){
	delete[] organisms;
}
void World::PlantSpreadCom(int x, int y) {
	this->comments.createMultiplicationLog(this->organisms[y][x]);
}

void World::WorldMove(int fromX, int fromY, int DestinationX, int DestinationY) {
	if (organisms[DestinationY][DestinationX] == NULL) {															//RUCH
		swap(organisms[DestinationY][DestinationX],organisms[fromY][fromX]);
		organisms[DestinationY][DestinationX]->SetPosX(DestinationX);
		organisms[DestinationY][DestinationX]->SetPosY(DestinationY);
		return;
	}
	else {
		if (organisms[fromY][fromX]->GetSign() == organisms[DestinationY][DestinationX]->GetSign()) {				//ROZMAZANIE
			if (organisms[fromY][fromX]->Multiply(fromX,fromY))
				this->comments.createMultiplicationLog(this->organisms[fromY][fromX]);
			return;
		}
		else {
			if (organisms[fromY][fromX]->GetSign() != organisms[DestinationY][DestinationX]->GetSign()) {			//WALKA
				if(organisms[DestinationY][DestinationX]->specialCollision(organisms[fromY][fromX]))
					return;
				if (organisms[fromY][fromX]->GetPower() >= organisms[DestinationY][DestinationX]->GetPower()) {		//ATAK NA SLABSZEGO PRZECIWNIKA
					this->comments.createFightLog(this->organisms[fromY][fromX], this->organisms[DestinationY][DestinationX]);
					this->DeleteOrganism(*organisms[DestinationY][DestinationX], DestinationX, DestinationY);
					swap(organisms[DestinationY][DestinationX], organisms[fromY][fromX]);
					organisms[DestinationY][DestinationX]->SetPosX(DestinationX);
					organisms[DestinationY][DestinationX]->SetPosY(DestinationY);
					return;
				}
				else {																							//ATAK NA MOCNIEJSZEGO PRZECIWNIKA
					this->comments.createFightLog(this->organisms[DestinationY][DestinationX], this->organisms[fromY][fromX]);
					this->DeleteOrganism(*organisms[fromY][fromX], fromX, fromY);
					return;
				}
			}
		}
	}
}
int World::GetPowerOfField(int x, int y) {
	if (organisms[y][x] != NULL) {
		int power = organisms[y][x]->GetPower();
		return power;
	}
	else return 0;
}
int World::GetInitiativeOfField(int x, int y) {
	if (organisms[y][x] != NULL) {
		int init = organisms[y][x]->GetInitiative();
		return init;
	}
	else return 0;
}
Organism* World::GetOrganismOfField(int x, int y) {
	if (organisms[y][x] != NULL) {
		Organism* ptr;
		ptr = organisms[y][x];
		return ptr;
	}
	else return NULL;
}

void World::Start() {
	int x, y, amount=NUMBER_OF_ORGANISMS_AT_START;
	int types,number;
	do {
		y = rand() % this->GetHeight();
		x = rand() % this->GetWidth();
		if (this->organisms[y][x] == NULL) {
																				//
			
			types = rand() % AMOUNT_OF_ORG_TYPES;
			switch (types) {
			case 0:{
				AddOrganism(x, y, 'W');
				break;
			}
			case 1: {
				AddOrganism(x, y, 'F');
				break;
			}
			case 2: {
				AddOrganism(x, y, 'T');
				break;
			}
			case 3: {
				AddOrganism(x, y, 'S');
				break;
			}
			case 4: {
				AddOrganism(x, y, 'A');
				break;
			}
			case 5: {
				AddOrganism(x, y, 'p');
				break;
			}
			case 6: {
				AddOrganism(x, y, 'x');
				break;
			}
			case 7: {
				AddOrganism(x, y, 'b');
				break;
			}
			case 8: {
				AddOrganism(x, y, 'g');
				break;
			}
			case 9: {
				AddOrganism(x, y, 's');
				break;
			}
			}
																		//
			//AddOrganism(x, y, 'A');
			amount--;
			}
	} while (amount);
	do {
		y = rand() % this->GetHeight();
		x = rand() % this->GetWidth();
	} while (this->organisms[y][x] != NULL);
	this->humanPtr = (Human*)this->AddOrganism(x, y, 'H');
	this->DrawWorld();
	this->DoRound(0);
}
bool World::InBorders(int x, int y) {
	if (x > this->width-1 || x < 0)
		return false;
	if(y>this->height-1 || y<0)
		return false;
	return true;
}

Organism* World::AddOrganism(int x, int y, char sign){
	if (this->organisms[y][x] != NULL){
		return NULL;
	}
	else{
		Organism* ptr = NULL;
		switch (sign){
		case 'H':
		{
			ptr = new Human(*this, x, y);
			break;
		}
		case 'p':
		{
			ptr = new PineBorscht(*this, x, y);
			break;
		}
		case 'b':
		{
			ptr = new WolfBerries(*this, x, y);
			break;
		}
		case 'x':
		{
			ptr = new Guarana(*this, x, y);
			break;
		}
		case 's':
		{
			ptr = new SowThistle(*this, x, y);
			break;
		}
		case 'g':
		{
			ptr = new Grass(*this, x, y);
			break;
		}
		case 'A':
		{
			ptr = new Antelope(*this, x, y);
			break;
		}
		case 'F':
		{
			ptr = new Fox(*this, x, y);
			break;
		}
		case 'T':
		{
			ptr = new Turtle(*this, x, y);
			break;
		}
		case 'S':
		{
			ptr = new Sheep(*this, x, y);
			break;
		}
		case 'W':
		{
			ptr = new Wolf(*this, x, y);
			break;
		}
		default:
		{
			throw "Unable to read sign";
		}
		}

		this->organisms[y][x] = ptr;
		this->orgVector[ptr->GetInitiative()].push_back(ptr);
		return ptr;
	}
};
void World::DrawWorld() {																//RYSOWANIE
	system("cls");
	for (int i = 0; i < GetWidth() + 2; i++)
		cout << '-';
	cout << endl;
	for (int y = 0; y < GetHeight(); y++) {
		cout << '|';
		for (int x = 0; x < GetWidth(); x++) {
			if (organisms[y][x] != NULL) {
				cout << organisms[y][x]->GetSign();
			}
			else
				cout << ' ';
		}
		cout << '|';
		if (y == 0)
			cout << "\x20\x20\x20\x20\x20\x20\x20\x20\x20s - save";
		if (y == 1)
			cout << "\x20\x20\x20\x20\x20\x20\x20\x20\x20l - load";
		if (y == 2)
			cout << "\x20\x20\x20\x20\x20\x20\x20\x20\x20x - Super Power";
		cout << endl;
	}
	for (int i = 0; i < GetWidth() + 2; i++)
		cout << '-';
	cout << endl;
	cout <<"Round: "<<this->GetRound();
	if (this->HumanAlive && this->humanPtr->getSuperPowerCount() >0 && this->humanPtr->getSuperPowerCount() <= 5) {
		cout << endl << "Your Special Power will last: " << humanPtr->getSuperPowerCount();
		if (humanPtr->getSuperPowerCount() == 1)
			cout << " round";
		else
			cout << " rounds";
	}
	this->comments.writeComments();

}
void World::DeleteOrganism(Organism& organism,int x, int y) {									//USUWANIE
	int init = organism.GetInitiative();
	for (vector <Organism*>::iterator i = this->orgVector[init].begin(); i < this->orgVector[init].end(); i++) {
		if (*i == &organism) {
			this->orgVector[init].erase(i);
			break;
		}
	}
	if (this->organisms[y][x] == humanPtr) {
		this->HumanAlive = 0;
	}
	this->organisms[y][x] = NULL;
	delete &organism;
}
void World::Save() {																						//ZAPIS
	fstream file;
	cout <<endl<< "Type save name: "<<endl;
	string name;
	cin >> name;
	file.open(name, std::ios::out | std::ios::trunc);
	file << this->round << "\n";
	file << this->width << " " << this->height << "\n";
	for (int y = 0; y < height; y++) {
		for (int x = 0; x < width; x++) {
			if (this->organisms[y][x] != NULL) {
				file << this->organisms[y][x]->GetSign() << " ";
				file << this->organisms[y][x]->GetAge() << " ";
				file << this->organisms[y][x]->GetPower() << " ";
				file << this->organisms[y][x]->GetInitiative() << " ";
				file << this->GetFieldInVector(organisms[y][x]) << " ";
				if (this->organisms[y][x] == this->humanPtr)
					file << this->humanPtr->getSuperPowerCount() << " " << this->humanPtr->getSuperPowerCd() << " ";
				file << "\n";
			}
			else {
				file << "0\n";
			}
		}
	}
	this->DrawWorld();
}
void World::Load() {																					//WCZYTYWANIE
	fstream file;
	cout <<endl<< "Write the name of save: \n";
	string name;
	cin >> name;
	file.open(name, std::ios::in);
	if (!file.good()) {
		this->DrawWorld();
		return;
	}
	for (int y = 0; y < this->height; y++) {
		for (int x = 0; x < this->width; x++) {
			if (organisms[y][x] != NULL) {
				this->DeleteOrganism(*this->organisms[y][x], x, y);
			}
		}
	}
	file >> this->round;
	file >> this->width;
	file >> this->height;
	this->organisms = new Organism**[height];
	for (int y = 0; y < height; y++) {
		this->organisms[y] = new Organism*[width];
		for (int x = 0; x < width; x++) {
			this->organisms[y][x] = NULL;
		}
	}
	char sign;
	int age, power, init, cd, count,fieldinvec;
	for (int y = 0; y < this->height; y++){
		for (int x = 0; x < this->width; x++){
			file >> sign;
			if (sign != '0'){
				file>>age>> power >> init >> fieldinvec;
				this->AddOrganism(x, y, sign);
				if (sign != 'H') {
						this->organisms[y][x]->SetAge(age);
						this->organisms[y][x]->SetPower(power);
						this->organisms[y][x]->SetFieldInV(fieldinvec);
				}
				else {
					file >> count >> cd;
					this->humanPtr->SetAge(age);
					this->humanPtr->SetInitiative(init);
					this->humanPtr->SetPower(power);
					this->humanPtr->SetSuperPowerCd(cd);
					this->humanPtr->SetSuperPowerCount(count);
					this->HumanAlive = 1;
					this->humanPtr->SetFieldInV(fieldinvec);
				}
			}
		}
	}
	for (int y = 0; y < this->height; y++) {
		for (int x = 0; x < this->width; x++) {
			if (organisms[y][x] != NULL) {
				this->changeInitiative(organisms[y][x], organisms[y][x]->GetFieldInV());
			}
		}
	}
	this->DoRound(1);
}
int World::GetFieldInVector(Organism* organism) {
	int i = 0;
	for (std::vector <Organism*>::iterator iter = this->orgVector[organism->GetInitiative()].begin(); iter < this->orgVector[organism->GetInitiative()].end(); iter++) {
		if (*iter == organism) {
			return i;
		}
		i++;
	}
}
void World::changeInitiative(Organism* organism, int place){
	int i = 0;
	for (std::vector <Organism*>::iterator iter = this->orgVector[organism->GetInitiative()].begin(); iter < this->orgVector[organism->GetInitiative()].end(); iter++) {
		if (i == place) {
			(*iter) = organism;
		}
		i++;
	}
}