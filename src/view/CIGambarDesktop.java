/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.swing.JDesktopPane;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class CIGambarDesktop extends JDesktopPane {

       protected void paintComponent(Graphics graph)
 {
  Graphics2D g2D = (Graphics2D) graph.create();
  
  Image img = new ImageIcon(getClass().getResource("pegadaian.png")).getImage();
  
  g2D.drawImage(img, 0, 0, getWidth(), getHeight(), null);
  g2D.dispose();
 }
    
}
