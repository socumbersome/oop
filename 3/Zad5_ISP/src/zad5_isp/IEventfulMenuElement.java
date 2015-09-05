/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad5_isp;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;

/**
 *
 * @author ja
 */
public interface IEventfulMenuElement {
    public void processMouseEvent(MouseEvent me, MenuElement[] mes, MenuSelectionManager msm);
    public void processKeyEvent(KeyEvent ke, MenuElement[] mes, MenuSelectionManager msm);
    
}
