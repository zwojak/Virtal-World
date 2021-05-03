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
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
/**
 *
 * @author kubaz
 */
public class RightClickPopUp extends JPopupMenu{
    
    public int menuLength;
    
    JMenuItem[] menuItems;
    
    public RightClickPopUp(int x, int y, WorldManager worldManager)
    {
        this.menuLength = 10;
        
        menuItems = new JMenuItem[menuLength];
        menuItems[0] = new JMenuItem("Antelope");
        menuItems[1] = new JMenuItem("Fox");
        menuItems[2] = new JMenuItem("Sheep");
        menuItems[3] = new JMenuItem("Turtle");
        menuItems[4] = new JMenuItem("Wolf");
        menuItems[5] = new JMenuItem("Grass");
        menuItems[6] = new JMenuItem("SowThistle");
        menuItems[7] = new JMenuItem("WolfBerries");
        menuItems[8] = new JMenuItem("Guarana");
        menuItems[9] = new JMenuItem("PineBorscht");
        
        for(int i=0;i<menuLength;i++){
            add(menuItems[i]);
                menuItems[i].addActionListener(new NewOrganismActionListener(x,y,worldManager,menuItems[i].getText()));
        }
    }
}
