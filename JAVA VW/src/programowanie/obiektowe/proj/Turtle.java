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
public class Turtle extends Animal{

    public Turtle(Position position, World world) {
        super(position, world);
        this.name="Turtle";
        this.initiative=1;
        this.strength=2;
    }
    
    @Override 
    public void action(){
        this.movePermission=true;
        Random random = new Random();
        if(random.nextInt(4)<3)
            return;
        move(world.randomAround(location, 1));
    }
    
      @Override
    public boolean specialCollision(Organism other){
        if(other.getStrength()<5){
            other.movePermission=false;
            return false;
        }  
        return true;    
    }
}
