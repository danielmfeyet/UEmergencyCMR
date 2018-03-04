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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "static_description")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaticDescription.findAll", query = "SELECT s FROM StaticDescription s"),
    @NamedQuery(name = "StaticDescription.findByCreated", query = "SELECT s FROM StaticDescription s WHERE s.created = :created"),
    @NamedQuery(name = "StaticDescription.findByDescription", query = "SELECT s FROM StaticDescription s WHERE s.description = :description"),
    @NamedQuery(name = "StaticDescription.findByModified", query = "SELECT s FROM StaticDescription s WHERE s.modified = :modified"),
    @NamedQuery(name = "StaticDescription.findByName", query = "SELECT s FROM StaticDescription s WHERE s.name = :name"),
    @NamedQuery(name = "StaticDescription.findByState", query = "SELECT s FROM StaticDescription s WHERE s.state = :state"),
    @NamedQuery(name = "StaticDescription.findByIdType", query = "SELECT s FROM StaticDescription s WHERE s.typeId = :typeId"),
    @NamedQuery(name = "StaticDescription.findById", query = "SELECT s FROM StaticDescription s WHERE s.id = :id")})
public class StaticDescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LocationType typeId;
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Admin creatorId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SosLocation sosLocation;

    public StaticDescription() {
    }

    public StaticDescription(Long id) {
        this.id = id;
    }

    public StaticDescription(Long id, String description, String name, int state) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.state = state;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocationType getTypeId() {
        return typeId;
    }

    public void setTypeId(LocationType typeId) {
        this.typeId = typeId;
    }

    public Admin getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Admin creatorId) {
        this.creatorId = creatorId;
    }

    public SosLocation getSosLocation() {
        return sosLocation;
    }

    public void setSosLocation(SosLocation sosLocation) {
        this.sosLocation = sosLocation;
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
        if (!(object instanceof StaticDescription)) {
            return false;
        }
        StaticDescription other = (StaticDescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StaticDescription[ id=" + id + " ]";
    }
    
}