
package org.chorke.ficon.backend.sql.metadata;

/**
 *
 * @author Chorke
 */
public interface TableMetaData {
    
    int getBasicColumnMapping(String columnName);
    
    int getInsertColumnMapping(String columnName, boolean insertWithoutID);
    
    String getColumnNameAtPositionInInsert(int pos, boolean insertWithoutID);
}
