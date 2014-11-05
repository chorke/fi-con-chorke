package org.chorke.ficon.backend.sql.metadata;

/**
 *
 * @author Chorke
 */
public class TransactionRecordsMetaData implements TableMetaData {

    public static final TransactionRecordsMetaData INSTANCE = new TransactionRecordsMetaData();
    public static final String TABLE_NAME = "TransactionRecords";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ACCOUNT_ID = "AccountID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_ASSOCIATED_TRANSACTION_ID = "AssociatedTransactionID";
    public static final String COLUMN_AMOUNT = "Amount";
    public static final String COLUMN_TRANSACTION_TIME = "TransactionTime";

    private TransactionRecordsMetaData() {}

    @Override
    public String getColumnNameAtPositionInInsert(int pos, boolean insertWithoutID){
        if(pos <= 0){
            throw new IllegalArgumentException("Column position should be greater then 0");
        }
        int actualPos = pos;
        if(insertWithoutID){
            actualPos++;
        }
        switch(actualPos){
            case (1):
                return COLUMN_ID;
            case (2):
                return COLUMN_ACCOUNT_ID;
            case (3):
                return COLUMN_NAME;
            case (4):
                return COLUMN_DESCRIPTION;
            case (5):
                return COLUMN_ASSOCIATED_TRANSACTION_ID;
            case (6):
                return COLUMN_AMOUNT;
            case (7):
                return COLUMN_TRANSACTION_TIME;
            default :
                throw new IllegalArgumentException("No columns at position " + pos);
        }
    }

    @Override
    public int getBasicColumnMapping(String columnName){
        switch(columnName){
            case(COLUMN_ID):
                return 1;
            case(COLUMN_ACCOUNT_ID):
                return 2;
            case(COLUMN_NAME):
                return 3;
            case(COLUMN_DESCRIPTION):
                return 4;
            case(COLUMN_ASSOCIATED_TRANSACTION_ID):
                return 5;
            case(COLUMN_AMOUNT):
                return 6;
            case(COLUMN_TRANSACTION_TIME):
                return 7;
            default :
                throw new IllegalArgumentException("No column with name: " + columnName);
        }
    }

    @Override
    public int getInsertColumnMapping(String columnName, boolean insertWithoutID){
        if(insertWithoutID){
            return getBasicColumnMapping(columnName) - 1;
        } else {
            return getBasicColumnMapping(columnName);
        }
    }
}
