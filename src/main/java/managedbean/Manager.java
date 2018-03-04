/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.SosEvent;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import service.AdminFacadeREST;

/**
 *
 * @author isnov-pc
 */
@ManagedBean
@SessionScoped
public class Manager implements Serializable {

    @EJB
    private AdminFacadeREST adminFacadeREST;
SosEvent ev;

String name;
String psw;

private List<SosEvent> ListofSosEvent;

    public AdminFacadeREST getAdminFacadeREST() {
        return adminFacadeREST;
    }

    public void setAdminFacadeREST(AdminFacadeREST adminFacadeREST) {
        this.adminFacadeREST = adminFacadeREST;
    }

    public SosEvent getEv() {
        return ev;
    }

    public void setEv(SosEvent ev) {
        this.ev = ev;
    }

    public List<SosEvent> getListofSosEvent() {
        return adminFacadeREST.GetAllEvent();
    }

    public void setListofSosEvent(List<SosEvent> ListofSosEvent) {
        this.ListofSosEvent = ListofSosEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }



    /**
     * Creates a new instance of Manager
     */
    public Manager() {
        this.ev= new SosEvent();
        this.name= new String();
        this.psw=new String();
    }
    
    public String   ShowEvent(SosEvent e){
        this.ev=e;
      
        return "VisualAlert.xhtml";
    }
    
    
    public String login(){
        String pageCon= null;
        if(name.equals("olivia@mapubi.com") &&  psw.equals("olivia")){
            pageCon="acceuil.xhtml";
            
        }
        
        if(pageCon==null){
           FacesMessage fm = new FacesMessage("Parametre de connexion incorecte,");
              fm.setSeverity(FacesMessage.SEVERITY_ERROR);
              FacesContext.getCurrentInstance().addMessage(null, fm);
                pageCon="index.xhtml";
      }  
   return pageCon;  }
    

    
    
   
}
