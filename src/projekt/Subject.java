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
public interface Subject {
    public void registerAction (Observer o);
    public void unregisterAction (Observer o);
    public void notifyObservers();
    
}
