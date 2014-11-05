package org.chorke.ficon.backend.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.chorke.ficon.backend.sql.metadata.UsersMetaData;
import org.chorke.ficon.backend.sql.metadata.AccountsMetaData;
import org.chorke.ficon.backend.sql.metadata.TransactionRecordsMetaData;

/**
 *
 * @author Chorke
 */
public class SQLBuilderUsersService extends SQLBuilderBasic{
    
    static interface UsersStatements {

        static final String INSTERT_SQL = "INSERT INTO " + UsersMetaData.TABLE_NAME
                + "(" + UsersMetaData.INSTANCE.getColumnNameAtPositionInInsert(1, true)
                + ") VALUES (?)";
        static final String DELETE_SQL = "DELETE FROM " + UsersMetaData.TABLE_NAME
                + " WHERE " + UsersMetaData.COLUMN_ID + "=?";
        static final String UPDATE_SQL = "UPDATE " + UsersMetaData.TABLE_NAME
                + " SET " + UsersMetaData.COLUMN_NAME + "=?"
                + " WHERE " + UsersMetaData.COLUMN_ID + "=?";
        static final String SELECT_SQL = "SELECT * FROM " + UsersMetaData.TABLE_NAME
                + " WHERE " + UsersMetaData.COLUMN_ID + "=?";
        static final String SELECT_USERS_NAMES_SQL = "SELECT " 
                            + UsersMetaData.COLUMN_ID + ","
                            + UsersMetaData.COLUMN_NAME
                + " FROM " + UsersMetaData.TABLE_NAME;
        static final String LOAD_USERS_ACCOUNTS_SQL = "SELECT * FROM " + AccountsMetaData.TABLE_NAME
                + " WHERE " + AccountsMetaData.COLUMN_USER_ID + "=?";
        
        static final String DELETE_ACCOUNTS_SUB_SQL = "DELETE FROM " + AccountsMetaData.TABLE_NAME
                + " WHERE " + AccountsMetaData.COLUMN_USER_ID + "=?";
        
        static final String DELETE_RECORDS_SUB_SQL = 
                "DELETE FROM " + TransactionRecordsMetaData.TABLE_NAME
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ACCOUNT_ID + " IN "
                    + "(SELECT " + AccountsMetaData.COLUMN_ID
                    + " FROM " + AccountsMetaData.TABLE_NAME
                    + " WHERE " + AccountsMetaData.COLUMN_USER_ID + "=?"
                    + ")";
        static final String UPDATE_RECORDS_BEFORE_USER_DELETE =
                "UPDATE " + TransactionRecordsMetaData.TABLE_NAME
                + " SET " + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID + "=NULL"
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID + " IN "
                    + "(SELECT " + TransactionRecordsMetaData.COLUMN_ID 
                    + " FROM " + TransactionRecordsMetaData.TABLE_NAME
                    + " WHERE " + TransactionRecordsMetaData.COLUMN_ACCOUNT_ID + " IN "
                        + "(SELECT " + AccountsMetaData.COLUMN_ID
                        + " FROM " + AccountsMetaData.TABLE_NAME
                        + " WHERE " + AccountsMetaData.COLUMN_USER_ID + "=?"
                        + ")"
                    + ")";
    }
    
    public static interface StatementTypeUsers extends StatementType{
        static final int TYPE_LOAD_ACCOUNTS =      10;
        static final int TYPE_SELECT_USERS_NAMES = 11;
        static final int TYPE_DELETE_ACCOUNT_SUBQUERY = 12;
        static final int TYPE_DELETE_RECORDS_SUBQUERY = 13;
        static final int TYPE_UPDATE_RECORDS_BEFORE_DELETE = 14;
    }
    
    private static final UsersMetaData USERS_META_DATA = UsersMetaData.INSTANCE;
    
    private String name;
    private boolean isNameSet;
    private Long id;
    private boolean isIdSet;
    
    public SQLBuilderUsersService(Connection con, int statementType) throws SQLException{
        super(con, statementType);
    }
    
    public void setId(Long id) throws SQLException{
        switch(statementType){
            case (StatementTypeUsers.TYPE_SELECT):
            case (StatementTypeUsers.TYPE_DELETE):
            case (StatementTypeUsers.TYPE_UPDATE):
            case (StatementTypeUsers.TYPE_LOAD_ACCOUNTS):
            case (StatementTypeUsers.TYPE_DELETE_ACCOUNT_SUBQUERY):
            case (StatementTypeUsers.TYPE_DELETE_RECORDS_SUBQUERY):
            case (StatementTypeUsers.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
                this.id = id;
                isIdSet = true;
                break;
            case (StatementTypeUsers.TYPE_INSERT):
            case (StatementTypeUsers.TYPE_SELECT_USERS_NAMES):
            default :
                throw new SQLException("Method setId is not allowed for this type of statement: "
                        + statementType);
        }
    }
    
    public void setName(String name) throws SQLException{
        switch(statementType){
            case (StatementTypeUsers.TYPE_INSERT):
            case (StatementTypeUsers.TYPE_UPDATE):
                this.name = name;
                isNameSet = true;
                break;
            case (StatementTypeUsers.TYPE_DELETE):
            case (StatementTypeUsers.TYPE_LOAD_ACCOUNTS):
            case (StatementTypeUsers.TYPE_SELECT):
            case (StatementTypeUsers.TYPE_SELECT_USERS_NAMES):
            case (StatementTypeUsers.TYPE_DELETE_ACCOUNT_SUBQUERY):
            case (StatementTypeUsers.TYPE_DELETE_RECORDS_SUBQUERY):
            case (StatementTypeUsers.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            default :
                throw new SQLException("Method setName is not allowed for this type of statement: "
                        + statementType);
        }
    }

    @Override
    public PreparedStatement build() throws SQLException{
        switch(statementType){
            case (StatementTypeUsers.TYPE_INSERT):
                return buildInsert();
            case (StatementTypeUsers.TYPE_UPDATE):
                return buildUpdate();
            case (StatementTypeUsers.TYPE_DELETE):
                return buildDelete();
            case (StatementTypeUsers.TYPE_LOAD_ACCOUNTS):
                return buildLoadAccounts();
            case (StatementTypeUsers.TYPE_SELECT):
                return buildSelect();
            case (StatementTypeUsers.TYPE_SELECT_USERS_NAMES):
                return buildSelectUsersNames();
            case (StatementTypeUsers.TYPE_DELETE_ACCOUNT_SUBQUERY):
                return buildDeleteAccountsSubquery();
            case (StatementTypeUsers.TYPE_DELETE_RECORDS_SUBQUERY):
                return buildDeleteRecordsSubquery();
            case (StatementTypeUsers.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
                return buildUpdateRecordsBeforeDelete();
            default :
                throw new SQLException("Unsupported statement type: " + statementType);
        }
    }

    private PreparedStatement buildInsert() throws SQLException{
        needName();
        
        statement = connection.prepareStatement(UsersStatements.INSTERT_SQL,
                Statement.RETURN_GENERATED_KEYS);
        setString(statement,
                USERS_META_DATA.getInsertColumnMapping(UsersMetaData.COLUMN_NAME, true),
                name);
        return statement;
    }
    
    private PreparedStatement buildUpdate() throws SQLException{
        needId();
        if(!isNameSet){
            throw new IllegalStateException("Name need to be set for UPDATE statement.");
        }
        statement = connection.prepareStatement(UsersStatements.UPDATE_SQL);
        setString(statement, 1, name);
        setLong(statement, 2, id);
        return statement;
    }
    
    private PreparedStatement buildDelete() throws SQLException{
        needId();
        statement = connection.prepareStatement(UsersStatements.DELETE_SQL);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildDeleteAccountsSubquery() throws SQLException{
        needId();
        statement = connection.prepareStatement(UsersStatements.DELETE_ACCOUNTS_SUB_SQL);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildDeleteRecordsSubquery() throws SQLException{
        needId();
        statement = connection.prepareStatement(UsersStatements.DELETE_RECORDS_SUB_SQL);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildUpdateRecordsBeforeDelete() throws SQLException{
        needId();
        statement = connection.prepareStatement(UsersStatements.UPDATE_RECORDS_BEFORE_USER_DELETE);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildLoadAccounts() throws SQLException{
        needId();
        statement = connection.prepareStatement(UsersStatements.LOAD_USERS_ACCOUNTS_SQL);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildSelect() throws SQLException{
        needId();
        statement = connection.prepareStatement(UsersStatements.SELECT_SQL);
        statement.setLong(1, id);
        return statement;
    }
    
    private PreparedStatement buildSelectUsersNames() throws SQLException{
        statement = connection.prepareStatement(UsersStatements.SELECT_USERS_NAMES_SQL);
        return statement;
    }
    
    @Override
    public void reset() {
        resetId();
        resetName();
    }
    
    private void resetId(){
        id = null;
        isIdSet = false;
    }
    
    private void resetName(){
        name = null;
        isNameSet = false;
    }
    
    private void needId() throws SQLException {
        if(!isIdSet){
            throw new SQLException("ID of user has not been set.");
        }
    }

    private void needName() throws SQLException {
        if(!isNameSet){
            throw new SQLException("Name of user has not been set.");
        }
    }
}
