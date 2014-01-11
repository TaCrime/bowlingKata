package DAO;

/**
 * Created by ptatyana on 08.01.14.
 */
public class Factory {

    private static LineDAO studentDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public LineDAO getStudentDAO(){
        if (studentDAO == null){
            studentDAO = new LineDAOImp();
        }
        return studentDAO;
    }
}

