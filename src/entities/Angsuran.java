/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fitriany Chairunnisa
 */
@Entity
@Table(name = "ANGSURAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Angsuran.findAll", query = "SELECT a FROM Angsuran a")
    , @NamedQuery(name = "Angsuran.findByIdAngsuran", query = "SELECT a FROM Angsuran a WHERE a.idAngsuran = :idAngsuran")
    , @NamedQuery(name = "Angsuran.findByTanggalAngsuran", query = "SELECT a FROM Angsuran a WHERE a.tanggalAngsuran = :tanggalAngsuran")
    , @NamedQuery(name = "Angsuran.findByJumlahAngsuran", query = "SELECT a FROM Angsuran a WHERE a.jumlahAngsuran = :jumlahAngsuran")
    , @NamedQuery(name = "Angsuran.findByDenda", query = "SELECT a FROM Angsuran a WHERE a.denda = :denda")})
public class Angsuran implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ANGSURAN")
    private String idAngsuran;
    @Column(name = "TANGGAL_ANGSURAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalAngsuran;
    @Column(name = "JUMLAH_ANGSURAN")
    private Integer jumlahAngsuran;
    @Column(name = "DENDA")
    private Integer denda;
    @JoinColumn(name = "NO_IDENTITAS", referencedColumnName = "NO_IDENTITAS")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer noIdentitas;
    @JoinColumn(name = "ID_GADAI", referencedColumnName = "ID_GADAI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gadai idGadai;

    public Angsuran() {
    }

    public Angsuran(String idAngsuran) {
        this.idAngsuran = idAngsuran;
    }

    public String getIdAngsuran() {
        return idAngsuran;
    }

    public void setIdAngsuran(String idAngsuran) {
        this.idAngsuran = idAngsuran;
    }

    public Date getTanggalAngsuran() {
        return tanggalAngsuran;
    }

    public void setTanggalAngsuran(Date tanggalAngsuran) {
        this.tanggalAngsuran = tanggalAngsuran;
    }

    public Integer getJumlahAngsuran() {
        return jumlahAngsuran;
    }

    public void setJumlahAngsuran(Integer jumlahAngsuran) {
        this.jumlahAngsuran = jumlahAngsuran;
    }

    public Integer getDenda() {
        return denda;
    }

    public void setDenda(Integer denda) {
        this.denda = denda;
    }

    public Customer getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(Customer noIdentitas) {
        this.noIdentitas = noIdentitas;
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
        hash += (idAngsuran != null ? idAngsuran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Angsuran)) {
            return false;
        }
        Angsuran other = (Angsuran) object;
        if ((this.idAngsuran == null && other.idAngsuran != null) || (this.idAngsuran != null && !this.idAngsuran.equals(other.idAngsuran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idAngsuran + "";
    }
    
}
