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
public class Antelope extends Animal{

    public Antelope(Position position, World world) {
        super(position, world);
        this.name="Antelope";
        this.initiative=4;
        this.strength=4;
    }
    
    @Override
    public void action()
    {
      move(world.randomAround(location,2));
    }
    
      @Override
    public boolean specialCollision(Organism other){
        Random random = new Random();
        if(random.nextBoolean()){
            Position newLocation = world.freeRandomAround(location, 1);
            if(newLocation==this.location)return true;
            this.move(newLocation);
            return false;
        }
        return true;
    }
    
}
