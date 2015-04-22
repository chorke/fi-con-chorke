package org.chorke.ficon.backend.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Chorke
 */
public interface SQLBuilder extends AutoCloseable {

    static interface StatementType{
        static final int TYPE_SELECT = 1;
        static final int TYPE_INSERT = 2;
        static final int TYPE_DELETE = 3;
        static final int TYPE_UPDATE = 4;
    }
    
    PreparedStatement build() throws SQLException;
    
    int getType();
    
    void reset();
}
