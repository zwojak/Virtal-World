/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programowanie.obiektowe.proj;

/**
 *
 * @author kubaz
 */
public class Fox extends Animal{

    public Fox(Position position, World world) {
        super(position, world);
        this.name="Fox";
        this.initiative=7;
        this.strength=3;
    }
    
    @Override
    public void action()
    {
        Position newPos;
        int counter=20;
        do{
            if(counter==0)return;
            newPos = world.randomAround(location, 1);
            counter--;
        } while(!world.isEmpty(newPos) && world.findObject(newPos).getStrength()>this.strength);
        move(newPos);
    }
    
}
