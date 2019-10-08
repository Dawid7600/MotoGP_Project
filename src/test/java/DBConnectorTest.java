
import Database.DBConnector;
import org.junit.Test;
import static org.junit.Assert.*;


import java.sql.SQLException;

public class DBConnectorTest {

    @Test
    //Connection should return same object instance
    public void returnSameInstanceTest() {
        try {
            DBConnector.connect();
            assertSame(DBConnector.connect(), DBConnector.connect());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    //Connection should be online because method connect was called
    public void connectionSuccessTest() {
        try {
            DBConnector.connect();
            assertTrue(DBConnector.isOnline());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}