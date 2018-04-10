/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BarangDAO;
import dao.GadaiDAO;
import dao.StatusDAO;
import entities.Barang;
import entities.Customer;
import entities.Gadai;
import entities.Status;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    //private final BarangDAO bDAO;

    public GadaiController() {
        this.gDAO = new GadaiDAO();
        this.sDAO = new StatusDAO();
        //this.bDAO = new BarangDAO();
    }

//   public void bindingAll(JTable table,
//            String[] header) {
//        bindingTable(table, header,
//                gDAO.getAll());
//    }
    public List<String> bindingAll(JTable table,
            String[] header) {
        return bindingTable(table, header,
                gDAO.getAll());
    }

    public void bindingSearch(JTable table, String[] header, String category, String search) {
        bindingTable(table, header, gDAO.search(category, search));
    }

//    private void bindingTable(JTable table, String[] header, List<Object> search) {
//        DefaultTableModel m = new DefaultTableModel(header, 0);
//        Gadai gad;
//        for (Object data : search) {
//            gad = (Gadai) data;
//            Object[] data1 = {
//                gad.getIdGadai(),
//                gad.getNoIdentitas(),
//                gad.getTanggalPengajuan(),
//                gad.getJatuhTempo(),
//                gad.getJumlahPinjaman(),
//            //    gad.getSisa(),
//                gad.getIdStatus().getStatus()
//            };
//            m.addRow(data1);
//        }
//        table.setModel(m);
//    }
    private List<String> bindingTable(JTable table, String[] header, List<Object> datas) {
        List<String> dataStatus = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        //int i = 1;
        for (Object data : datas) {
            Gadai gad = (Gadai) data;

            dataStatus.add(" - ;" + gad.getIdStatus().getIdStatus()
                    + " - " + gad.getIdStatus().getStatus());

            Object[] data1 = {
                //i++,
                gad.getIdGadai(),
                gad.getNoIdentitas(),
                gad.getTanggalPengajuan(),
                gad.getJatuhTempo(),
                gad.getJumlahPinjaman(),
                gad.getIdStatus().getStatus()
                    
            };
            model.addRow(data1);
        }
        table.setModel(model);
        return dataStatus;
    }

    public boolean save(String idGadai, String tanggalPengajuan,
            String jatuhTempo, String jumlahPinjaman, String noIdentitas, String idStatus, boolean isSave) {

        Gadai gadai = new Gadai();
        gadai.setIdGadai(Integer.parseInt(idGadai));
        gadai.setTanggalPengajuan(new java.sql.Date(new Long(tanggalPengajuan)));
        gadai.setJatuhTempo(new java.sql.Date(new Long(jatuhTempo)));
        gadai.setJumlahPinjaman(Integer.parseInt(jumlahPinjaman));
        gadai.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));

        //gadai.setIdBarang(new Barang(Short.valueOf(idBarang)));
        //gadai.setIdStatus(new Status(idStatus));
        //String[] bId = idBarang.split(" ");
        //gadai.setIdBarang((Barang) bDAO.getById(bId[0]));
        //String[] jId = idStatus.split(" ");
        gadai.setIdStatus(new Status("b"));

        // gadai.setSisa(Integer.parseInt(sisa));
        if (isSave) {
            return gDAO.insert(gadai);
        }
        return gDAO.update(gadai);
    }
    
     public boolean save(String idGadai, String tanggalPengajuan, String jatuhTempo, String jumlahPinjaman, String noIdentitas, boolean isSave) {
        Gadai gadai = new Gadai();
        gadai.setIdGadai(Integer.parseInt(idGadai));
        gadai.setTanggalPengajuan(new java.sql.Date(new Long(tanggalPengajuan)));
        gadai.setJatuhTempo(new java.sql.Date(new Long(jatuhTempo)));
        gadai.setJumlahPinjaman(Integer.parseInt(jumlahPinjaman));
        gadai.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));

        //gadai.setIdBarang(new Barang(Short.valueOf(idBarang)));
        //gadai.setIdStatus(new Status(idStatus));
        //String[] bId = idBarang.split(" ");
        //gadai.setIdBarang((Barang) bDAO.getById(bId[0]));
        //String[] jId = idStatus.split(" ");
        gadai.setIdStatus(new Status("b"));

        // gadai.setSisa(Integer.parseInt(sisa));
        if (isSave) {
            return gDAO.insert(gadai);
        }
        return gDAO.update(gadai);
     
     }

    public boolean insert(String id_gadai, String tanggal_pengajuan, String jatuh_tempo, String jumlah_pinjaman, String noIdentitas, String id_status) {
        Gadai gadd = new Gadai();
        gadd.setIdGadai(Integer.parseInt(id_gadai));
        gadd.setTanggalPengajuan(new java.sql.Date(new Long(tanggal_pengajuan)));
        gadd.setJatuhTempo(new java.sql.Date(new Long(jatuh_tempo)));
        gadd.setJumlahPinjaman(Integer.parseInt(jumlah_pinjaman));
        gadd.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));
        //gadd.setIdBarang(new Barang(Short.parseShort(id_barang)));
        gadd.setIdStatus(new Status(id_status));

        return gDAO.insert(gadd);

    }

    public boolean update(String id_gadai, String tanggal_pengajuan, String jatuh_tempo, String jumlah_pinjaman, String noIdentitas, String id_status) {

        Gadai gadd = new Gadai();
        gadd.setIdGadai(Integer.parseInt(id_gadai));
        gadd.setTanggalPengajuan(new java.sql.Date(new Long(tanggal_pengajuan)));
        gadd.setJatuhTempo(new java.sql.Date(new Long(jatuh_tempo)));
        gadd.setJumlahPinjaman(Integer.parseInt(jumlah_pinjaman));
        gadd.setNoIdentitas(new Customer(Integer.parseInt(noIdentitas)));
        //gadd.setIdBarang(new Barang(Short.parseShort(id_barang)));
        gadd.setIdStatus(new Status(id_status));

        return gDAO.insert(gadd);
    }
    
     public boolean update(String id_gadai, String id_status) {

        Gadai gadd = (Gadai) gDAO.getById(id_gadai);
        gadd.setIdStatus(new Status(id_status));

        return gDAO.insert(gadd);
    }

//      public void loadStatus(JComboBox jComboBox) {
//        sDAO.getAll().stream().map((object) -> (Status) object).forEachOrdered((status) -> {
//            jComboBox.addItem(status.getIdStatus()+" - "
//                    +status.getStatus());
//        });
//    }
    public List<String> loadStatus(JComboBox jComboBox) {
        //jComboBox.addItem(" - ");

        List<String> datas = new ArrayList<>();
        jComboBox.addItem(" - ");
        sDAO.getAll().stream().map((object) -> (Status) object).forEachOrdered((status) -> {

            String isi = status.getIdStatus() + " - " + status.getStatus();
            jComboBox.addItem(isi);
            datas.add(isi);
        });
        return datas;
    }

    public boolean delete(String id) {
        return gDAO.delete(id);
    }
    
    public boolean cek(String id){
        Gadai gadai = (Gadai) gDAO.getById(id);
        if (gadai.getJumlahPinjaman() == 0) {
            System.out.println("LUNAS");
            
            //return gDAO.update(gadai);
            //System.out.println(gadai.getIdStatus().equals("a"));
            return true;
        }
        else
        {
            System.out.println("BELUM LUNAS");
            return false;
            //return gDAO.update(gadai);
        }
        
    }

   

    
}
