/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Nishil Patel
 */
    public class Pong extends JPanel
    {
        int ballx=0;
        int bally=0;
        int border = 15;
        boolean ballVertical = true;
        boolean ballHorizontal = true;
            
    private void moveBall()
    {
                
        if (ballVertical == true)
        {
            bally = bally + 2;
        }
        if (ballVertical == false)
        {
            bally = bally - 2;
        }
        if (bally == getHeight()-border)
        {
            ballVertical = false; 
        }
        if (bally == 0)
        {
            ballVertical = true; 
        }
        
        if (ballHorizontal == true)
        {
            ballx = ballx + 2;
        }
        if (ballHorizontal == false)
        {
            ballx = ballx - 2;
        }
        if (ballx == getWidth()-border - 1)
        {
            ballHorizontal = false; 
        }
        if (ballx == 0)
        {
            ballHorizontal = true; 
        }
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.fillOval(ballx,bally,15,15);
                
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //Window 
        JFrame myFrame = new JFrame("Pong");
        myFrame.setSize(1040,760);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Pong game = new Pong();
        //Game
        myFrame.add(game);
        
        while (true)
        {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
        }
    }
    
}