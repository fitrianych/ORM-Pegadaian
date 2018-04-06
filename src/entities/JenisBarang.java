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
@Table(name = "JENIS_BARANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisBarang.findAll", query = "SELECT j FROM JenisBarang j")
    , @NamedQuery(name = "JenisBarang.findByIdJenis", query = "SELECT j FROM JenisBarang j WHERE j.idJenis = :idJenis")
    , @NamedQuery(name = "JenisBarang.findByNamaJenis", query = "SELECT j FROM JenisBarang j WHERE j.namaJenis = :namaJenis")})
public class JenisBarang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_JENIS")
    private Short idJenis;
    @Column(name = "NAMA_JENIS")
    private String namaJenis;
    @OneToMany(mappedBy = "idJenis", fetch = FetchType.LAZY)
    private List<Barang> barangList;

    public JenisBarang() {
    }

    public JenisBarang(Short idJenis) {
        this.idJenis = idJenis;
    }

    public Short getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(Short idJenis) {
        this.idJenis = idJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    @XmlTransient
    public List<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(List<Barang> barangList) {
        this.barangList = barangList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJenis != null ? idJenis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JenisBarang)) {
            return false;
        }
        JenisBarang other = (JenisBarang) object;
        if ((this.idJenis == null && other.idJenis != null) || (this.idJenis != null && !this.idJenis.equals(other.idJenis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JenisBarang[ idJenis=" + idJenis + " ]";
    }
    
}
