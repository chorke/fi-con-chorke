
package org.chorke.ficon.backend.services.factory;

import javax.sql.DataSource;
import org.chorke.ficon.api.services.AccountService;
import org.chorke.ficon.api.services.TransactionRecordService;
import org.chorke.ficon.api.services.UserService;
import org.chorke.ficon.api.services.factory.ServiceFactory;
import org.chorke.ficon.backend.services.AccountServiceImpl;
import org.chorke.ficon.backend.services.TransactionRecordServiceImpl;
import org.chorke.ficon.backend.services.UserServiceImpl;
import org.chorke.ficon.backend.sql.metadata.DBMetaData.DataSourceProps;
import org.postgresql.ds.PGPoolingDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Chorke
 */
public class ServiceFactoryImpl implements ServiceFactory{

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceFactoryImpl.class);
    
    private DataSource defaultDataSource;
    
    private ServiceFactoryImpl(){}//private constructor
    
    private static ServiceFactoryImpl instance;
    
    private UserService userServiceInstance;
    private AccountService acctounServiceInstance;
    private TransactionRecordService transactionRecordServiceInstance;
    
    public synchronized static ServiceFactory getInstance(){
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
            LOGGER.info("A new instance of DataSource created {}.", instance.defaultDataSource);
            LOGGER.info("A new instance of ServiceFactory created {}.", instance);
        }
        return instance;
    } 
    
    @Override
    public synchronized UserService getUserService() {
        if(userServiceInstance == null){
            userServiceInstance = new UserServiceImpl(defaultDataSource);
            LOGGER.info("A new instance of UserService created {}.", userServiceInstance);
        }
        return userServiceInstance;
    }

    @Override
    public synchronized AccountService getAccountService() {
        if(acctounServiceInstance == null){
            acctounServiceInstance = new AccountServiceImpl(defaultDataSource);
            LOGGER.info("A new instance of AccountService created {}.", acctounServiceInstance);
        }
        return acctounServiceInstance;
    }

    @Override
    public synchronized TransactionRecordService getTransactionRecordService() {
        if(transactionRecordServiceInstance == null){
            transactionRecordServiceInstance = new TransactionRecordServiceImpl(defaultDataSource);
            LOGGER.info("A new instance of TransactionRecordService created {}.", transactionRecordServiceInstance);
        }
        return transactionRecordServiceInstance;
    }
}
