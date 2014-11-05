package org.chorke.ficon.backend.sql.metadata;

/**
 *
 * @author Chorke
 */
public class AccountsMetaData implements TableMetaData {

    public static final AccountsMetaData INSTANCE = new AccountsMetaData();
    public static final String TABLE_NAME = "Accounts";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_USER_ID = "UserID";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESCRIPTION = "Description";

    private AccountsMetaData() {}

    @Override
    public int getBasicColumnMapping(String columnName){
        switch(columnName){
            case (COLUMN_ID):
                return 1;
            case (COLUMN_USER_ID):
                return 2;
            case (COLUMN_NAME):
                return 3;
            case (COLUMN_DESCRIPTION):
                return 4;
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
                return COLUMN_USER_ID;
            case (3):
                return COLUMN_NAME;
            case (4):
                return COLUMN_DESCRIPTION;
            default :
                throw new IllegalArgumentException("No columns at position " + pos);
        }
    }
}
