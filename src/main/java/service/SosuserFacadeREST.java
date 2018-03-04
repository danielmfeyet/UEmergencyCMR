/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.SosEvent;
import entity.SosLocation;
import entity.Sosuser;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author isnov-pc
 */
@Stateless
@Path("sosuser")
public class SosuserFacadeREST extends AbstractFacade<Sosuser> {

    @PersistenceContext(unitName = "com.mycompany_UEmergencyCMR_war_1.0-SNAPSHOTPU")
   private EntityManager em;

    public SosuserFacadeREST() {
        super(Sosuser.class);
    }

    @GET
    @Path("{name}/{firstname}/{pays}/{phonenumber}/{cni}/{sex}/{phones}")
     @Produces({ "application/xml"})
    public void create(@PathParam("name") String name,@PathParam("firstname") String firstname,@PathParam("pays") String pays,@PathParam("phonenumber") Integer phonenumber,@PathParam("cni") String cni,@PathParam("sex") String sex,@PathParam("phones") Integer phones) {
       
        Sosuser s= new Sosuser();
        s.setUsername(name);
        s.setFirstName(firstname);
        s.setPays(pays);
        s.setPhoneNumber(phonenumber.toString());
        s.setCni(cni);
        s.setSex(sex);
        s.setEmail(phones.toString());
        super.create(s);
    }
    
    @GET
    @Path("{longi}/{lati}/{idlo}/{cni}")
     @Produces({"application/json"})
    public void sendalert(@PathParam("longi") String longi,@PathParam("lati") String lati,@PathParam("idlo") Integer id,@PathParam("cni") String idsosuser){
        
        SosLocation sol=new SosLocation();
        sol.setSosLocation(id);
        sol.setLatitude(lati.toString());
         sol.setLongitude(longi.toString());
         em.persist(sol);
         
         SosEvent sev=new SosEvent();
      
         Query qi=em.createNamedQuery("Sosuser.findByCni");
                  qi.setParameter("cni", idsosuser);

         
         
         Sosuser u= (Sosuser)qi.getSingleResult();
         sev.setAuthorId(u);
         sev.setCreated(new Date());
        
     Query q=em.createNamedQuery("SosLocation.findBylongitude");
     q.setParameter("longi", longi.toString());
     
   Long i  = (Long)q.getSingleResult();
   sol.setId(i);
         
         sev.setLocationId(sol);
         sev.setIdlocation(id.toString());
         
         if(id==1){
           sev.setState("In Progress");
          sev.setDescription("the person who send the alert is "+u.getFirstName()+" and  "+" this is the number/email to contact "+u.getEmail()+". See the location for mores infomations ");
         sev.setTitle("Hospital:Need for hospital help (ambulance-care)");  
         }
         if(id==2){
           sev.setState("In Progress");
          sev.setDescription("the person who send the alert is "+u.getFirstName()+" and  " +"this is the number/email to contact "+u.getEmail()+". See the location for mores infomations ");
         sev.setTitle("Police:Need for police assistance - victim of assault or robbery");  
         }
         if(id==3){
  sev.setState("In Progress");
          sev.setDescription("victim of flood or fire"+"the person who send the alert is "+u.getFirstName()+" and "+"this is the number/email to contact "+u.getEmail()+". See the location for mores infomations ");
         sev.setTitle("Fire:Need for FireFighter - flood or fire");             
         }
         
         em.persist(sev);
         
        
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Sosuser entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Sosuser find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Sosuser> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Sosuser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
