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
@Table(name = "sosuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sosuser.findAll", query = "SELECT s FROM Sosuser s"),
    @NamedQuery(name = "Sosuser.findById", query = "SELECT s FROM Sosuser s WHERE s.id = :id"),
    @NamedQuery(name = "Sosuser.findByEmail", query = "SELECT s FROM Sosuser s WHERE s.email = :email"),
    @NamedQuery(name = "Sosuser.findByFirstName", query = "SELECT s FROM Sosuser s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Sosuser.findByCni", query = "SELECT s FROM Sosuser s WHERE s.cni = :cni"),
    @NamedQuery(name = "Sosuser.findByPays", query = "SELECT s FROM Sosuser s WHERE s.pays = :pays"),
    @NamedQuery(name = "Sosuser.findByPhoneNumber", query = "SELECT s FROM Sosuser s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Sosuser.findBySex", query = "SELECT s FROM Sosuser s WHERE s.sex = :sex"),
    @NamedQuery(name = "Sosuser.findByUsername", query = "SELECT s FROM Sosuser s WHERE s.username = :username")})
public class Sosuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 160)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 60)
    @Column(name = "cni")
    private String cni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pays")
    private String pays;
    @Size(max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(max = 12)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "username")
    private String username;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sosuser")
    private Admin admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
    private List<SosEvent> sosEventList;

    public Sosuser() {
    }

    public Sosuser(Long id) {
        this.id = id;
    }

    public Sosuser(Long id, String firstName, String pays, String username) {
        this.id = id;
        this.firstName = firstName;
        this.pays = pays;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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
        if (!(object instanceof Sosuser)) {
            return false;
        }
        Sosuser other = (Sosuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sosuser[ id=" + id + " ]";
    }
    
}