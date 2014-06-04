/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projekt;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mateusz
 */
public class ElectronTail implements State {

    @Override
    public State nextState(int x, int y, TableBoard board) 
    {
            return Conductor;
    }



    
}
