package DAO;

import main.Line;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ptatyana on 08.01.14.
 */
public interface LineDAO {
    public void addLine(Line line) throws SQLException;
    public void updateLine(Line line) throws SQLException;
    public Line getLineById(Long id) throws SQLException;
    public List getAllLines() throws SQLException;
    public void deleteLine(Line line) throws SQLException;
}
