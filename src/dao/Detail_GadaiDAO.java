/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.DetailGadai;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class Detail_GadaiDAO implements InterfaceDAO{
    
    public SessionFactory factory;
    private Session session;
    private Transaction transaction;
    public FunctionsDAO fdao;
    
     public Detail_GadaiDAO() {
         this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
         this.factory=HibernateUtil.getSessionFactory();
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
       return fdao.delete(DetailGadai.class, Integer.parseInt(object.toString()));
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM DetailGadai order by idDetailGadai asc");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM DetailGadai WHERE idGadai LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from DetailGadai where idGadai='" + id + "'");
    }
    
}
