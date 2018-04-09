/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fitriany Chairunnisa
 */
@Entity
@Table(name = "DETAIL_GADAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailGadai.findAll", query = "SELECT d FROM DetailGadai d")
    , @NamedQuery(name = "DetailGadai.findByKeterangan", query = "SELECT d FROM DetailGadai d WHERE d.keterangan = :keterangan")
    , @NamedQuery(name = "DetailGadai.findByIdDetailGadai", query = "SELECT d FROM DetailGadai d WHERE d.idDetailGadai = :idDetailGadai")})
public class DetailGadai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETAIL_GADAI")
    private Integer idDetailGadai;
    @JoinColumn(name = "ID_BARANG", referencedColumnName = "ID_BARANG")
    @ManyToOne(fetch = FetchType.LAZY)
    private Barang idBarang;
    @JoinColumn(name = "ID_GADAI", referencedColumnName = "ID_GADAI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gadai idGadai;

    public DetailGadai() {
    }

    public DetailGadai(Integer idDetailGadai) {
        this.idDetailGadai = idDetailGadai;
    }

    public DetailGadai(Integer idDetailGadai, Integer idGadai,String keterangan) {
       this.idDetailGadai=this.idDetailGadai;
       this.idGadai=this.idGadai;
       this.keterangan=this.keterangan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Integer getIdDetailGadai() {
        return idDetailGadai;
    }

    public void setIdDetailGadai(Integer idDetailGadai) {
        this.idDetailGadai = idDetailGadai;
    }

    public Barang getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Barang idBarang) {
        this.idBarang = idBarang;
    }

    public Gadai getIdGadai() {
        return idGadai;
    }

    public void setIdGadai(Gadai idGadai) {
        this.idGadai = idGadai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetailGadai != null ? idDetailGadai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailGadai)) {
            return false;
        }
        DetailGadai other = (DetailGadai) object;
        if ((this.idDetailGadai == null && other.idDetailGadai != null) || (this.idDetailGadai != null && !this.idDetailGadai.equals(other.idDetailGadai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idDetailGadai + " ";
    }
    
}
