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
 public class Animal extends Organism{

    public Animal(Position position, World world) {
        super(position, world);
    }
    
    @Override
    protected void multiply(){
        Position newLoc = world.freeRandomAround(location, 1);
        if(newLoc.isEqual(this.location))return;
        world.addOrganism(newLoc, this.getName());
        System.out.println(this.getName()+ " multiplies");
    }
    
    @Override
    public void action(){
       this.movePermission=true;
       move(world.randomAround(this.location, 1));
    }
    
     protected void move (Position newPos){
        if(newPos.isEqual(location))return;
        if(!world.inBoundaries(newPos))return;
        if(world.isEmpty(newPos)){
            location=newPos;
            return;
        }
        Organism enemy = world.findObject(newPos);
        
        if(!enemy.isKilled())
            collision(this, enemy);
        
        if(!this.killed && this.movePermission){
            location=newPos;
        }
    }
}
    