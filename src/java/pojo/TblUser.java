package pojo;
// Generated Oct 5, 2021 9:26:00 AM by Hibernate Tools 4.3.1

import javax.faces.bean.ManagedBean;
import DAO.DAOLogin;
import java.util.List;


@ManagedBean
/**
 * TblUser generated by hbm2java
 */
public class TblUser  implements java.io.Serializable {


     private Integer idUser;
     private String username;

    public Boolean getShowalert() {
        return showalert;
    }

    public void setShowalert(Boolean showalert) {
        this.showalert = showalert;
    }

    public Boolean getShowalertregis() {
        return showalertregis;
    }

    public void setShowalertregis(Boolean showalertregis) {
        this.showalertregis = showalertregis;
    }

    public Boolean getShowalertregisfail() {
        return showalertregisfail;
    }

    public void setShowalertregisfail(Boolean showalertregisfail) {
        this.showalertregisfail = showalertregisfail;
    }
     private String password;
     private String role;
     private Boolean showalert; 
     private Boolean showalertregis;
     private Boolean showalertregisfail;
     
    public TblUser() {
    }

    public TblUser(String username, String password, String role) {
       this.username = username;
       this.password = password;
       this.role = role;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    public String validasiLogin(){
        DAOLogin uDao = new DAOLogin();
        List<TblUser> us = uDao.getBy(username, password);
        if (us.size()>0){
            username = us.get(0).username;
            password = us.get(0).password;
            role = us.get(0).role;
            return "view_furniture";
        }
        showalert = true;
         return "index";
    }
    public void add() {
        DAOLogin usr = new DAOLogin();
        List<TblUser> us = usr.getBy(username, password);
        if (us.size()>0){
        usr.addUser(this);
        username ="";
        password="";
        role="";
        showalertregis = true;
        }else{
            showalertregisfail = true;
        }
        
    }
    


}


