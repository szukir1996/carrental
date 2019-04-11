package model;

import database.ConnectionFactory;
import entity.Car;
import exception.InvalidInputException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public final class CarTableModel extends AbstractTableModel{
    private final ArrayList<Car> cars;
    
    public CarTableModel(){
        cars = new ArrayList<>();
        LoadTable();
    }

    public void LoadTable(){
        cars.clear();
        String query = "SELECT * FROM cars";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    int id = rs.getInt(1);
                    String licensePlate = rs.getString(2);
                    String brand = rs.getString(3);
                    String type = rs.getString(4);
                    int yearOfManufacture = rs.getInt(5);
                    String dailyFee = rs.getString(6);
                    String lastService = rs.getString(7);
                    boolean inService = rs.getBoolean(8);
                    
                    cars.add(new Car(id, licensePlate, brand, type, yearOfManufacture, dailyFee, lastService, inService));
                    
                }             
            }
            conn.close();
        } catch (InvalidInputException | ClassNotFoundException | SQLException ex) {
            System.err.println(ex.toString());
        }    
        
        fireTableDataChanged();
    }
    
    public boolean checkCar(String thatLicensePlate){
        ArrayList<String> licensePlates = new ArrayList<>();
        String query = "SELECT platenumber FROM cars";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    String thisLicensePlate = rs.getString(1);
                    licensePlates.add(thisLicensePlate);
                }             
            }
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
        
        for(String plate : licensePlates){
            if(thatLicensePlate.equals(plate)){
                return false;
            }
        }
        return true;
    }
    
    public void editCar(String id, String temp , String temp2, int temp3){
        String query = "UPDATE cars SET dailyfee = '" + temp + "', lastservicedate = '" + temp2 + "', inservice = '" + temp3 + "' WHERE id = '" + id +"'";
                try {
                    Connection conn = ConnectionFactory.getConnection();
                    try (Statement stmt = conn.createStatement()) {
                        int rs = stmt.executeUpdate(query);
                    }
                    conn.close();
                } catch (Exception ex) {
                    System.err.println(ex.toString());
                }
    }
    
    @Override
    public int getRowCount() {
        return cars.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int i) {
        String colNames[] = new String[]{"ID","Rendszám", "Márka", "Típus", "Gyártási év", "Napidíj", "Utolsó szerviz", "Szervizben"};
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
        return cars.get(row-1).getID();
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0: return cars.get(row).getID();
            case 1: return cars.get(row).getLicensePlate();
            case 2: return cars.get(row).getBrand();
            case 3: return cars.get(row).getType();
            case 4: return cars.get(row).getYearOfManufacture();
            case 5: return cars.get(row).getDailyFee();
            case 6: return cars.get(row).getLastService();
            case 7: return cars.get(row).isInService();
            default: return null;
        }        
    }

    @Override
    public void setValueAt(Object o, int row, int column) {}
}
