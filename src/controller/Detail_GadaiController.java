/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BarangDAO;
import dao.Detail_GadaiDAO;
import entities.Barang;
import entities.DetailGadai;
import entities.Gadai;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class Detail_GadaiController {
     private final Detail_GadaiDAO dDAO;
     private final BarangDAO bDAO;
     
      public Detail_GadaiController() {
        this.dDAO = new Detail_GadaiDAO();
        this.bDAO = new BarangDAO();
    }
      
       public void bindingAll(JTable table,
            String[] header) {
        bindingTable(table, header,
                dDAO.getAll());
    }

    private void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        DetailGadai cus;
        for (Object data : datas) {
            cus = (DetailGadai) data;
            Object[] data1 = {
                cus.getIdDetailGadai(),
                cus.getIdGadai(),
                cus.getIdBarang().getNamaBarang(),
                cus.getKeterangan(),
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
    
    public void bindingSearch(JTable table, String[]header, String category, String search){
        bindingTable(table, header, dDAO.search(category, search));
    }
    
      public boolean save(String idDetailGadai, String idGadai, String idBarang, String keterangan,boolean isSave){
        DetailGadai dg = new DetailGadai
        (Integer.parseInt(idDetailGadai), keterangan);
        String[] bId = idBarang.split(" ");
        //String[] lId = LocationId.split(" ");
        dg.setIdGadai(new Gadai(Integer.parseInt(idGadai)));
        dg.setIdBarang((Barang) bDAO.getById(bId[0]));
        //departments.setLocationId((Locations) lDAO.getById(lId[0]));
        if (isSave)return bDAO.insert(dg);
        return bDAO.update(dg);
    }
      
        public void loadBarang(JComboBox jComboBox) {
        bDAO.getAll().stream().map((object) -> (Barang) object).forEachOrdered((barang) -> {
            jComboBox.addItem(barang.getIdBarang()+" - "
                    +barang.getNamaBarang()+" " );
        });
    }
        public boolean delete(String id) {
        return dDAO.delete(id);
    }
}
