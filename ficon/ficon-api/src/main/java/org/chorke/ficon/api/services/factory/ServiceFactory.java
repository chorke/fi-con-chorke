
package org.chorke.ficon.api.services.factory;

import org.chorke.ficon.api.services.AccountService;
import org.chorke.ficon.api.services.TransactionRecordService;
import org.chorke.ficon.api.services.UserService;

/**
 *
 * @author Chorke
 */
public interface ServiceFactory {

    UserService getUserService();
    
    AccountService getAccountService();
    
    TransactionRecordService getTransactionRecordService();
}
