/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AngsuranDAO;
import dao.GadaiDAO;
import entities.Angsuran;
import entities.Customer;
import entities.Gadai;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class AngsuranController {
    private final AngsuranDAO aDAO;
    
    public AngsuranController() {
        this.aDAO = new AngsuranDAO();
    }
    
    public void bindingAll(JTable table,
            String[] header) {
        bindingTable(table, header,
                aDAO.getAll());
    }
    
    private void bindingTable(JTable table, String[] header, List<Object> search) {
        DefaultTableModel m = new DefaultTableModel(header, 0);
        Angsuran ang;
        for (Object data : search) {
            ang = (Angsuran) data;
            Object[] data1 = {
                ang.getIdAngsuran(),
                ang.getNoIdentitas(),
                ang.getNoIdentitas().getNama(),
                ang.getIdGadai(),
                ang.getIdGadai().getTanggalPengajuan(),
                ang.getIdGadai().getJatuhTempo(),
                ang.getTanggalAngsuran(),
                ang.getJumlahAngsuran(),
                ang.getIdGadai().getJumlahPinjaman(),
                ang.getDenda(),
                ang.getTotal()
                
            };
            m.addRow(data1);
        }
        table.setModel(m);
    }
    
    public void bindingSearch(JTable table, String[]header, String category, String search){
        bindingTable(table, header, aDAO.search(category, search));
    }
    
    public boolean save(String idAngsuran,String noIdentitas,String idGadai,String tanggalAngsuran,String jumlahAngsuran,String denda,String total, boolean isSave){
          
       Angsuran an = new Angsuran();
       an.setIdAngsuran(idAngsuran);
       an.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));
       an.setIdGadai(new Gadai(Integer.parseInt(idGadai)));
       an.setTanggalAngsuran(new java.sql.Date(new Long(tanggalAngsuran)));
       an.setJumlahAngsuran(Integer.parseInt(jumlahAngsuran));
       an.setDenda(denda);
       an.setTotal(total);
       //an.setDenda(0);
     
        if (isSave){ return aDAO.insert(an);
//            return new GadaiController().cek(idGadai);
        }
                
        return aDAO.update(an);
        
    }
    
     public boolean delete(String id) {
        return aDAO.delete(id);
    }
//       public boolean update(String id_gadai, Integer denda) {
//
//        Angsuran angg = (Angsuran) aDAO.getById(id_gadai);
//        angg.setDenda(denda);
//
//        return aDAO.insert(angg);
//    }
   
     
}
