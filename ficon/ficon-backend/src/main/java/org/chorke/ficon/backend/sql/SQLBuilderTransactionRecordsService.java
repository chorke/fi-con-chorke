package org.chorke.ficon.backend.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.chorke.ficon.backend.sql.metadata.TransactionRecordsMetaData;

/**
 *
 * @author Chorke
 */
public class SQLBuilderTransactionRecordsService extends SQLBuilderBasic {
//TODO implement and add methods

    static interface TransactionRecordsStatements {

        static final String INSTERT_SQL = "INSERT INTO " + TransactionRecordsMetaData.TABLE_NAME
                + " (" + RECORDS_META_DATA.getColumnNameAtPositionInInsert(1, true) + ","
                + RECORDS_META_DATA.getColumnNameAtPositionInInsert(2, true) + ","
                + RECORDS_META_DATA.getColumnNameAtPositionInInsert(3, true) + ","
                + RECORDS_META_DATA.getColumnNameAtPositionInInsert(4, true) + ","
                + RECORDS_META_DATA.getColumnNameAtPositionInInsert(5, true) + ","
                + RECORDS_META_DATA.getColumnNameAtPositionInInsert(6, true)
                + ") VALUES (?,?,?,?,?,?)";
        static final String DELETE_SQL = "DELETE FROM " + TransactionRecordsMetaData.TABLE_NAME
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ID + "=?";
        static final String SELECT_SQL = "SELECT * FROM " + TransactionRecordsMetaData.TABLE_NAME
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ID + "=?";
        static final String UPDATE_RECORDS_BEFORE_DELETE = 
                "UPDATE " + TransactionRecordsMetaData.TABLE_NAME
                + " SET " + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID + "=NULL"
                + " WHERE " + TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID + "=?";
    }
    
    public static interface StatementTypeTransactionRecrod extends StatementType{
        static final int TYPE_UPDATE_RECORDS_BEFORE_DELETE = 30; //TODO
    }
    
    private static final TransactionRecordsMetaData RECORDS_META_DATA = TransactionRecordsMetaData.INSTANCE;
    private Long id;
    private boolean isIdSet;
    private Long accountID;
    private boolean isAccountIDSet;
    private String name;
    private boolean isNameSet;
    private String description;
    private boolean isDescriptionSet;
    private Long associatedTransactionID;
    private boolean isAssoctiatedTransactionIDSet;
    private BigDecimal amount;
    private boolean isAmountSet;
    private Calendar transactionTime;
    private boolean isTransactionTimeSet;

    public SQLBuilderTransactionRecordsService(Connection con, int statementType) throws SQLException {
        super(con, statementType);
    }

    @Override
    public PreparedStatement build() throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
                return buildDelete();
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
                return buildSelect();
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
                return buildUpdate();
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
                return buildInsert();
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
                return buildUpdateRecordsBeforeDelete();
            default:
                throw new SQLException("Unsupported statement type: "
                        + statementType);
        }
    }

    private PreparedStatement buildDelete() throws SQLException {
        needId();
        statement = connection.prepareStatement(TransactionRecordsStatements.DELETE_SQL);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildUpdateRecordsBeforeDelete() throws SQLException {
        needId();
        statement = connection.prepareStatement(TransactionRecordsStatements.UPDATE_RECORDS_BEFORE_DELETE);
        setLong(statement, 1, id);
        return statement;
    }
    
    private PreparedStatement buildSelect() throws SQLException {
        needId();
        statement = connection.prepareStatement(TransactionRecordsStatements.SELECT_SQL);
        setLong(statement, 1, id);
        return statement;
    }

    private PreparedStatement buildUpdate() throws SQLException {
        needId();
        StringBuilder sql = new StringBuilder("UPDATE ")
                .append(TransactionRecordsMetaData.TABLE_NAME).append(" SET ");
        Map<String, Integer> positionMapping = buildUpdateString(sql, true);
        if (positionMapping.isEmpty()) {
            throw new IllegalStateException("At least one value should be set for UPDATE statement.");
        }
        sql.append(" WHERE ").append(TransactionRecordsMetaData.COLUMN_ID).append("=?");
        positionMapping.put(TransactionRecordsMetaData.COLUMN_ID, positionMapping.size() + 1);
        statement = connection.prepareStatement(sql.toString());
        if (positionMapping.containsKey(TransactionRecordsMetaData.COLUMN_ID)) {
            setLong(statement,
                    positionMapping.get(TransactionRecordsMetaData.COLUMN_ID).intValue(),
                    id);
        }
        if (positionMapping.containsKey(TransactionRecordsMetaData.COLUMN_AMOUNT)) {
            setBigDecimal(statement,
                    positionMapping.get(TransactionRecordsMetaData.COLUMN_AMOUNT).intValue(),
                    amount);
        }
        if (positionMapping.containsKey(TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID)) {
            setLong(statement,
                    positionMapping.get(TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID).intValue(),
                    associatedTransactionID);
        }
        if (positionMapping.containsKey(TransactionRecordsMetaData.COLUMN_DESCRIPTION)) {
            setString(statement,
                    positionMapping.get(TransactionRecordsMetaData.COLUMN_DESCRIPTION).intValue(),
                    description);
        }
        if (positionMapping.containsKey(TransactionRecordsMetaData.COLUMN_NAME)) {
            setString(statement,
                    positionMapping.get(TransactionRecordsMetaData.COLUMN_NAME).intValue(),
                    name);
        }
        if (positionMapping.containsKey(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME)) {
            setTimestamp(statement,
                    positionMapping.get(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME).intValue(),
                    transactionTime);
        }
        return statement;
    }

    private Map<String, Integer> buildUpdateString(StringBuilder sql, boolean hasComma) {
        Map<String, Integer> positionMapping = new HashMap<>();
        int pos = 1;
        if (isNameSet) {
            if (!hasComma) {
                sql.append(", ");
            }
            sql.append(TransactionRecordsMetaData.COLUMN_NAME).append("=?");
            positionMapping.put(TransactionRecordsMetaData.COLUMN_NAME, pos);
            pos++;
            hasComma = false;
        }
        if (isDescriptionSet) {
            if (!hasComma) {
                sql.append(", ");
            }
            sql.append(TransactionRecordsMetaData.COLUMN_DESCRIPTION).append("=?");
            positionMapping.put(TransactionRecordsMetaData.COLUMN_DESCRIPTION, pos);
            pos++;
            hasComma = false;
        }
        if (isAssoctiatedTransactionIDSet) {
            if (!hasComma) {
                sql.append(", ");
            }
            sql.append(TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID).append("=?");
            positionMapping.put(TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID, pos);
            pos++;
            hasComma = false;
        }
        if (isAmountSet) {
            if (!hasComma) {
                sql.append(", ");
            }
            sql.append(TransactionRecordsMetaData.COLUMN_AMOUNT).append("=?");
            positionMapping.put(TransactionRecordsMetaData.COLUMN_AMOUNT, pos);
            pos++;
            hasComma = false;
        }
        if (isTransactionTimeSet) {
            if (!hasComma) {
                sql.append(", ");
            }
            sql.append(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME).append("=?");
            positionMapping.put(TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME, pos);
        }
        return positionMapping;
    }
    
    private PreparedStatement buildInsert() throws SQLException {
        needAccountsID();
        needName();
        needDescription();
        needAmount();
        needAssociatedTransctionID();
        needTime();
        statement = connection.prepareStatement(TransactionRecordsStatements.INSTERT_SQL,
                Statement.RETURN_GENERATED_KEYS);
        
        //accounts ID
        setLong(statement,
                RECORDS_META_DATA.getInsertColumnMapping(
                    TransactionRecordsMetaData.COLUMN_ACCOUNT_ID, true),
                accountID);
        //amount
        setBigDecimal(statement,
                RECORDS_META_DATA.getInsertColumnMapping(
                    TransactionRecordsMetaData.COLUMN_AMOUNT, true),
                amount);
        //associated transaction
        setLong(statement,
                RECORDS_META_DATA.getInsertColumnMapping(
                    TransactionRecordsMetaData.COLUMN_ASSOCIATED_TRANSACTION_ID, true),
                associatedTransactionID);
        //description
        setString(statement,
                RECORDS_META_DATA.getInsertColumnMapping(
                    TransactionRecordsMetaData.COLUMN_DESCRIPTION, true),
                description);
        //name
        setString(statement,
                RECORDS_META_DATA.getInsertColumnMapping(
                    TransactionRecordsMetaData.COLUMN_NAME, true),
                name);
        //transaction time
        setTimestamp(statement,
                RECORDS_META_DATA.getInsertColumnMapping(
                    TransactionRecordsMetaData.COLUMN_TRANSACTION_TIME, true),
                transactionTime);
        return statement;
    }

    public void setId(Long id) throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
                this.id = id;
                isIdSet = true;
                break;
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
            default:
                throw new SQLException("Method setId is not allowed for this statement type: "
                        + statementType);
        }
    }

    public void setAccountID(Long accountID) throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
                this.accountID = accountID;
                isAccountIDSet = true;
                break;
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            default:
                throw new SQLException("Method setAccountsID is not allowed for this statement type: "
                        + statementType);
        }
    }

    public void setName(String name) throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
                this.name = name;
                isNameSet = true;
                break;
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            default:
                throw new SQLException("Method setName is not allowed for this statement type: "
                        + statementType);
        }
    }

    public void setDesctiption(String description) throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
                this.description = description;
                isDescriptionSet = true;
                break;
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            default:
                throw new SQLException("Method setDescription is not allowed for this statement type: "
                        + statementType);
        }
    }

    public void setAssociatedTransactionID(Long associatedTransactionID) throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
                this.associatedTransactionID = associatedTransactionID;
                isAssoctiatedTransactionIDSet = true;
                break;
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            default:
                throw new SQLException("Method setAssociatedTransactionID is not "
                        + "allowed for this statement type: " + statementType);
        }
    }

    public void setAmount(BigDecimal amount) throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
                this.amount = amount;
                isAmountSet = true;
                break;
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            default:
                throw new SQLException("Method setAmount is not allowed for this statement type: "
                        + statementType);
        }
    }

    public void setTransactionTime(Calendar transactionTime) throws SQLException {
        switch (statementType) {
            case (StatementTypeTransactionRecrod.TYPE_INSERT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE):
                this.transactionTime = transactionTime;
                isTransactionTimeSet = true;
                break;
            case (StatementTypeTransactionRecrod.TYPE_DELETE):
            case (StatementTypeTransactionRecrod.TYPE_SELECT):
            case (StatementTypeTransactionRecrod.TYPE_UPDATE_RECORDS_BEFORE_DELETE):
            default:
                throw new SQLException("Method setTransactionTime is not allowed for this statement type: "
                        + statementType);
        }
    }

    @Override
    public void reset() {
        resetId();
        resetAccountID();
        resetName();
        resetDescription();
        resetAssociatedTransactionID();
        resetAmount();
        resetTransactionTime();
    }

    private void resetId() {
        id = null;
        isIdSet = false;
    }

    private void resetAccountID() {
        accountID = null;
        isAccountIDSet = false;
    }

    private void resetName() {
        name = null;
        isNameSet = false;
    }

    private void resetDescription() {
        description = null;
        isDescriptionSet = false;
    }

    private void resetAssociatedTransactionID() {
        associatedTransactionID = null;
        isAssoctiatedTransactionIDSet = false;
    }

    private void resetAmount() {
        amount = null;
        isAmountSet = false;
    }

    private void resetTransactionTime() {
        transactionTime = null;
        isTransactionTimeSet = false;
    }
    
    private void needId() throws SQLException {
        if (!isIdSet) {
            throw new SQLException("Id of record has not been set.");
        }
    }
    
    private void needAccountsID() throws SQLException {
        if (!isAccountIDSet) {
            throw new SQLException("ID of account for record has not been set.");
        }
    }
    
    private void needAmount() throws SQLException {
        if (!isAmountSet) {
            throw new SQLException("Amount has not been set.");
        }
    }
    
    private void needAssociatedTransctionID() throws SQLException {
        if (!isAssoctiatedTransactionIDSet) {
            throw new SQLException("ID of associated transaction for record has not been set.");
        }
    }
    
    private void needDescription() throws SQLException {
        if (!isDescriptionSet) {
            throw new SQLException("Description of record has not been set.");
        }
    }
    
    private void needName() throws SQLException {
        if (!isNameSet) {
            throw new SQLException("Name of record has not been set.");
        }
    }
    
    private void needTime() throws SQLException {
        if (!isTransactionTimeSet) {
            throw new SQLException("Time of record has not been set.");
        }
    }
}
