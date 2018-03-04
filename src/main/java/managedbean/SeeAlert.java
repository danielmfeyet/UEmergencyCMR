/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.SosEvent;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import service.AdminFacadeREST;

/**
 *
 * @author MFEYET Daniel Steven
 */
@ManagedBean
@Named(value = "seeAlert")
@SessionScoped
public class SeeAlert {

    @EJB
    private AdminFacadeREST admin;
    private MapModel simpleModel;
    SosEvent sev;
    /**
     * Creates a new instance of SeeAlert
     */
  
    
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    
    
    
    
    
    public SeeAlert() {
        sev= new SosEvent();
    }
    
    
    
    
    public List<SosEvent> getListOfPoliceEvent(){
        
        return admin.liststaticdescfromtypeevent("2");
                
    }
    public List<SosEvent> getListOfHealthEvent(){
        
        return admin.liststaticdescfromtypeevent("1");
                
    }
    
    public List<SosEvent> getListOfFireEvent(){
        
        return admin.liststaticdescfromtypeevent("3");
                
    }
     public String changestatepolice( String u){
  this.sev.setDescription(u);
     
        return "VisualAlert.xhtml";
    }
public String visualit(){
    
    return "";
}
    public SosEvent getSev() {
        return sev;
    }

    public void setSev(SosEvent sev) {
        this.sev = sev;
    }
   
}
