package edu.fakedomain.greettestproj.controller;

import edu.fakedomain.greettestproj.model.SimpleMapper;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * George Un 
 */
/**
 * Web application lifecycle listener.
 *
 * @author George Un
 */
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String mybatisConf = "mybatis-config.xml";
        SqlSessionFactory sqlSF = null;

        //init single sessionfactory instance
        try {

            Reader reader = Resources.getResourceAsReader(mybatisConf);
            sqlSF = new SqlSessionFactoryBuilder().build(reader);
            sce.getServletContext().setAttribute("sessionFactory", sqlSF);
        } catch (Exception ex) {
            Logger.getLogger(AppContextListener.class.getName()).log(Level.SEVERE, null, ex);
            //no work if initialization fails
            System.exit(1);
        }

        //prepare data
        try (SqlSession session = sqlSF.openSession()) {
            populateData(session);
            session.commit();
        }
    }

    private void populateData(SqlSession session) {
        SimpleMapper mapper = session.getMapper(SimpleMapper.class);
        int rowsNo = -1;

        try {
            rowsNo = mapper.checkIfDataExist();
        } catch (Exception exc) {
            //Table might not exist
            mapper.createTable();
            rowsNo = 0;
        }
        if (rowsNo == 0) {
            mapper.populateTable();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
