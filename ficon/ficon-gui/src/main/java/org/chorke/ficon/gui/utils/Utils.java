
package org.chorke.ficon.gui.utils;

import org.chorke.ficon.api.services.AccountService;
import org.chorke.ficon.api.services.TransactionRecordService;
import org.chorke.ficon.api.services.UserService;
import org.chorke.ficon.api.services.factory.ServiceFactory;
import org.chorke.ficon.backend.services.factory.ServiceFactoryImpl;
import org.chorke.ficon.gui.windows.WindowUtils;

/**
 *
 * @author Chorke
 */
public class Utils {

    public static interface MaxLength{
        public static final int NAME_RECORD = 25;
        public static final int NAME_ACCOUNT = 25;
    }
    
    private static Session session;
    
    private static final ServiceFactory factory = ServiceFactoryImpl.getInstance();
    
    private Utils(){};

    public static void setSession(Session session) {
        Utils.session = session;
    }
    
    public static Session getActualSession(){
        return session;
    }
    
    static UserService getUserService(){
        return factory.getUserService();
    }
    
    static AccountService getAccountService(){
        return factory.getAccountService();
    }
    
    static TransactionRecordService getTransactionRecordService(){
        return factory.getTransactionRecordService();
    }
    
    public static void exitApplication(Object originator){
        WindowUtils.closeAllWindows();
        GuiUtils.fireExitApplicationEvent(originator);
    }
}
