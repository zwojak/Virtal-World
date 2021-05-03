/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programowanie.obiektowe.proj;

import java.util.Random;

/**
 *
 * @author kubaz
 */
public class Plant extends Organism{
    
    public Plant(Position position, World world){
        super(position,world);
        this.strength=0;
        this.initiative=0;
    }
    
    @Override
    public void multiply(){
        Random random = new Random();
        Position newPos = world.freeRandomAround(location, 1);
        if(newPos.isEqual(location))return;
        if(random.nextInt(15)==0){
            world.addOrganism(newPos, name);
            System.out.println(this.getName()+ " multiplies");
        }
    }
    
    public void action(){
        multiply();
    }
    
}
