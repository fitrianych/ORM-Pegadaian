/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GadaiDAO;
import dao.StatusDAO;
import entities.Customer;
import entities.Gadai;
import entities.Status;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class GadaiController {
    private final GadaiDAO gDAO;
    private final StatusDAO sDAO;
    
    public GadaiController() {
        this.gDAO = new GadaiDAO();
        this.sDAO = new StatusDAO();
    }

    
    
   public void bindingAll(JTable table,
            String[] header) {
        bindingTable(table, header,
                gDAO.getAll());
    }

//    private void BindingTabel(JTable table, String[] header, List<Object> datas) {
//        DefaultTableModel model = new DefaultTableModel(header, 0);
//        for (Object data : datas) {
//            Gadai gad = (Gadai) data;
//            Object[] data1 = {
//                gad.getIdGadai(),
//                gad.getNoIdentitas(),
//                gad.getTanggalPengajuan(),
//                gad.getJatuhTempo(),
//                gad.getJumlahPinjaman(),
//                gad.getIdStatus().getStatus()
//            };
//            model.addRow(data1);
//        }
//        table.setModel(model);
//    }
    
    public void bindingSearch(JTable table, String[]header, String category, String search){
        bindingTable(table, header, gDAO.search(category, search));
    }

    private void bindingTable(JTable table, String[] header, List<Object> search) {
        DefaultTableModel m = new DefaultTableModel(header, 0);
        Gadai gad;
        for (Object data : search) {
            gad = (Gadai) data;
            Object[] data1 = {
                gad.getIdGadai(),
                gad.getNoIdentitas(),
                gad.getTanggalPengajuan(),
                gad.getJatuhTempo(),
                gad.getJumlahPinjaman(),
                gad.getIdStatus().getStatus()
            };
            m.addRow(data1);
        }
        table.setModel(m);
    }

//    public void bindingSearch(JTable tblGadai, String[] header, String text) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
      public boolean save(String idGadai,  String tanggalPengajuan, 
              String jatuhTempo,String jumlahPinjaman,String noIdentitas, String idStatus,boolean isSave){
          
       Gadai gadai = new Gadai();
       gadai.setIdGadai(Integer.parseInt(idGadai));
       gadai.setTanggalPengajuan(new java.sql.Date(new Long(tanggalPengajuan)));
       gadai.setJatuhTempo(new java.sql.Date(new Long(jatuhTempo)));
       gadai.setJumlahPinjaman(Integer.parseInt(jumlahPinjaman));
       gadai.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));
       gadai.setIdStatus(new Status(idStatus));
       
        String[] jId = idStatus.split(" ");
        gadai.setIdStatus((Status) sDAO.getById(jId[0]));
        if (isSave)return gDAO.insert(gadai);
        return gDAO.update(gadai);
    }
    
       public boolean insert(String id_gadai,String tanggal_pengajuan,String jatuh_tempo,String jumlah_pinjaman,String noIdentitas,String id_status)
    {
        Gadai gadd = new Gadai();
        gadd.setIdGadai(Integer.parseInt(id_gadai));
        gadd.setTanggalPengajuan(new java.sql.Date(new Long(tanggal_pengajuan)));
        gadd.setJatuhTempo(new java.sql.Date(new Long(jatuh_tempo)));
        gadd.setJumlahPinjaman(Integer.parseInt(jumlah_pinjaman));
        gadd.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));
        gadd.setIdStatus(new Status(id_status));
        
        return gDAO.insert(gadd);
        
    }
    
     
     public boolean update(String id_gadai,String tanggal_pengajuan,String jatuh_tempo,String jumlah_pinjaman,String noIdentitas,String id_status)
    {
        
        Gadai gadd = new Gadai();
        gadd.setIdGadai(Integer.parseInt(id_gadai));
        gadd.setTanggalPengajuan(new java.sql.Date(new Long(tanggal_pengajuan)));
        gadd.setJatuhTempo(new java.sql.Date(new Long(jatuh_tempo)));
        gadd.setJumlahPinjaman(Integer.parseInt(jumlah_pinjaman));
        gadd.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));
        gadd.setIdStatus(new Status(id_status));
        
        return gDAO.insert(gadd);
    }
    
      
      public void loadStatus(JComboBox jComboBox) {
        sDAO.getAll().stream().map((object) -> (Status) object).forEachOrdered((status) -> {
            jComboBox.addItem(status.getIdStatus()+" - "
                    +status.getStatus());
        });
    }
      
      public boolean delete(String id) {
        return gDAO.delete(id);
    }
      
    
}
