/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programowanie.obiektowe.proj;
import Display.Frame;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author kubaz
 */
public class World {
    protected Frame mainFrame;
    protected int round;
    Position position;
    private static final int NUM_OF_INIT = 10;
    protected ArrayList <ArrayList <Organism>> organisms;
    Organism newOrganism;
    public World(int x, int y){
        position=new Position(x,y);
        organisms = new ArrayList <>();
        for(int i=0;i<NUM_OF_INIT;i++){
            organisms.add(new ArrayList <>());
        }
    }
    
    
        public Organism findObject(Position position){
        for(ArrayList <Organism> organism : organisms)
        {
            for(Organism actual : organism)
            {
                if(actual.location.isEqual(position))return actual;
            };
        }
        return null;
        }
        
        public Position freeRandomAround(Position center, int range){
           int triesCounter=50;
        Random random = new Random();
        Position newPos = new Position(center.x+((random.nextInt(3)-1)*range),center.y+((random.nextInt(3)-1)*range));
        while(!inBoundaries(newPos) || newPos.equals(center)){
            if(triesCounter==0)return center;
            newPos = new Position(center.x+((random.nextInt(3)-1)*range),center.y+((random.nextInt(3)-1)*range));
            triesCounter--;
        }
        return newPos;
    }
    
    public Position randomAround(Position center, int range){
        Random random = new Random();
        Position newPos = new Position(center.x+(random.nextInt(3)-1)*range,center.y+(random.nextInt(3)-1)*range);
        while(!inBoundaries(newPos) || newPos.equals(center)){
            newPos = new Position(center.x+(random.nextInt(3)-1)*range,center.y+(random.nextInt(3)-1)*range);
        }
        return newPos;
    }
        
    public boolean inBoundaries(Position pos){
        if(pos.x >= 0 && pos.x <position.x && pos.y >=0 && pos.y<position.y)return true;
        return false;
    }
    
    public Organism addOrganism(Position position, String name){
        if(!isEmpty(position))return null;
        switch (name){
            case "Antelope":
                newOrganism = new Antelope(position,this);
                break;
                
            case "Fox":
                newOrganism = new Fox(position,this);
                break;
                
            case "Sheep":
                newOrganism = new Sheep(position, this);
                break;
                
            case "Turtle":
                newOrganism = new Turtle(position, this);
                break;
                
            case "Wolf":
                newOrganism = new Wolf(position, this);
                break;
                
            case "Human":
                newOrganism = new Human(position,this);
                break;
            
            case "Grass":
                newOrganism = new Grass(position,this);
                break;
            
            case "SowThistle":
               newOrganism = new SowThistle(position,this);
                break;
                
            case "Guarana":
                newOrganism = new Guarana(position,this);
                break;
                
            case "WolfBerries":
                newOrganism = new WolfBerries(position,this);
                break;
                
            case "PineBorscht":
                newOrganism = new PineBorscht(position,this);
            break;
                
            default:
                return null;
        }
        
        organisms.get(newOrganism.getInitiative()).add(newOrganism);
        
        return newOrganism;
    }
       
    public boolean isEmpty(Position position)
    {
        for(ArrayList <Organism> organism : organisms)
        {
            for(Organism org : organism)
            {
                if(org.location.isEqual(position))return false;
            };
        }
        return true;
    }
        
        
}
