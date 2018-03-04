/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "sos_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SosEvent.findAll", query = "SELECT s FROM SosEvent s order by s.id desc"),
    @NamedQuery(name = "SosEvent.findById", query = "SELECT s FROM SosEvent s WHERE s.id = :id"),
    @NamedQuery(name = "SosEvent.findByCreated", query = "SELECT s FROM SosEvent s WHERE s.created = :created"),
    @NamedQuery(name = "SosEvent.findByDescription", query = "SELECT s FROM SosEvent s WHERE s.description = :description"),
    @NamedQuery(name = "SosEvent.findByTitle", query = "SELECT s FROM SosEvent s WHERE s.title = :title"),
    @NamedQuery(name = "SosEvent.findByState", query = "SELECT s FROM SosEvent s WHERE s.state = :state"),
    @NamedQuery(name = "SosEvent.findByListOfEvent", query = "SELECT s FROM SosEvent s WHERE s.state = :state AND s.idlocation = :idlocation"),
    @NamedQuery(name = "SosEvent.findByIdlocation", query = "SELECT s FROM SosEvent s WHERE s.idlocation = :idlocation")})
public class SosEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idlocation")
    private String idlocation;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SosLocation locationId;
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sosuser authorId;

    public SosEvent() {
    }

    public SosEvent(Long id) {
        this.id = id;
    }

    public SosEvent(Long id, Date created, String idlocation) {
        this.id = id;
        this.created = created;
        this.idlocation = idlocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(String idlocation) {
        this.idlocation = idlocation;
    }

    public SosLocation getLocationId() {
        return locationId;
    }

    public void setLocationId(SosLocation locationId) {
        this.locationId = locationId;
    }

    public Sosuser getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Sosuser authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SosEvent)) {
            return false;
        }
        SosEvent other = (SosEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SosEvent[ id=" + id + " ]";
    }
    
}