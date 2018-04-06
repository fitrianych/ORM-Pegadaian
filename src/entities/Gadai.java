/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fitriany Chairunnisa
 */
@Entity
@Table(name = "GADAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gadai.findAll", query = "SELECT g FROM Gadai g")
    , @NamedQuery(name = "Gadai.findByIdGadai", query = "SELECT g FROM Gadai g WHERE g.idGadai = :idGadai")
    , @NamedQuery(name = "Gadai.findByTanggalPengajuan", query = "SELECT g FROM Gadai g WHERE g.tanggalPengajuan = :tanggalPengajuan")
    , @NamedQuery(name = "Gadai.findByJatuhTempo", query = "SELECT g FROM Gadai g WHERE g.jatuhTempo = :jatuhTempo")
    , @NamedQuery(name = "Gadai.findByJumlahPinjaman", query = "SELECT g FROM Gadai g WHERE g.jumlahPinjaman = :jumlahPinjaman")
    , @NamedQuery(name = "Gadai.findByStatus", query = "SELECT g FROM Gadai g WHERE g.status = :status")})
public class Gadai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GADAI")
    private Integer idGadai;
    @Column(name = "TANGGAL_PENGAJUAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggalPengajuan;
    @Column(name = "JATUH_TEMPO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date jatuhTempo;
    @Column(name = "JUMLAH_PINJAMAN")
    private Long jumlahPinjaman;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gadai", fetch = FetchType.LAZY)
    private List<DetailGadai> detailGadaiList;
    @JoinColumn(name = "NO_IDENTITAS", referencedColumnName = "NO_IDENTITAS")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer noIdentitas;
    @OneToMany(mappedBy = "idGadai", fetch = FetchType.LAZY)
    private List<Angsuran> angsuranList;

    public Gadai() {
    }

    public Gadai(Integer idGadai) {
        this.idGadai = idGadai;
    }

    public Integer getIdGadai() {
        return idGadai;
    }

    public void setIdGadai(Integer idGadai) {
        this.idGadai = idGadai;
    }

    public Date getTanggalPengajuan() {
        return tanggalPengajuan;
    }

    public void setTanggalPengajuan(Date tanggalPengajuan) {
        this.tanggalPengajuan = tanggalPengajuan;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public Long getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void setJumlahPinjaman(Long jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<DetailGadai> getDetailGadaiList() {
        return detailGadaiList;
    }

    public void setDetailGadaiList(List<DetailGadai> detailGadaiList) {
        this.detailGadaiList = detailGadaiList;
    }

    public Customer getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(Customer noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    @XmlTransient
    public List<Angsuran> getAngsuranList() {
        return angsuranList;
    }

    public void setAngsuranList(List<Angsuran> angsuranList) {
        this.angsuranList = angsuranList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGadai != null ? idGadai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gadai)) {
            return false;
        }
        Gadai other = (Gadai) object;
        if ((this.idGadai == null && other.idGadai != null) || (this.idGadai != null && !this.idGadai.equals(other.idGadai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Gadai[ idGadai=" + idGadai + " ]";
    }
    
}
