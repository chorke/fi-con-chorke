
package org.chorke.ficon.backend.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;

/**
 *
 * @author Chorke
 */
public abstract class SQLBuilderBasic implements SQLBuilder{

    protected Connection connection;
    
    protected PreparedStatement statement;
    
    protected final int statementType;

    public SQLBuilderBasic(Connection con, int statementType) throws SQLException{
        checkConnection(con);
        this.connection = con;
        this.statementType = statementType;
        reset();
    }
            
    private void checkConnection(Connection con) throws SQLException{
        if(con == null || con.isClosed()){
            throw new SQLException("Connection is invalid (null or closed) [" + con + "].");
        }
    }
    
    protected void setString(PreparedStatement ps, int pos, String toSet) throws SQLException{
        if(toSet == null){
            ps.setNull(pos, Types.VARCHAR);
        } else {
            ps.setString(pos, toSet);
        }
    }
    
    protected void setLong(PreparedStatement ps, int pos, Long toSet) throws SQLException{
        if(toSet == null){
            ps.setNull(pos, Types.INTEGER);
        } else {
            ps.setLong(pos, toSet);
        }
    }
    
    protected void setTimestamp(PreparedStatement ps, int pos, Calendar toSet) throws SQLException {
        if(toSet == null){
            ps.setNull(pos, Types.TIMESTAMP);
        } else {
            ps.setTimestamp(pos, new Timestamp(toSet.getTimeInMillis()), toSet);
        }
    }
    
    protected void setBigDecimal(PreparedStatement ps, int pos, BigDecimal toSet) throws SQLException {
        if(toSet == null){
            ps.setNull(pos, Types.NUMERIC);
        } else {
            ps.setBigDecimal(pos, toSet);
        }
    }

    @Override
    public int getType() {
        return statementType;
    }
    
    @Override
    public void close() throws SQLException {
        if(statement != null){
            statement.close();
        }
    }
}
