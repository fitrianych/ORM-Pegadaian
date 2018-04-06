/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    , @NamedQuery(name = "DetailGadai.findByIdDetailGadai", query = "SELECT d FROM DetailGadai d WHERE d.detailGadaiPK.idDetailGadai = :idDetailGadai")
    , @NamedQuery(name = "DetailGadai.findByIdGadai", query = "SELECT d FROM DetailGadai d WHERE d.detailGadaiPK.idGadai = :idGadai")
    , @NamedQuery(name = "DetailGadai.findByIdBarang", query = "SELECT d FROM DetailGadai d WHERE d.detailGadaiPK.idBarang = :idBarang")
    , @NamedQuery(name = "DetailGadai.findByKeterangan", query = "SELECT d FROM DetailGadai d WHERE d.keterangan = :keterangan")})
public class DetailGadai implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailGadaiPK detailGadaiPK;
    @Column(name = "KETERANGAN")
    private String keterangan;
    @JoinColumn(name = "ID_BARANG", referencedColumnName = "ID_BARANG", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Barang barang;
    @JoinColumn(name = "ID_GADAI", referencedColumnName = "ID_GADAI", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Gadai gadai;

    public DetailGadai() {
    }

    public DetailGadai(DetailGadaiPK detailGadaiPK) {
        this.detailGadaiPK = detailGadaiPK;
    }

    public DetailGadai(int idDetailGadai, int idGadai, short idBarang) {
        this.detailGadaiPK = new DetailGadaiPK(idDetailGadai, idGadai, idBarang);
    }

    public DetailGadaiPK getDetailGadaiPK() {
        return detailGadaiPK;
    }

    public void setDetailGadaiPK(DetailGadaiPK detailGadaiPK) {
        this.detailGadaiPK = detailGadaiPK;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Gadai getGadai() {
        return gadai;
    }

    public void setGadai(Gadai gadai) {
        this.gadai = gadai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailGadaiPK != null ? detailGadaiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailGadai)) {
            return false;
        }
        DetailGadai other = (DetailGadai) object;
        if ((this.detailGadaiPK == null && other.detailGadaiPK != null) || (this.detailGadaiPK != null && !this.detailGadaiPK.equals(other.detailGadaiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailGadai[ detailGadaiPK=" + detailGadaiPK + " ]";
    }
    
}
