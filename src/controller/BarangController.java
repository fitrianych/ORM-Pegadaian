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
import java.util.ArrayList;
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
    
     public boolean save(Short idBarang, String namaBarang, String idJenis,boolean isSave){
        Barang barang = new Barang(Short.valueOf(idBarang), namaBarang);
        String[] jId = idJenis.split(" ");
        //String[] lId = LocationId.split(" ");
        barang.setIdJenis((JenisBarang) jDAO.getById(jId[0]));
        //departments.setLocationId((Locations) lDAO.getById(lId[0]));
        if (isSave)return bDAO.insert(barang);
        return bDAO.update(barang);
    }
    
//     public void bindingAll(JTable table,
//            String[] header) {
//        bindingTable(table, header,
//                bDAO.getAll());
//    }
     
      public List<String> bindingAll(JTable table,
            String[] header) {
        return bindingTable(table, header,
                bDAO.getAll());
    }
     
//     private void bindingTable(JTable table, String[] header, List<Object> datas) {
//        DefaultTableModel m = new DefaultTableModel(header, 0);
//        Barang gad;
//        for (Object data : datas) {
//            gad = (Barang) data;
//            Object[] data1 = {
//                gad.getIdBarang(),
//                gad.getNamaBarang(),
//                gad.getIdJenis().getNamaJenis(),
//            };
//            m.addRow(data1);
//        }
//        table.setModel(m);
//    }
     
         private List<String> bindingTable(JTable table, String[] header, List<Object> datas) {
        List<String> dataJenis = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        //int i = 1;
        for (Object data : datas) {
            Barang brg = (Barang) data;        
           
                dataJenis.add(" - ;" + brg.getIdJenis().getIdJenis()
                        + " - " + brg.getIdJenis().getNamaJenis());
            
            Object[] data1 = {
                //i++,
                brg.getIdBarang(),
                brg.getNamaBarang(),
                brg.getIdJenis().getNamaJenis()
            };
            model.addRow(data1);
        }
        table.setModel(model);
        return dataJenis;
    }
     
//       public void loadJenis(JComboBox jComboBox) {
//           //jComboBox.addItem(" - ");
//        jDAO.getAll().stream().map((object) -> (JenisBarang) object).forEachOrdered((jenis) -> {
//            jComboBox.addItem(jenis.getIdJenis()+" - "
//                    +jenis.getNamaJenis()+" " );
//        });
//    }
         
        public List<String> loadJenis(JComboBox jComboBox) {
           //jComboBox.addItem(" - ");
           
            List<String> datas = new ArrayList<>();
           jComboBox.addItem(" - ");
        jDAO.getAll().stream().map((object) -> (JenisBarang) object).forEachOrdered((jenis) -> {
           
       String isi = jenis.getIdJenis()+ " - " + jenis.getNamaJenis(); 
       jComboBox.addItem(isi);
       datas.add(isi);
        });
        return datas;
    }
    
       
       public void bindingSearch(JTable table, String[]header, String category, String search){
        bindingTable(table, header, bDAO.search(category, search));
    }
       
       public boolean delete(Short id) {
        return bDAO.delete(id);
    }
}
