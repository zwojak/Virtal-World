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
public class Grass extends Plant{
    
        public Grass(Position position, World world) {
        super(position, world);
        this.name="Grass";
        this.initiative=0;
        this.strength=0;
    }   
}
