/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zad5_isp;

import java.awt.Component;
import javax.swing.MenuElement;

/**
 *
 * @author ja
 */
public interface IInherentMenuElement {
    public void menuSelectionChanged(boolean bln);
    public MenuElement[] getSubElements();
    public Component getComponent();
}
