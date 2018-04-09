/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Barang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class BarangDAO implements InterfaceDAO{
    public Session session;
    private SessionFactory factory;
    public Transaction transaction;

    public FunctionsDAO fdao;
    
    public BarangDAO()
    {
        this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
    }

    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
      return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
        return fdao.delete(Barang.class, Short.decode(object + ""));
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Barang order by idBarang asc");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Barang WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Barang where idBarang=" + id);
    }
    
    public Object getByIdJns(String id){
        return fdao.getByIdJns("from JenisBarang where idJenis ='" + id + "'");
    }
    
    
}
