/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Fitriany Chairunnisa
 */
@Embeddable
public class DetailGadaiPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_GADAI")
    private int idGadai;
    @Basic(optional = false)
    @Column(name = "ID_BARANG")
    private short idBarang;

    public DetailGadaiPK() {
    }

    public DetailGadaiPK(int idGadai, short idBarang) {
        this.idGadai = idGadai;
        this.idBarang = idBarang;
    }

    public int getIdGadai() {
        return idGadai;
    }

    public void setIdGadai(int idGadai) {
        this.idGadai = idGadai;
    }

    public short getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(short idBarang) {
        this.idBarang = idBarang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGadai;
        hash += (int) idBarang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailGadaiPK)) {
            return false;
        }
        DetailGadaiPK other = (DetailGadaiPK) object;
        if (this.idGadai != other.idGadai) {
            return false;
        }
        if (this.idBarang != other.idBarang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailGadaiPK[ idGadai=" + idGadai + ", idBarang=" + idBarang + " ]";
    }
    
}
