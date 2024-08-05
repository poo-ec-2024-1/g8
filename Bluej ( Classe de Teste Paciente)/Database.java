
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import java.sql.SQLException;

public class Database {
    private String databasePath = null;
    private JdbcConnectionSource connection = null;

    public Database(String databasePath) {
        this.databasePath = databasePath;
    }

    public JdbcConnectionSource getConnection() throws SQLException {
        if (databasePath == null) {
            throw new SQLException("database path is null");
        }
        if (connection == null) {
            try {
                connection = new JdbcConnectionSource("jdbc:sqlite:" + databasePath);
                System.out.println("Opened database successfully");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return connection;
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                this.connection = null;
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
