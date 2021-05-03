/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;
import programowanie.obiektowe.proj.Human;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JComponent;
import java.awt.FlowLayout;
import programowanie.obiektowe.proj.WorldManager;
import java.awt.event.KeyEvent;
/**
 *
 * @author kubaz
 */
public class Frame extends JFrame{
    
    private WorldManager worldManager;
    
    public WorldManager getWorldManager(){
        return worldManager;
    }
    
    private Human human;
    
    public Human getHuman(){
        return human;
    }
    
    private final SimulatorArea poleGry;
    
    
    public Frame(int x, int y, WorldManager worldManager){
        super("Wirtualny Świat, Jakub Zwolski 175967");
        KeyListenerFrame list = new KeyListenerFrame();
        addKeyListener(list);
        this.worldManager=worldManager;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000, 1000);
        setLayout(new FlowLayout());
        poleGry = new SimulatorArea(x, y, worldManager);
        add(poleGry);     
        poleGry.setBackground(Color.black);
        poleGry.setLocation(0, 100);
        poleGry.setPreferredSize(new Dimension(1000,970));
	setVisible(true);
        setFocusable(true);
    }
    
    public void setFieldText(String text, int x, int y){
        poleGry.setFieldText(text, x, y);
    }
    
    public void clearSimArea(){
        poleGry.clearArea();
    }
}
