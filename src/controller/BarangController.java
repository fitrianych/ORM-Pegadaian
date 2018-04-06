/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BarangDAO;
import dao.Jenis_BarangDAO;
import entities.Barang;
import entities.JenisBarang;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class BarangController {
     private final BarangDAO bDAO;
    private final Jenis_BarangDAO jDAO;
    
    public BarangController() {
        this.bDAO = new BarangDAO();
        this.jDAO = new Jenis_BarangDAO();
    }
    
     public void bindingAll(JTable table,
            String[] header) {
        bindingTable(table, header,
                bDAO.getAll());
    }
     
     private void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int i = 1;
        for (Object data : datas) {
            Barang barang = (Barang) data;
            String jns = "";
            if (barang.getIdBarang()!= null) {
                jns = barang.getIdJenis().getNamaJenis()+ " ";
            }
            Object[] data1 = {
                i++,
                barang.getIdBarang(),
                barang.getNamaBarang(),
                jns,
                barang.getIdJenis().getNamaJenis()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
     
       public void loadJenis(JComboBox jComboBox) {
        jDAO.getAll().stream().map((object) -> (JenisBarang) object).forEachOrdered((jenis) -> {
            jComboBox.addItem(jenis.getIdJenis()+" - "
                    +jenis.getNamaJenis()+" " );
        });
    }
       
       public void bindingSearch(JTable table, String[]header, String category, String search){
        bindingTable(table, header, bDAO.search(category, search));
    }
}
