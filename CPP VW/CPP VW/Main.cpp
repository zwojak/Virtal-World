#include <iostream>
#include "World.h"
#include <time.h>
using namespace std;

int main() {
	srand(time(NULL));
	int width, height;
	cout << "NOWA GRA, PODAJ WYMIARY PLANSZY: ";
	cin >> width;
	cin >> height;
	World world(width,height);
	world.Start();
	system("pause");
	return 0;
}