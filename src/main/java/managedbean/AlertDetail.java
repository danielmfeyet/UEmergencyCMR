/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.SosEvent;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Named(value = "alertDetail")
@ManagedBean
@SessionScoped
public class AlertDetail implements Serializable {

 
   
    private MapModel simpleModel;
    
    SosEvent ev;
    /**
     * Creates a new instance of AlertDetail
     */
    
    @PostConstruct
    public void init() {
        
      simpleModel = new DefaultMapModel();  
      ev=new SosEvent();
     HttpSession session = SessionUtils.getSession();
     
      SosEvent seembean= (SosEvent) session.getAttribute("user");
      ev=seembean;
   
          
         Integer lag=Integer.valueOf(seembean.getLocationId().getLatitude());
         Integer longi=Integer.valueOf(seembean.getLocationId().getLongitude());
       LatLng coord1 = new LatLng(45563, 5588);
       simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
       
    
    }
    public AlertDetail() {
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    

    public SosEvent getEv() {
        return ev;
    }

    public void setEv(SosEvent ev) {
        this.ev = ev;
    }
    
}
