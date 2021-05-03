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
public class SowThistle  extends Plant{
    
    public SowThistle(Position position, World world) {
        super(position, world);
        this.name="SowThistle";
        this.initiative=0;
        this.strength=0;
    }
    
    @Override
    public void action()
    {
        multiply();
        multiply();
        multiply();
    }
    
    
}
