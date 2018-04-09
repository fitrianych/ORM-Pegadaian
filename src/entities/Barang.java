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
@Table(name = "BARANG_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barang.findAll", query = "SELECT b FROM Barang b")
    , @NamedQuery(name = "Barang.findByIdBarang", query = "SELECT b FROM Barang b WHERE b.idBarang = :idBarang")
    , @NamedQuery(name = "Barang.findByNamaBarang", query = "SELECT b FROM Barang b WHERE b.namaBarang = :namaBarang")})
public class Barang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BARANG")
    private Short idBarang;
    @Column(name = "NAMA_BARANG")
    private String namaBarang;
    @JoinColumn(name = "ID_JENIS", referencedColumnName = "ID_JENIS")
    @ManyToOne(fetch = FetchType.LAZY)
    private JenisBarang idJenis;

    public Barang() {
    }

    public Barang(Short idBarang) {
        this.idBarang = idBarang;
    }

    public Barang(Short idBarang, String namaBarang) {
        this.idBarang=idBarang;
        this.namaBarang=namaBarang;
    }

    public Short getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Short idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public JenisBarang getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(JenisBarang idJenis) {
        this.idJenis = idJenis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarang != null ? idBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barang)) {
            return false;
        }
        Barang other = (Barang) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idBarang + " ";
    }
    
}
