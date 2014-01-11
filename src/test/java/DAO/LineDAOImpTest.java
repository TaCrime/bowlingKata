package DAO;

import main.Line;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ptatyana on 08.01.14.
 */
public class LineDAOImpTest {

    private static Logger logger = LoggerFactory.getLogger(LineDAOImpTest.class);
    private LineDAO lineDAO = DAO.Factory.getInstance().getStudentDAO();

    @Test
    public void testLineAdd() {
        Line line = new Line();
        line.roll(10);
        try {
            lineDAO.addLine(line);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllLines() throws SQLException {
        List<Line> lines =lineDAO.getAllLines();
        for (Line line: lines) {
            logger.info(line.getId().toString());
        }
    }

    @Ignore
    @Test
    public void deleteAllLines() throws SQLException {
        List<Line> lines = lineDAO.getAllLines();
        for (Line line: lines) {
            lineDAO.deleteLine(line);
        }
    }
}
