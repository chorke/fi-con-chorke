
package org.chorke.ficon.backend.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.chorke.ficon.api.services.AccountService.LoadProperties;
import org.chorke.ficon.backend.sql.metadata.AccountsMetaData;
import org.chorke.ficon.backend.sql.metadata.TransactionRecordsMetaData;

/**
 *
 * @author Chorke
 */
public class SQLBuilderAccountsService extends SQLBuilderBasic{
//TODO implement and add methods
    
    private static final AccountsMetaData ACCOUNTS_META_DATA = AccountsMetaData.INSTANCE;
    
    static interface AccountsStatements {

        static final String INSTERT_SQL = "INSERT INTO " + AccountsMetaData.TABLE_NAME
                + " (" + ACCOUNTS_META_DATA.getColumnNameAtPositionInInsert(1, true) + ","
                + ACCOUNTS_META_DATA.getColumnNameAtPositionInInsert(2, true) + ","
                + ACCOUNTS_META_DATA.getColumnNameAtPositionInInsert(3, true)
                + ") VALUES (?,?,?)";
        static final String DELETE_SQL = "DELETE FROM " + AccountsMetaData.TABLE_NAME
                + " WHERE " + AccountsMetaData.COLUMN_ID + "=?";
        static final String SELECT_SQL = "SELECT * FROM " + AccountsMetaData.TABLE_NAME
                + " WHERE " + AccountsMetaData.COLUMN_ID + "=?";
        static final String SELECT_NAMES_SQL = "SELECT " 
                    + AccountsMetaData.COLUMN_ID + ","
                    + AccountsMetaData.COLUMN_NAME
                + " FROM " + AccountsMetaData.TABLE_NAME
                + " WHERE " + AccountsMetaData.COLUMN_USER_ID + "=?";
        static final String UPDATE_RECORDS_BEFORE_DELETE = 
                "UPDATE " + TransactionRecordsMetaData.TABLE_NAME
                + " SET " + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID + "=NULL"
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID + " IN "
                    + "(SELECT " + TransactionRecordsMetaData.COLUMN_ID
                    + " FROM " + TransactionRecordsMetaData.TABLE_NAME
                    + " WHERE " + TransactionRecordsMetaData.COLUMN_ACCOUNT_ID + "=?"
                    + ")";
        static final String DELETE_RECORDS_SUB_QUERY = 
                "DELETE FROM " + TransactionRecordsMetaData.TABLE_NAME
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ACCOUNT_ID + "=?";
    }
    
    public static interface StatementTypeAccounts extends StatementType{
        static final int TYPE_LOAD_HISTORY = 20;
        static final int TYPE_SELECT_NAMES = 21;
        static final int TYPE_UPDATE_RECORDS_BEFORE_DELETE = 22;
        static final int TYPE_DELETE_RECORDS_SUB_QUERY = 23;
        
        // no constant for transfer money - we will need more then one query
        // and all will manipulate with TransactionRecordTable
        
        // no constant for select full - we can use select and load history
    }
    
    private Long id;
    private boolean isIdSet;
    private Long usersID;
    private boolean isUserIDSet;
    private String name;
    private boolean isNameSet;
    private String description;
    private boolean isDescriptionSet;
    private Properties loadProperties;
    private boolean isLoadPropertiesSet;
    private String escapedName;
    
    public SQLBuilderAccountsService(Connection con, int statementType) throws SQLException{
        super(con, statementType);
    }
    
    public void setId(Long id) throws SQLException{
        switch(statementType){
            case (StatementTypeAccounts.TYPE_DELETE):
            case (StatementTypeAccounts.TYPE_SELECT):
            case (StatementTypeAccounts.TYPE_LOAD_HISTORY):
            case (StatementTypeAccounts.TYPE_UPDATE):
            case (StatementTypeAccounts.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            case (StatementTypeAccounts.TYPE_DELETE_RECORDS_SUB_QUERY):
                this.id = id;
                isIdSet = true;
                break;
            case (StatementTypeAccounts.TYPE_SELECT_NAMES):
            case (StatementTypeAccounts.TYPE_INSERT):
            default :
                throw new SQLException("Method setId is not allowed for this statement type: "
                        + statementType);
        }
    }
    
    public void setUserID(long userID) throws SQLException{
        switch(statementType){
            case (StatementTypeAccounts.TYPE_INSERT):
            case (StatementTypeAccounts.TYPE_SELECT_NAMES):
                this.usersID = userID;
                isUserIDSet = true;
                break;
            case (StatementTypeAccounts.TYPE_SELECT):
            case (StatementTypeAccounts.TYPE_DELETE):
            case (StatementTypeAccounts.TYPE_LOAD_HISTORY):
            case (StatementTypeAccounts.TYPE_UPDATE):
            case (StatementTypeAccounts.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            case (StatementTypeAccounts.TYPE_DELETE_RECORDS_SUB_QUERY):
            default :
                throw new SQLException("Method setUserID is not allowed for this statement type: "
                        + statementType);
        }
    }
    
    public void setName(String name) throws SQLException{
        switch(statementType){
            case (StatementTypeAccounts.TYPE_INSERT):
            case (StatementTypeAccounts.TYPE_UPDATE):
                this.name = name;
                isNameSet = true;
                break;
            case (StatementTypeAccounts.TYPE_DELETE):
            case (StatementTypeAccounts.TYPE_LOAD_HISTORY):
            case (StatementTypeAccounts.TYPE_SELECT):
            case (StatementTypeAccounts.TYPE_SELECT_NAMES):
            case (StatementTypeAccounts.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            case (StatementTypeAccounts.TYPE_DELETE_RECORDS_SUB_QUERY):
            default :
                throw new SQLException("Method setName is not allowed for this statement type: "
                        + statementType);
        }
    }
    
    public void setDescription(String description) throws SQLException{
        switch(statementType){
            case (StatementTypeAccounts.TYPE_INSERT):
            case (StatementTypeAccounts.TYPE_UPDATE):
                this.description = description;
                isDescriptionSet = true;
                break;
            case (StatementTypeAccounts.TYPE_DELETE):
            case (StatementTypeAccounts.TYPE_LOAD_HISTORY):
            case (StatementTypeAccounts.TYPE_SELECT):
            case (StatementTypeAccounts.TYPE_SELECT_NAMES):
            case (StatementTypeAccounts.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            case (StatementTypeAccounts.TYPE_DELETE_RECORDS_SUB_QUERY):
            default :
                throw new SQLException("Method setDescription is not allowed for this statement type: "
                        + statementType);
        }
    }

    public void setLoadProperties(Properties loadProperties) throws SQLException{
        switch(statementType){
            case (StatementTypeAccounts.TYPE_LOAD_HISTORY):
                this.loadProperties = loadProperties;
                isLoadPropertiesSet = true;
                break;
            case (StatementTypeAccounts.TYPE_INSERT):
            case (StatementTypeAccounts.TYPE_UPDATE):
            case (StatementTypeAccounts.TYPE_DELETE):
            case (StatementTypeAccounts.TYPE_SELECT):
            case (StatementTypeAccounts.TYPE_SELECT_NAMES):
            case (StatementTypeAccounts.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            case (StatementTypeAccounts.TYPE_DELETE_RECORDS_SUB_QUERY):
            default :
                throw new SQLException("Method setLoadProperties is not "
                        + "allowed for this statement type: " + statementType);
        }
    }

    @Override
    public PreparedStatement build() throws SQLException {
        switch(statementType){
            case (StatementTypeAccounts.TYPE_DELETE):
                return buildDelete();
            case (StatementTypeAccounts.TYPE_INSERT):
                return buildInsert();
            case (StatementTypeAccounts.TYPE_LOAD_HISTORY):
                return buildLoadHistory();
            case (StatementTypeAccounts.TYPE_SELECT):
                return buildSelect();
            case (StatementTypeAccounts.TYPE_SELECT_NAMES):
                return buildSelectNames();
            case (StatementTypeAccounts.TYPE_UPDATE):
                return buildUpdate();
            case (StatementTypeAccounts.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
                return buildUpdateRecordsBeforeDelete();
            case (StatementTypeAccounts.TYPE_DELETE_RECORDS_SUB_QUERY):
                return buildDeleteRecordsSubquery();
            default :
                throw new SQLException("Unsupported statement type: " + statementType);
        }
    }
    
    private PreparedStatement buildDelete() throws SQLException{
        needId();
        statement = connection.prepareStatement(AccountsStatements.DELETE_SQL);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildDeleteRecordsSubquery() throws SQLException{
        needId();
        statement = connection.prepareStatement(AccountsStatements.DELETE_RECORDS_SUB_QUERY);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildUpdateRecordsBeforeDelete() throws SQLException{
        needId();
        statement = connection.prepareStatement(AccountsStatements.UPDATE_RECORDS_BEFORE_DELETE);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildInsert() throws SQLException{
        needUsersID();
        needName();
        needDescription();
        
        statement = connection.prepareStatement(AccountsStatements.INSTERT_SQL,
                Statement.RETURN_GENERATED_KEYS);
        setLong(statement,
                ACCOUNTS_META_DATA.getInsertColumnMapping(AccountsMetaData.COLUMN_USER_ID, true),
                usersID);
        setString(statement,
                ACCOUNTS_META_DATA.getInsertColumnMapping(AccountsMetaData.COLUMN_NAME, true),
                name);
        setString(statement,
                ACCOUNTS_META_DATA.getInsertColumnMapping(AccountsMetaData.COLUMN_DESCRIPTION, true),
                description);
        return statement;
    }
    
    private PreparedStatement buildLoadHistory() throws SQLException{
        needId();
        StringBuilder sql = new StringBuilder("SELECT * FROM ")
                .append(TransactionRecordsMetaData.TABLE_NAME)
                .append(" WHERE ")
                .append(TransactionRecordsMetaData.COLUMN_ACCOUNT_ID)
                .append("=?");
        if(!isLoadPropertiesSet || loadProperties == null){
            statement = connection.prepareStatement(sql.toString());
            setLong(statement, 1, id);
            return statement;
        }
        boolean hasAnd = false;
        Map<String, Integer> mapping = new HashMap<>();
        mapping.put(TransactionRecordsMetaData.COLUMN_ACCOUNT_ID, 1);
        buildWhereForLoad(mapping, sql, hasAnd);
        System.out.println(sql);
        statement = connection.prepareStatement(sql.toString());
        setLong(statement, 1, id);
        if(mapping.containsKey(LoadProperties.FROM_DATE)){
            setTimestamp(statement,
                    mapping.get(LoadProperties.FROM_DATE),
                    (Calendar)loadProperties.get(LoadProperties.FROM_DATE));
        }
        if(mapping.containsKey(LoadProperties.TO_DATE)){
            setTimestamp(statement,
                    mapping.get(LoadProperties.TO_DATE),
                    (Calendar)loadProperties.get(LoadProperties.TO_DATE));
        }
        if(mapping.containsKey(LoadProperties.MIN_AMOUNT)){
            setBigDecimal(statement,
                    mapping.get(LoadProperties.MIN_AMOUNT),
                    (BigDecimal)loadProperties.get(LoadProperties.MIN_AMOUNT));
        }
        if(mapping.containsKey(LoadProperties.MAX_AMOUNT)){
            setBigDecimal(statement,
                    mapping.get(LoadProperties.MAX_AMOUNT),
                    (BigDecimal)loadProperties.get(LoadProperties.MAX_AMOUNT));
        }
        if(mapping.containsKey(LoadProperties.NAME_LIKE)){
            setString(statement, mapping.get(LoadProperties.NAME_LIKE),
                    escape((String)loadProperties.get(LoadProperties.NAME_LIKE)));
        }
        return statement;
    }
    
    private String escape(String str){
        if(str == null){
            return null;
        }
        return str.replace("*", "%").replace("?", "_");
    }
    
    private void buildWhereForLoad(Map<String, Integer> mapping, StringBuilder sql, boolean hasAnd)
        throws SQLException{
        int pos = mapping.size() + 1;
        if(loadProperties.containsKey(LoadProperties.FROM_DATE)){
            if(!hasAnd){ sql.append(" AND "); }
            sql.append(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME)
                    .append(">=?");
            mapping.put(LoadProperties.FROM_DATE, pos);
            pos++;
            hasAnd = false;
        }
        if(loadProperties.containsKey(LoadProperties.TO_DATE)){
            if(!hasAnd){ sql.append(" AND "); }
            sql.append(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME)
                    .append("<=?");
            mapping.put(LoadProperties.TO_DATE, pos);
            pos++;
            hasAnd = false;
        }
        if(loadProperties.containsKey(LoadProperties.MAX_AMOUNT)){
            if(!hasAnd){ sql.append(" AND "); }
            sql.append(TransactionRecordsMetaData.COLUMN_AMOUNT)
                    .append("<=?");
            mapping.put(LoadProperties.MAX_AMOUNT, pos);
            pos++;
            hasAnd = false;
        }
        if(loadProperties.containsKey(LoadProperties.MIN_AMOUNT)){
            if(!hasAnd){ sql.append(" AND "); }
            sql.append(TransactionRecordsMetaData.COLUMN_AMOUNT)
                    .append(">=?");
            mapping.put(LoadProperties.MIN_AMOUNT, pos);
            pos++;
            hasAnd = false;
        }
        if(loadProperties.containsKey(LoadProperties.NAME_LIKE)){
            if(!hasAnd){ sql.append(" AND "); }
            sql.append(TransactionRecordsMetaData.COLUMN_NAME)
                    .append(" LIKE ?");
            mapping.put(LoadProperties.NAME_LIKE, pos);
            pos++;
        }
    }
    
    private PreparedStatement buildSelect() throws SQLException{
        needId();
        statement = connection.prepareStatement(AccountsStatements.SELECT_SQL);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildSelectNames() throws SQLException{
        needUsersID();
        statement = connection.prepareStatement(AccountsStatements.SELECT_NAMES_SQL);
        setLong(statement, 1, usersID);
        return statement;
    }
    
    private PreparedStatement buildUpdate() throws SQLException{
        needId();
        if(!isNameSet && !isDescriptionSet){
            throw new IllegalStateException("At least one value need to be set for UPDATE statement.");
        }
        StringBuilder sql = new StringBuilder("UPDATE ")
                .append(AccountsMetaData.TABLE_NAME)
                .append(" SET ");
        boolean hasColon = true;
        Map<String, Integer> mapping = new HashMap<>();
        int i = 1;
        if(isNameSet){
            sql.append(AccountsMetaData.COLUMN_NAME)
                    .append("=?");
            hasColon = false;
            mapping.put(AccountsMetaData.COLUMN_NAME, i);
            i++;
        }
        if(isDescriptionSet){
            if(!hasColon){
                sql.append(",");
            }
            sql.append(AccountsMetaData.COLUMN_DESCRIPTION).
                    append("=?");
            mapping.put(AccountsMetaData.COLUMN_DESCRIPTION, i);
            i++;
        }
        sql.append(" WHERE ")
                .append(AccountsMetaData.COLUMN_ID)
                .append("=?");
        mapping.put(AccountsMetaData.COLUMN_ID, i);
        statement = connection.prepareStatement(sql.toString());
        
        setLong(statement, mapping.get(AccountsMetaData.COLUMN_ID), id);
        if(mapping.containsKey(AccountsMetaData.COLUMN_NAME)){
            setString(statement, mapping.get(AccountsMetaData.COLUMN_NAME), name);
        }
        if(mapping.containsKey(AccountsMetaData.COLUMN_DESCRIPTION)){
            setString(statement, mapping.get(AccountsMetaData.COLUMN_DESCRIPTION), description);
        }
        return statement;
    }
    
    private void needId() throws SQLException {
        if (!isIdSet) {
            throw new SQLException("Id of account has not been set.");
        }
    }
    
    private void needName() throws SQLException {
        if (!isNameSet) {
            throw new SQLException("Name of account has not been set.");
        }
    }
    private void needDescription() throws SQLException {
        if (!isDescriptionSet) {
            throw new SQLException("Description of account has not been set.");
        }
    }
    
    private void needUsersID() throws SQLException {
        if (!isUserIDSet) {
            throw new SQLException("User's ID for account has not been set.");
        }
    }
    
    @Override
    public void reset() {
        resetId();
        resetUserID();
        resetName();
        resetDescription();
    }
    
    private void resetId(){
        id = null;
        isIdSet = false;
    }
    
    private void resetUserID(){
        usersID = null;
        isUserIDSet = false;
    }
    
    private void resetName(){
        name = null;
        isNameSet = false;
    }
    
    private void resetDescription(){
        description = null;
        isDescriptionSet = false;
    }
}
