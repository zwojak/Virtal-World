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
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
/**
 *
 * @author kubaz
 */
public class LeftClickPopUp extends JPopupMenu{
    
    public int menuLength;
    
    JMenuItem[] menuItems;
    
    public LeftClickPopUp(int x, int y, WorldManager worldManager)
    {
        this.menuLength = 3;
        
        menuItems = new JMenuItem[menuLength];
        menuItems[0] = new JMenuItem("Save");
        menuItems[1] = new JMenuItem("Load");
        menuItems[2] = new JMenuItem("Next Turn");
        
        for(int i=0;i<menuLength;i++){
            add(menuItems[i]);
                menuItems[i].addActionListener(new GameActions(worldManager,menuItems[i].getText()));
        }
    }
}
