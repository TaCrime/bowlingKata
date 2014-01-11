package DAO;

import main.Frame;
import main.Line;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ptatyana on 08.01.14.
 */
public class LineDAOImp implements LineDAO {

    private static Logger logger = LoggerFactory.getLogger(LineDAOImp.class);

    @Override
    public void addLine(Line line) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            for (Frame frame : line.frames) {
                session.save(frame);
            }
            session.save(line);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error( e.getMessage(), "Ошибка I/O");
        }
    }

    @Override
    public void updateLine(Line line) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(line);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error( e.getMessage(), "Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Line getLineById(Long id) throws SQLException {
        Session session = null;
        Line line = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            line = (Line) session.load(Line.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), "Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return line;
    }

    @Override
    public List getAllLines() throws SQLException {
        Session session = null;
        List<Line> studs = new ArrayList<Line>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studs = session.createCriteria(Line.class).list();
        } catch (Exception e) {
            logger.error(e.getMessage(), "Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return studs;
    }

    @Override
    public void deleteLine(Line line) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(line);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error(e.getMessage(), "Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
