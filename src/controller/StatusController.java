/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StatusDAO;
import entities.Status;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class StatusController {
     private final StatusDAO sDAO;
     
     public StatusController() {
        this.sDAO = new StatusDAO();
    }
      public void bindingAll(JTable table,
            String[] header) {
        bindingTable(table, header,
                sDAO.getAll());
    }

    private void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel m = new DefaultTableModel(header, 0);
        Status st;
        for (Object data : datas) {
            st = (Status) data;
            Object[] data1 = {
                st.getIdStatus(),
                st.getStatus(),
            };
            m.addRow(data1);
        }
        table.setModel(m);
    }
     
             
}
