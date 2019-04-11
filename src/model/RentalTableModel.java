package model;

import database.ConnectionFactory;
import entity.Rental;
import exception.InvalidInputException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.AbstractTableModel;

public final class RentalTableModel extends AbstractTableModel{
    private final ArrayList<Rental> rentals;
    
    public RentalTableModel(){
        rentals = new ArrayList<>();
        LoadTable(0);
    }

    public void LoadTable(int foo){
        rentals.clear();
        String query = "";
        switch(foo){
            case 0:
               query = "SELECT * FROM rentals";
               break;
            case 1:
               query = "SELECT * FROM rentals WHERE backdate = '" + "-" + "'";
               break;
            case 2:
               query = "SELECT * FROM rentals WHERE backdate != '" + "-" + "'";
               break;
        }
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    int clientID = rs.getInt(1);
                    String clientName = rs.getString(2);
                    int carID = rs.getInt(3);
                    String plateNumber = rs.getString(4);
                    String rentalStart = rs.getString(5);
                    String rentalEnd = rs.getString(6);
                    String backDate = rs.getString(7);
                    int payed = rs.getInt(8);
                    
                    rentals.add(new Rental(clientID, clientName, carID, plateNumber, rentalStart, rentalEnd, backDate, payed));
                }
                conn.close();
            } catch (InvalidInputException ex){
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        fireTableDataChanged();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RentalTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadTable(String filter){
        rentals.clear();
        String query = "";
        Pattern p = Pattern.compile("[A-Z][A-Z][A-Z][-][1-9][1-9][1-9]");
        Matcher m = p.matcher(filter);
        boolean isPlateNumber = m.matches();
        if(isPlateNumber){
            query = "SELECT * FROM rentals WHERE platenumber = '" + filter + "'";
        }else{
            query = "SELECT * FROM rentals WHERE name = '" + filter + "'";
        }
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    int clientID = rs.getInt(1);
                    String clientName = rs.getString(2);
                    int carID = rs.getInt(3);
                    String plateNumber = rs.getString(4);
                    String rentalStart = rs.getString(5);
                    String rentalEnd = rs.getString(6);
                    String backDate = rs.getString(7);
                    int payed = rs.getInt(8);
                    
                    rentals.add(new Rental(clientID, clientName, carID, plateNumber, rentalStart, rentalEnd, backDate, payed));
                }
                conn.close();
            } catch (InvalidInputException ex){
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        fireTableDataChanged();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RentalTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return rentals.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int i) {
        String colNames[] = new String[]{"Üf.az.", "Név", "Rendszám", "Kölcs.kezd.", "Kölcs.terv.vég.", "Vissza.dát.", "Fizetendő"};
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
        return rentals.get(row-1).getClientID();
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0: return rentals.get(row).getClientID();
            case 1: return rentals.get(row).getClientName();
            case 2: return rentals.get(row).getPlateNumber();
            case 3: return rentals.get(row).getRentalStart();
            case 4: return rentals.get(row).getRentalEnd();
            case 5: return rentals.get(row).getBackDate();
            case 6: return rentals.get(row).getPayed();
            default: return null;
        }        
    }

    @Override
    public void setValueAt(Object o, int row, int column) {}
}
