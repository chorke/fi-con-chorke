package org.chorke.ficon.backend.sql.metadata;

/**
 *
 * @author Chorke
 */
public class UsersMetaData implements TableMetaData {

    public static final UsersMetaData INSTANCE = new UsersMetaData();
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Name";

    private UsersMetaData() {}

    @Override
    public int getBasicColumnMapping(String columnName){
        switch(columnName){
            case (COLUMN_ID):
                return 1;
            case (COLUMN_NAME):
                return 2;
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
                return COLUMN_NAME;
            default :
                throw new IllegalArgumentException("No columns at position " + pos);
        }
    }
}
