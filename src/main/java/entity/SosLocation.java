/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "sos_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SosLocation.findAll", query = "SELECT s FROM SosLocation s"),
    @NamedQuery(name = "SosLocation.findMaxid", query = "SELECT Max(s.id) FROM SosLocation s"),
    @NamedQuery(name = "SosLocation.findBylongitude", query = "SELECT s.id FROM SosLocation s where s.longitude= :longi"),
    @NamedQuery(name = "SosLocation.findById", query = "SELECT s FROM SosLocation s WHERE s.id = :id"),
    @NamedQuery(name = "SosLocation.findBySosLocation", query = "SELECT s FROM SosLocation s WHERE s.sosLocation = :sosLocation")})
public class SosLocation implements Serializable {
    @Size(max = 100)
    @Column(name = "longitude")
    private String longitude;
    @Size(max = 100)
    @Column(name = "latitude")
    private String latitude;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sos_location")
    private int sosLocation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sosLocation")
    private StaticDescription staticDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<SosEvent> sosEventList;

    public SosLocation() {
    }

    public SosLocation(Long id) {
        this.id = id;
    }

    public SosLocation(Long id, int sosLocation) {
        this.id = id;
        this.sosLocation = sosLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSosLocation() {
        return sosLocation;
    }

    public void setSosLocation(int sosLocation) {
        this.sosLocation = sosLocation;
    }

    public StaticDescription getStaticDescription() {
        return staticDescription;
    }

    public void setStaticDescription(StaticDescription staticDescription) {
        this.staticDescription = staticDescription;
    }

    @XmlTransient
    public List<SosEvent> getSosEventList() {
        return sosEventList;
    }

    public void setSosEventList(List<SosEvent> sosEventList) {
        this.sosEventList = sosEventList;
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
        if (!(object instanceof SosLocation)) {
            return false;
        }
        SosLocation other = (SosLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SosLocation[ id=" + id + " ]";
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
}