/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programowanie.obiektowe.proj;
import java.awt.event.*;
import java.util.Random;

/**
 *
 * @author kubaz
 */
public class Human extends Animal{
    
    private int specialAbilityCounter;
    
    private int specialAbilityWaitCounter;
    
    public int getSpecWaitCount(){
        return this.specialAbilityWaitCounter;
    }
    
     public int getSpecCount(){
        return this.specialAbilityCounter;
    }
     
      public void setAC(int a){
        specialAbilityCounter = a;
    }

      public void setAWC(int a){
        specialAbilityWaitCounter = a;
    }
      
    public Human(Position position, World world) {
        super(position, world);
        this.specialAbilityCounter = 0;
        this.specialAbilityWaitCounter = 0;
        this.name="Human";
        this.initiative=4;
        this.strength=5;
    }
    
     public void action(Position delta){
        if(delta.isEqual(new Position(0,0))){
            if(specialAbilityWaitCounter==0 && specialAbilityCounter==0){
                specialAbilityCounter=6;
                System.out.println("Your superpower is on now!");
            }
            else{
                if(specialAbilityWaitCounter==0)
                System.out.println("Your superpower is already on");
                else
                {
                    System.out.println("You have to wait " + (specialAbilityWaitCounter-1) + " rounds");
                }
            }
        }
         if(delta.isEqual(new Position(-1,-1))){
          return;
         }
        if(specialAbilityCounter>0){
            if(specialAbilityCounter>2)
                move(new Position(location.x+2*delta.x,location.y+2*delta.y));
            if(specialAbilityCounter <= 2){
                Random random = new Random();
                if(random.nextBoolean()==true)
                    move(new Position(location.x+delta.x,location.y+delta.y));
                else
                 move(new Position(location.x+2*delta.x,location.y+2*delta.y));
            }
            specialAbilityCounter--;
            System.out.println("Your power will last: " + specialAbilityCounter +" rounds");
            if(specialAbilityCounter==0){
                specialAbilityWaitCounter=5;
            }
        }
        else{
            move(new Position(location.x+delta.x,location.y+delta.y));
            if(specialAbilityWaitCounter>0)
                specialAbilityWaitCounter--;
        }
    }
}


      
          