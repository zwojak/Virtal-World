/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programowanie.obiektowe.proj;

import Display.Frame;
import Display.KeyListenerFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kubaz
 */
public class WorldManager extends World{
    
    private Human human;
            
       public WorldManager(int x, int y){
           super(x,y);
           this.round=1;
           mainFrame = new Frame(x, y, this);
           generateWorld();
       }
        
    private void generateWorld(){
        human=(Human)this.addOrganism(new Position(5,0), "Human");
        this.addOrganism(new Position(5,1), "Antelope");
        this.addOrganism(new Position(3,4), "Fox");
        this.addOrganism(new Position(3,5), "PineBorscht");
        this.addOrganism(new Position(3,2), "Guarana");
        this.addOrganism(new Position(3,14), "WolfBerries");
        this.addOrganism(new Position(3,7), "Grass");
        this.addOrganism(new Position(3,11), "Grass");
        this.addOrganism(new Position(3,3), "Turtle");
       this.addOrganism(new Position(4,3), "Antelope");  
        this.addOrganism(new Position(15,0), "Antelope");  
        this.addOrganism(new Position(9,2), "Turtle");
        this.addOrganism(new Position(1,11), "Fox");
        this.addOrganism(new Position(4,4), "Wolf");  
        this.addOrganism(new Position(12,4), "Sheep");  
        this.addOrganism(new Position(5,9), "Turtle");  
        this.addOrganism(new Position(17,8), "Fox");  
        this.addOrganism(new Position(5,17), "Wolf");  
        
      //  this.addOrganism(new Position(5,12), "Sheep"); */
        drawWorld();
    }
    
        public void save(String filename) throws FileNotFoundException {
            PrintWriter zapis = new PrintWriter(filename);
            for(ArrayList <Organism> initiative : organisms){
                zapis.print(initiative.size()+String.format("%n"));
                for(Organism actual : initiative){
                    if(actual.equals(human)){
                        zapis.print(actual.getName()+" "+actual.getLocation().x+" "+actual.getLocation().y+" "+actual.getAge()+" "+actual.getStrength()+" "+human.getSpecCount() + " " + human.getSpecWaitCount() + String.format("%n"));
                    }
                    else{
                        zapis.print(actual.getName()+" "+actual.getLocation().x+" "+actual.getLocation().y+" "+actual.getAge()+" "+actual.getStrength()+String.format("%n"));    
                    }
                }   
            }
            zapis.print(this.round);
            zapis.close();
            System.out.println("Zapis udany!");
         }
        
        public void load(String filename){
            for(ArrayList list : organisms){
                list.clear();
            }
            File file = new File(filename);
            Scanner scanner;
            try{
                scanner = new Scanner(file);
            }
            catch(FileNotFoundException ex){
                return;
            }
            for(int i=0;i<10;i++){ 
                int count = scanner.nextInt();
                for(int j=0;j<count;j++){
                    String name=scanner.next();
                    Position position = new Position(scanner.nextInt(),scanner.nextInt());
                    Organism newOrg = this.addOrganism(position, name);
                    newOrg.setAge(scanner.nextInt());
                    newOrg.setStrength(scanner.nextInt());
                    if(newOrg.getName()=="Human"){
                        this.human=(Human) newOrg;
                        human.setAC(scanner.nextInt());
                        human.setAWC(scanner.nextInt());
                    }
                    }
                }
                this.round = (scanner.nextInt());
                this.drawWorld();
        }
    
    private void killOrganisms(){
        for(int i=0;i<organisms.size();i++){
            for(int j=0;j<organisms.get(i).size();j++){
                Organism actual = organisms.get(i).get(j);
                if(actual.isKilled()){
                    organisms.get(i).remove(j);
                }
            }
        }
    }

     public void executeTurn(Position humanMove){
        System.out.println("Round: " + this.round);
        for(int i=organisms.size()-1;i>=0;i--){
            for(int j=0;j<organisms.get(i).size();j++){
                Organism actual = organisms.get(i).get(j);
                if(actual.isKilled()) continue;
                if("Human".equals(actual.getName())){
                    human.action(humanMove);
                    human.setAge(human.getAge()+1);
                    continue;
                }
                actual.action();
                actual.setAge(actual.getAge()+1);
            }
        killOrganisms();
        drawWorld();
         }
        this.round++;
    }
    
    public void drawWorld(){
      mainFrame.clearSimArea();
        organisms.stream().forEach((organism) -> {
            organism.stream().forEach((actual) -> {
                mainFrame.setFieldText(actual.getName(), actual.getLocation().x, actual.getLocation().y);
            });
        });
    }
}
