/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projekt;


/**
 *
 * @author Mateusz
 */
public class ElectronHead implements State {


    @Override
    public State nextState(int x, int y, TableBoard board) {
        return new ElectronTail();
    }

}
