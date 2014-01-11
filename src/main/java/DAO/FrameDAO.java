package DAO;

import main.Frame;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ptatyana on 08.01.14.
 */
public interface FrameDAO {
    public void addFrame(Frame Frame) throws SQLException;
    public void updateFrame(Frame Frame) throws SQLException;
    public Frame getFrameById(Long id) throws SQLException;
    public List getAllFrames() throws SQLException;
    public void deleteFrame(Frame Frame) throws SQLException;
}
