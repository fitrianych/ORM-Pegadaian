/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import entities.Customer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class CustomerController {
     private final CustomerDAO cDAO;
     
     public CustomerController() {
        this.cDAO = new CustomerDAO();
    }
//      public boolean insert(String no_identitas, String nama, String jenis_kelamin, String no_telp, String pekerjaan, String alamat)
//    {
//        Customer r = new Customer(no_identitas, nama, jenis_kelamin,
//                no_telp, pekerjaan, alamat);
//        return cDAO.insert(r);
//    }
//    
//     
//     public boolean update(Integer no_identitas, String nama, String jenis_kelamin, String no_telp, String pekerjaan, String alamat)
//    {
//        Customer cuss = new Customer(no_identitas, nama, jenis_kelamin, no_telp, pekerjaan, alamat);
//        return cDAO.update(cuss);
//    }
     
       public boolean save(String noIdentitas, String nama, String jenisKelamin, String noTelp, String pekerjaan, String alamat,boolean isSave){
        Customer cus = new Customer();
       cus.setNoIdentitas(Integer.parseInt(noIdentitas));
       cus.setNama(nama);
       cus.setJenisKelamin(jenisKelamin);
       cus.setNoTelp(noTelp);
       cus.setPekerjaan(pekerjaan);
       cus.setAlamat(alamat);
     
        if (isSave){ return cDAO.insert(cus);
        }
                
        return cDAO.update(cus);
    }
     
     public boolean delete(String no_identitas)
    {
        Customer cus1 = new Customer(new Integer(no_identitas+""));
        return cDAO.delete(cus1.getNoIdentitas());
    }
     
     public void bindingSearch(JTable table, String[]header, String category, String search){
        bindingTable(table, header, cDAO.search(category, search));
    }
     
       public List<String> bindingAll(JTable table,
            String[] header) {
        return bindingTable(table, header,
                cDAO.getAll());
    }

    private List<String> bindingTable(JTable table, String[] header, List<Object> datas) {
        List<String> dataJenis = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        Customer cus;
        for (Object data : datas) {
            cus = (Customer) data;
            
            //dataJenis.add(cus.getJenisKelamin());
             dataJenis.add(" - ;" + cus.getJenisKelamin()
                        );
                        
            Object[] data1 = {
                cus.getNoIdentitas(),
                cus.getNama(),
                cus.getJenisKelamin(),
                cus.getNoTelp(),
                cus.getPekerjaan(),
                cus.getAlamat()

            };
            model.addRow(data1);
        }
        table.setModel(model);
        return dataJenis;
    }
    

}
