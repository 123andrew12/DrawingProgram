/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingprogram;

import java.awt.Color;

/**
 *
 * @author Andrew
 */
public class DrawingProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircleObject c = new CircleObject(50,50,50,Color.RED);
        WindowObject w = new WindowObject(500,500,c);
    }
    
}
