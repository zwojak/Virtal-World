/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programowanie.obiektowe.proj;
import java.awt.EventQueue;

/**
 *
 * @author kubaz
 */
public class ProgramowanieObiektoweProj {

    public static void main(String[] args){
               EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
                           new WorldManager(20,20);
			}
        });
    }
    
}
