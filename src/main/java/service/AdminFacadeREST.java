/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Admin;
import entity.SosEvent;
import entity.SosLocation;
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
@Path("admin")
public class AdminFacadeREST extends AbstractFacade<Admin> {

    @PersistenceContext(unitName = "com.mycompany_UEmergencyCMR_war_1.0-SNAPSHOTPU")
 private EntityManager em;

    public AdminFacadeREST() {
        super(Admin.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Admin entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Admin entity) {
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
    public Admin find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Admin> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Admin> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    public List<SosEvent> GetAllEvent(){
        
        Query q=em.createNamedQuery("SosEvent.findAll");
        return (List<SosEvent>) q.getResultList();
    }
    public List<SosEvent> liststaticdescfromtypeevent(String is){
        
         Query q=em.createNamedQuery("SosEvent.findByListOfEvent");
         
        q.setParameter("idlocation", is);
         q.setParameter("state", "In Progress");
        return (List<SosEvent>) q.getResultList();
    }
    public SosLocation getSosLocation(SosEvent o){
       Query q=em.createNamedQuery("SosLocation.findById"); 
       q.setParameter("id", o.getLocationId().getId());
       return (SosLocation) q.getSingleResult();
    }
    public void mergesosevent(SosEvent s){
       
        em.merge(s);
    }
    
}
