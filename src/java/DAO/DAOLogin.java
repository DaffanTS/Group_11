package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TblUser;
import pojo.FurnitureUtil;

public class DAOLogin {
    public List<TblUser> getBy(String uName, String uPass){
        TblUser u = new TblUser();
        List<TblUser> user = new ArrayList();
        
        Transaction trans = null;
        Session session = FurnitureUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblUser where username="
                        + " :uName AND password= :uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            u = (TblUser) query.uniqueResult();
            user = query.list();
            
            trans.commit();
        }catch (Exception e) {
            System.out.println("Error: "+ e);
        }
        return user;
    }
    
    public void addUser(TblUser usr) {
        Transaction trans = null;
        Session session = FurnitureUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(usr);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
