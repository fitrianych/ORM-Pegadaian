/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GadaiDAO;
import entities.Customer;
import entities.Gadai;
import entities.Gadai;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class GadaiController {

    public static void bindingSearch(JTable tableGadai, String[] header, String kolom, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public GadaiController() {
        this.gdao = new GadaiDAO();
    }
    public GadaiDAO gdao;

    public void BindingAll(JTable table, String[] header) {
        BindingTabel(table, header, gdao.getAll());
    
}

     private void BindingTabel(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            Gadai gad = (Gadai) data;
            Object[] data1 = {
                gad.getIdGadai(),
                gad.getJatuhTempo(),
                gad.getJumlahPinjaman(),
                gad.getIdStatus(),
                gad.getNoIdentitas(),
                
            };
            model.addRow(data1);
        }
        table.setModel(model);
}
      public boolean insert(String id_gadai, String jatuh_tempo, long Jumlah_pinjaman, String Status, BigDecimal No_Identitas ) {
        Gadai d = new Gadai();
        d.setIdGadai(id_gadai);
       d.setJatuhTempo(new java.sql.Date(new Long(jatuh_tempo)));
        d.setJumlahPinjaman(Jumlah_pinjaman);
        d.setIdStatus(Status);
        //d.setNoIdentitas(new BigDecimal(No_Identitas));
       
       return gdao.insert(d);
      }

    public boolean update(int parseInt, String string, Long aLong, String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 //To change body of generated methods, choose Tools | Templates.
    
}