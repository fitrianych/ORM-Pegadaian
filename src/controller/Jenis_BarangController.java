/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Jenis_BarangDAO;
import entities.JenisBarang;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class Jenis_BarangController {
    private final Jenis_BarangDAO jnDAO;
    
    public Jenis_BarangController() {
        this.jnDAO = new Jenis_BarangDAO();
        
    }
    
    public void bindingAll(JTable table,
            String[] header) {
        bindingTable(table, header,
                jnDAO.getAll());
    }

    private void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel m = new DefaultTableModel(header, 0);
        JenisBarang jen;
        for (Object data : datas) {
            jen = (JenisBarang) data;
            Object[] data1 = {
                jen.getIdJenis(),
                jen.getNamaJenis(),
            };
            m.addRow(data1);
        }
        table.setModel(m);
    }
    
     public void bindingSearch(JTable table, String[]header, String category, String search){
        bindingTable(table, header, jnDAO.search(category, search));
    }
     
     public boolean update(Short id_jenis, String nama_jenis)
    {
        JenisBarang b = new JenisBarang(id_jenis, nama_jenis);
        return jnDAO.update(b);
    }
     
     public boolean delete(Short id) {
        return jnDAO.delete(id);
    }
}

