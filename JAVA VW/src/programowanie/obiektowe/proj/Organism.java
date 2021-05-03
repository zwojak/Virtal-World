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
public class Organism {
    
    boolean killed=false;
    
    protected boolean movePermission=true;
    
    public void kill(){
        killed=true;
    }
    
    public boolean isKilled(){
        return killed;
    }
    
    protected String name;

    protected int strength;
    
    public int getStrength(){
        return this.strength;
    }
    
     public void collision(Organism attacker, Organism deffender){
        if(attacker.getName()==deffender.getName()){
            this.multiply();
            attacker.movePermission=false;
            return;
        }
        
        if(!deffender.specialCollision(this))return;
        
        if(attacker.getStrength()>=deffender.getStrength()){
            System.out.println(attacker.getName()+" destroys " + deffender.getName());
            deffender.kill();
            return;
        }
        System.out.println(deffender.getName()+ " destroys " + attacker.getName());
        attacker.kill();
        return;
    }
    
    public void setStrength(int value){
        this.strength=value;
    }
        protected int initiative;
    
    protected int age;
    
    protected Position location;
    
    protected World world;
    
    public Organism(Position position, World world)
    {
        this.age=0;
        this.location=position;
        this.world=world;
    }
    
    public void action(){
    };
    
    public boolean specialCollision(Organism other){
        return true;
    }
    
    public int getAge(){
        return this.age;
    }
    
        public String getName(){
        return this.name;
    }
    
    public int getInitiative(){
        return this.initiative;
    }
    
    public void setAge(int age){
        this.age=age;
    }
    
    public Position getLocation(){
        return this.location;
    }
    
    protected void multiply() {
        
    }
   
}
