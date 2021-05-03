/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;
import programowanie.obiektowe.proj.WorldManager;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
/**
 *
 * @author kubaz
 */
public class WorldFieldJPanel extends JPanel{

    private JLabel text;
    
    public WorldFieldJPanel(int x, int y, WorldManager worldManager){
        MouseMenu mouseMenu1 = new MouseMenu(x,y,worldManager);
        addMouseListener(mouseMenu1);
        setBackground(Color.gray);
        text=new JLabel();
        add(text);
    }
    
    public void clearField(){
        text.setText("");
        setBackground(Color.gray);
    }
    
    public void setText(String newText){
        text.setText(newText);
        if(newText=="Human")setBackground(Color.blue);
        if(newText=="Fox")setBackground(Color.orange);
        if(newText=="Turtle")setBackground(Color.green);
        if(newText=="Wolf")setBackground(Color.black);
        if(newText=="Antelope")setBackground(Color.red);
        if(newText=="Sheep")setBackground(Color.white);
        if(newText=="Grass")setBackground(Color.cyan);
        if(newText=="PineBorscht")setBackground(Color.red);
        if(newText=="Guarana")setBackground(Color.pink);
        if(newText=="SowThistle")setBackground(Color.yellow);
        if(newText=="WolfBerries")setBackground(Color.magenta);
        
        
    }
}
