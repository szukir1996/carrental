package model;

import database.ConnectionFactory;
import entity.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ClientTableModel extends AbstractTableModel{
    private final ArrayList<Client> clients;
    
    public ClientTableModel(){
        clients = new ArrayList<>();
        LoadTable();
    }

    public void LoadTable(){
        clients.clear();
        String query = "SELECT * FROM clients";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String address = rs.getString(3);
                    String phoneNumber = rs.getString(4);
                    
                    clients.add(new Client(id, name, address, phoneNumber));
                }             
            }
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }    
        
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int i) {
        String colNames[] = new String[]{"ID", "Név", "Lakcím", "Telefonszám"};
        return colNames[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return (i == 0) ? String.class : Integer.class;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    public int getID(int row){
        return clients.get(row-1).getID();
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0: return clients.get(row).getID();
            case 1: return clients.get(row).getName();
            case 2: return clients.get(row).getAddress();
            case 3: return clients.get(row).getPhoneNumber();
            default: return null;
        }        
    }

    @Override
    public void setValueAt(Object o, int row, int column) {}
}