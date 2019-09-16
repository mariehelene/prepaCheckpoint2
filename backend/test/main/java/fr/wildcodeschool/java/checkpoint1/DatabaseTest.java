package fr.wildcodeschool.java.checkpoint1;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest {

    @Test
    public void isAnythingInDatabase() throws SQLException {
        ResultSet rs = new ConnectionProducer()
                .getConnection()
                .createStatement()
                .executeQuery("select * from ennemies");

        while(rs.next()) {
            System.out.println(rs.getInt(1) + ": " + rs.getString(2) + "(" + rs.getString(3) + ")");
        }

        rs.last();
        int count = rs.getRow();
        assertTrue(count > 0);
    }

}
