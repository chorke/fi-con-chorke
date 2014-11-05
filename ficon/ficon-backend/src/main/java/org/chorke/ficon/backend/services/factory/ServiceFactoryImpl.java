
package org.chorke.ficon.backend.services.factory;

import javax.sql.DataSource;
import org.chorke.ficon.api.services.AccountService;
import org.chorke.ficon.api.services.TransactionRecordService;
import org.chorke.ficon.api.services.UserService;
import org.chorke.ficon.api.services.factory.ServiceFactory;
import org.chorke.ficon.backend.sql.metadata.DBMetaData.DataSourceProps;
import org.chorke.ficon.backend.services.AccountServiceImpl;
import org.chorke.ficon.backend.services.TransactionRecordServiceImpl;
import org.chorke.ficon.backend.services.UserServiceImpl;
import org.postgresql.ds.PGPoolingDataSource;

/**
 *
 * @author Chorke
 */
public class ServiceFactoryImpl implements ServiceFactory{

    private DataSource defaultDataSource;
    
    private ServiceFactoryImpl(){}//private constructor
    
    private static ServiceFactoryImpl instance;
    
    public static ServiceFactory getInstance(){
        if(instance == null){
            instance = new ServiceFactoryImpl();
            PGPoolingDataSource psgDs = new PGPoolingDataSource();
            psgDs.setDataSourceName(DataSourceProps.DATA_SOURCE_NAME);
            psgDs.setServerName(DataSourceProps.HOST);
            psgDs.setPortNumber(DataSourceProps.PORT);
            psgDs.setUser(DataSourceProps.USER);
            psgDs.setPassword(DataSourceProps.PASSWORD);
            psgDs.setDatabaseName(DataSourceProps.DATABASE_NAME);
            psgDs.setMaxConnections(DataSourceProps.MAX_CONNECTIONS);
            instance.defaultDataSource = psgDs;
        }
        return instance;
    } 
    
    @Override
    public UserService getUserService() {
        return new UserServiceImpl(defaultDataSource);
    }

    @Override
    public AccountService getAccountService() {
        return new AccountServiceImpl(defaultDataSource);
    }

    @Override
    public TransactionRecordService getTransactionRecordService() {
        return new TransactionRecordServiceImpl(defaultDataSource);
    }
}
