#pragma once
#define MAX_LOGS 20
#include <string>
#include <queue>
class Organism;
class Comments
{
public:
	Comments();
	~Comments();
	void writeComments();
	void createFightLog(Organism* winner, Organism* loser);
	void createMultiplicationLog(Organism*);
private:
	std::queue <std::string> comments;
	void AddComment(std::string text);
};

