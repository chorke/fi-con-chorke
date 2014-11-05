package org.chorke.ficon.backend.sql.metadata;

/**
 *
 * @author Chorke
 */
public interface DBMetaData {

    public interface DataSourceProps {

        public static final String HOST = "localhost";
        public static final int PORT = 5432;
        public static final String USER = "Juraj Durani";
        public static final String PASSWORD = "288charlotte462";
        public static final String DATA_SOURCE_NAME = "FiCon.PostgreSQL.9.3.PoolingDataSource";
        public static final String DATABASE_NAME = "FiConDB";
        public static final int MAX_CONNECTIONS = 3;
    }
}
