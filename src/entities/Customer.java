/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fitriany Chairunnisa
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByNoIdentitas", query = "SELECT c FROM Customer c WHERE c.noIdentitas = :noIdentitas")
    , @NamedQuery(name = "Customer.findByNama", query = "SELECT c FROM Customer c WHERE c.nama = :nama")
    , @NamedQuery(name = "Customer.findByJenisKelamin", query = "SELECT c FROM Customer c WHERE c.jenisKelamin = :jenisKelamin")
    , @NamedQuery(name = "Customer.findByNoTelp", query = "SELECT c FROM Customer c WHERE c.noTelp = :noTelp")
    , @NamedQuery(name = "Customer.findByPekerjaan", query = "SELECT c FROM Customer c WHERE c.pekerjaan = :pekerjaan")
    , @NamedQuery(name = "Customer.findByAlamat", query = "SELECT c FROM Customer c WHERE c.alamat = :alamat")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NO_IDENTITAS")
    private Integer noIdentitas;
    @Column(name = "NAMA")
    private String nama;
    @Column(name = "JENIS_KELAMIN")
    private String jenisKelamin;
    @Column(name = "NO_TELP")
    private String noTelp;
    @Column(name = "PEKERJAAN")
    private String pekerjaan;
    @Column(name = "ALAMAT")
    private String alamat;

    public Customer() {
    }

    public Customer(Integer noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    public Customer(Integer noIdentitas, String nama, String jenisKelamin, String noTelp, String pekerjaan, String alamat) {
        this.noIdentitas = noIdentitas;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.noTelp = noTelp;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
    }

    public Integer getNoIdentitas() {
        return noIdentitas;
    }

    public void setNoIdentitas(Integer noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noIdentitas != null ? noIdentitas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.noIdentitas == null && other.noIdentitas != null) || (this.noIdentitas != null && !this.noIdentitas.equals(other.noIdentitas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + noIdentitas + " ";
    }
    
}
