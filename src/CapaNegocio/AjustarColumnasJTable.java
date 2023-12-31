package CapaNegocio;


import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Est.Invitado_04
 */
public class AjustarColumnasJTable {
    public static void ajustarAnchoColumnas(JTable table){
        TableColumnModel columnModel=table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width=0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer=table.getCellRenderer(row, column);
                Component comp=table.prepareRenderer(renderer, row, column);
                width=Math.max(comp.getPreferredSize().width+1,width);
                
            }
            TableColumn tableColumn=columnModel.getColumn(column);
            tableColumn.setPreferredWidth(width);
        }
    }
}
