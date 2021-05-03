#pragma once
#include <iostream>
#include "Organism.h"
#include "Comments.h"
#include <vector>
#define MAX_INITIATIVE 8

using namespace std;
class Organism;
class Human;
class Comments;
class World {
	Organism*** organisms;
	int width, height;
	int round;
	vector <Organism*> orgVector[MAX_INITIATIVE];
	Human* humanPtr;
	bool HumanAlive;
	Comments comments;
	int GetRound();
	public:
		World(int width, int heigh);
		void PlantSpreadCom(int x, int y);
		Organism* AddOrganism(int posX, int posY, char sign);
		int GetWidth();
		~World();
		int GetHeight();
		void Save();
		void Load();
		void PlantKillCom(int fromX, int fromY, int DestX, int DestY);
		void DrawWorld();
		void DeleteOrganism(Organism&,int,int);
		void Start();
		void DoRound(bool);
		void changeInitiative(Organism*, int);
		int GetPowerOfField(int x, int y);
		int GetInitiativeOfField(int x, int y);
		Organism* GetOrganismOfField(int x, int y);
		bool IsEmpty(int posX, int posY);
		bool InBorders(int x, int y);
		void WorldMove(int fromX, int fromY, int DestinationX, int DestinationY);
		int GetFieldInVector(Organism* organism);
};