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

/**
 *
 * @author Fitriany Chairunnisa
 */
public class GadaiDAO implements InterfaceDAO{
     public Session session;
    private SessionFactory factory;
    public Transaction transaction;

    public FunctionsDAO fdao;

    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object object) {
        return fdao.insert(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object object) {
         return fdao.delete(Customer.class,(new BigDecimal(object+""))); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
      return fdao.getAll("FROM Gadai");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> search(String category, String search) {
         return fdao.getAll("FROM Gadai WHERE " + category + " LIKE '%" + search + "%'");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(String id) {
       return fdao.getById("from Gadai where GadaiId='" + id + "'"); //To change body of generated methods, choose Tools | Templates.
    }
}
