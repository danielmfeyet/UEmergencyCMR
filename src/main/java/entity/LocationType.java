/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "location_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationType.findAll", query = "SELECT l FROM LocationType l"),
    @NamedQuery(name = "LocationType.findById", query = "SELECT l FROM LocationType l WHERE l.id = :id"),
    @NamedQuery(name = "LocationType.findByCreated", query = "SELECT l FROM LocationType l WHERE l.created = :created"),
    @NamedQuery(name = "LocationType.findByModified", query = "SELECT l FROM LocationType l WHERE l.modified = :modified"),
    @NamedQuery(name = "LocationType.findByName", query = "SELECT l FROM LocationType l WHERE l.name = :name"),
    @NamedQuery(name = "LocationType.findByState", query = "SELECT l FROM LocationType l WHERE l.state = :state")})
public class LocationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Column(name = "state")
    private Integer state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private List<StaticDescription> staticDescriptionList;
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Admin creatorId;

    public LocationType() {
    }

    public LocationType(Long id) {
        this.id = id;
    }

    public LocationType(Long id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
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

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @XmlTransient
    public List<StaticDescription> getStaticDescriptionList() {
        return staticDescriptionList;
    }

    public void setStaticDescriptionList(List<StaticDescription> staticDescriptionList) {
        this.staticDescriptionList = staticDescriptionList;
    }

    public Admin getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Admin creatorId) {
        this.creatorId = creatorId;
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
        if (!(object instanceof LocationType)) {
            return false;
        }
        LocationType other = (LocationType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LocationType[ id=" + id + " ]";
    }
    
}