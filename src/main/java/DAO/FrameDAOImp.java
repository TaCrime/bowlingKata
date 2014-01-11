package DAO;

import main.Frame;
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
public class FrameDAOImp implements FrameDAO {

    private static Logger logger = LoggerFactory.getLogger(FrameDAOImp.class);

    @Override
    public void addFrame(Frame Frame) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(Frame);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error( e.getMessage(), "Ошибка I/O");
        }
    }

    @Override
    public void updateFrame(Frame Frame) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(Frame);
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
    public Frame getFrameById(Long id) throws SQLException {
        Session session = null;
        Frame Frame = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Frame = (Frame) session.load(Frame.class, id);
        } catch (Exception e) {
            logger.error(e.getMessage(), "Ошибка I/O");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return Frame;
    }

    @Override
    public List getAllFrames() throws SQLException {
        Session session = null;
        List<Frame> studs = new ArrayList<Frame>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            studs = session.createCriteria(Frame.class).list();
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
    public void deleteFrame(Frame Frame) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(Frame);
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
