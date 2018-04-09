/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Customer;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class CustomerDAO implements InterfaceDAO{
     public Session session;
    private SessionFactory factory;
    public Transaction transaction;

    public FunctionsDAO fdao;
    
    public CustomerDAO()
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
        return fdao.delete(Customer.class,Integer.parseInt(object.toString()));
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll("FROM Customer order by noIdentitas asc");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Customer WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Customer where noIdentitas='" + id + "'");
    }
}
