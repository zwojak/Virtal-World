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
public class Wolf extends Animal{

    public Wolf(Position position, World world) {
        super(position, world);
        this.name="Wolf";
        this.initiative=5;
        this.strength=9;
    }
    
}
