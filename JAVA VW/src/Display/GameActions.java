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
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kubaz
 */
public class GameActions implements ActionListener
{
    private String name;
    
    public String filename;
    
    WorldManager worldManager;
    
        public GameActions(WorldManager worldManager, String name){
            this.worldManager=worldManager;
            this.name=name;
        }
    
        @Override
        public void actionPerformed(ActionEvent event){
                if(name == "Save"){
                    try{
                        filename = JOptionPane.showInputDialog("Type Save Name", "");
                        worldManager.save(filename);
                    }
                    catch(FileNotFoundException ex){
                        Logger.getLogger(KeyListenerFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(name == "Load"){
                    filename = JOptionPane.showInputDialog("Type Save Name you want to load", "");
                     worldManager.load(filename);
                }
                if(name == "Next Turn"){
                    worldManager.executeTurn(new Position(-1,-1));
                }
        }
}
