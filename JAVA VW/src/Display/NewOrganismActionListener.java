/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import programowanie.obiektowe.proj.Position;
import programowanie.obiektowe.proj.WorldManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kubaz
 */
public class NewOrganismActionListener implements ActionListener
{
    private String name;
    
    private int x;
    
    private int y;
    
    WorldManager worldManager;
    
        public NewOrganismActionListener(int x, int y, WorldManager worldManager, String name){
            this.name=name;
            this.x=x;
            this.y=y;
            this.worldManager=worldManager;
        }
    
        @Override
        public void actionPerformed(ActionEvent event){
                    worldManager.addOrganism(new Position(x,y),name);
                    System.out.println("You created " + name);
                    worldManager.drawWorld();
                }
}
