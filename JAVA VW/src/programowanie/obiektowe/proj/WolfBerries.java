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
public class WolfBerries  extends Plant{
    
    public WolfBerries(Position position, World world) {
        super(position, world);
        this.name="WolfBerries";
        this.strength=99;
    }
    
    @Override
    public boolean specialCollision(Organism other){
        System.out.println(this.getName()+ " destroys " + other.getName());
        other.kill();
        return false;
    }
    
}
