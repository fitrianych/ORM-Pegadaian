/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fitriany Chairunnisa
 */
@Entity
@Table(name = "STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
    , @NamedQuery(name = "Status.findByIdSatus", query = "SELECT s FROM Status s WHERE s.idSatus = :idSatus")
    , @NamedQuery(name = "Status.findByStatus", query = "SELECT s FROM Status s WHERE s.status = :status")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SATUS")
    private String idSatus;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "idStatus", fetch = FetchType.LAZY)
    private List<Gadai> gadaiList;

    public Status() {
    }

    public Status(String idSatus) {
        this.idSatus = idSatus;
    }

    public String getIdSatus() {
        return idSatus;
    }

    public void setIdSatus(String idSatus) {
        this.idSatus = idSatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Gadai> getGadaiList() {
        return gadaiList;
    }

    public void setGadaiList(List<Gadai> gadaiList) {
        this.gadaiList = gadaiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSatus != null ? idSatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.idSatus == null && other.idSatus != null) || (this.idSatus != null && !this.idSatus.equals(other.idSatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Status[ idSatus=" + idSatus + " ]";
    }
    
}
