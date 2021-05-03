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
public class Guarana  extends Plant{
    
    public Guarana(Position position, World world) {
        super(position, world);
        this.name="Guarana";
        this.initiative=0;
        this.strength=0;
    }
    
    @Override
    public boolean specialCollision(Organism other)
    {
        other.setStrength(other.getStrength()+3);
        return true;
    }
    
}
