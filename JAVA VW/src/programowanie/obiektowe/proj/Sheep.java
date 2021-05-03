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
public class Sheep extends Animal{

    public Sheep(Position position, World world) {
        super(position, world);
        this.name="Sheep";
        this.initiative=4;
        this.strength=4;
    }
    
}
