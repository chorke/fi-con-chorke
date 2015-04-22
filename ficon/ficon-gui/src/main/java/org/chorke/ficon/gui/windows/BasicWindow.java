
package org.chorke.ficon.gui.windows;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import org.chorke.ficon.gui.utils.Utils;

/**
 *
 * @author Chorke
 */
public abstract class BasicWindow extends JFrame{
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    BasicWindow(final boolean exitOnClose){
        super();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                if(exitOnClose){
                    Utils.exitApplication(e.getWindow());
                }
            }
        });
        init();
        pack();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void dispose(){
        if(disposingWindow()){
            super.dispose();
        }
    }
    
    abstract boolean disposingWindow();
    
    abstract void init();
}
