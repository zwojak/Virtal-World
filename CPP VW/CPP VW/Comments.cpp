#include "Comments.h"
#include "Organism.h"
#include <iostream>
#define MAX_COMS 10

using namespace std;

Comments::Comments()
{
}


Comments::~Comments()
{
}

void Comments::AddComment(string text)
{
	this->comments.push(text);
}

void::Comments::writeComments()
{
	int counter = 0;
	while (!comments.empty() && counter < MAX_COMS)
	{
		cout << comments.front() << " ";
		this->comments.pop();
		counter++;
	}
	while (!comments.empty())comments.pop();
}

void Comments::createFightLog(Organism* winner, Organism* looser)
{
	string text = "\n";
	text.push_back(winner->GetSign());
	if(looser->GetInitiative()>0)
		text += " kills ";
	else
		text += " eats ";
	text.push_back(looser->GetSign());
	this->AddComment(text);
	return;
}


void Comments::createMultiplicationLog(Organism* org)
{
	string text = "\n";
	text.push_back(org->GetSign());
	if(org->GetInitiative()>0)
		text += (" multiplies");
	if (org->GetInitiative() == 0)
		text += (" spreads");
	this->AddComment(text);
	return;
}
