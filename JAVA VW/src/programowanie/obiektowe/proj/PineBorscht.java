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
public class PineBorscht  extends Plant{
    
    public PineBorscht(Position position, World world) {
        super(position, world);
        this.name="PineBorscht";
        this.strength=0;
        this.initiative=0;
    }
    
    @Override
    public boolean specialCollision(Organism other){
        System.out.println(this.getName()+ " destroys " + other.getName());
        other.kill();
        return false;
    }
    
    @Override 
    public void action(){
        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                Position newPos = new Position(this.getLocation().x+i,this.getLocation().y+j);
                if(world.inBoundaries(newPos) && !world.isEmpty(newPos) && world.findObject(newPos).getInitiative()>0){
                    Organism enemy = world.findObject(newPos);
                    System.out.println(this.getName()+ " destroys " + enemy.getName());
                    enemy.kill();
                }
            }
        }
        multiply();
    }
}
