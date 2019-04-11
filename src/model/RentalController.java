package model;

import database.ConnectionFactory;
import exception.InvalidInputException;
import static java.lang.Math.abs;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RentalController {
    private int carID;
    private int clientID;
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<String> backDateList = new ArrayList<>();
    ArrayList<String> plateNumberList = new ArrayList<>();
    private String clientName;
    private String plateNumber;
    private int dailyFee;
    private boolean inService;
    private String plannedDate;
    private String startDate;
    
    public RentalController(int clientID, int carID){
        String query = "SELECT name FROM clients WHERE id = '" + clientID + "'";
        String query2 = "SELECT platenumber, inservice, dailyfee FROM cars WHERE id = '" + carID + "'";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    this.clientID = clientID;
                    this.clientName = rs.getString(1);
                }
                rs=stmt.executeQuery(query2);
                while (rs.next()){
                    this.carID = carID;
                    this.plateNumber = rs.getString(1);
                    this.inService = rs.getBoolean(2);
                    this.dailyFee = rs.getInt(3);
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    public RentalController(int clientID, String plateNumber){
        String query = "SELECT name FROM clients WHERE id = '" + clientID + "'";
        String query2 = "SELECT id, platenumber, inservice, dailyfee FROM cars WHERE platenumber = '" + plateNumber + "'";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    this.clientID = clientID;
                    this.clientName = rs.getString(1);
                }
                rs=stmt.executeQuery(query2);
                while (rs.next()){
                    this.carID = rs.getInt(1);
                    this.plateNumber = rs.getString(2);
                    this.inService = rs.getBoolean(3);
                    this.dailyFee = rs.getInt(4);
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    public boolean checkClient(int id){
        idList.clear();
        backDateList.clear();
        String query = "SELECT clientid, backdate FROM rentals WHERE clientid = '" + id + "'";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    idList.add(rs.getInt(1));
                    backDateList.add(rs.getString(2));
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.toString());
        }
        if(idList.isEmpty()) return true;
        for(int i = 0;i<idList.size();i++){
            if(id == idList.get(i)){
                for(int j = 0;j<backDateList.size();j++){
                    if(backDateList.get(i).equals("-")){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean checkCar(String plateNumber){
        plateNumberList.clear();
        backDateList.clear();
        String query = "SELECT platenumber, backdate FROM rentals WHERE platenumber = '" + plateNumber + "'";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    plateNumberList.add(rs.getString(1));
                    backDateList.add(rs.getString(2));
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.toString());
        }
        if(plateNumberList.isEmpty()) return true;
        for(int i = 0;i<plateNumberList.size();i++){
            if(plateNumber.equals(plateNumberList.get(i))){
                for(int j = 0;j<backDateList.size();j++){
                    if(backDateList.get(i).equals("-")){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int calculateFee(int id, String backDate){
        String query = "SELECT rentalstart, rentalend FROM rentals WHERE clientid = '" + id + "' AND backdate = '" + "-" + "'";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    this.startDate = rs.getString(1);
                    this.plannedDate = rs.getString(2);
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.toString());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tempPlannedDate = LocalDate.parse(plannedDate, formatter);
        LocalDate tempBackDate = LocalDate.parse(backDate, formatter);
        LocalDate tempStartDate = LocalDate.parse(startDate, formatter);
        Period periodPlannedBack = Period.between(tempPlannedDate, tempBackDate);
        Period periodStartPlanned = Period.between(tempStartDate, tempPlannedDate);
        int daysPlannedBack = periodPlannedBack.getDays() + 
                              periodPlannedBack.getMonths()*(31 - periodPlannedBack.getDays()) + 
                              periodPlannedBack.getYears()*(365 - periodPlannedBack.getMonths())*(31 - periodPlannedBack.getDays());
        int daysStartPlanned = periodStartPlanned.getDays() +
                               periodStartPlanned.getMonths()*(31 - periodStartPlanned.getDays()) + 
                               periodStartPlanned.getYears()*(365 - periodStartPlanned.getMonths())*(31 - periodStartPlanned.getDays());
        if(daysPlannedBack>0){
            return abs((dailyFee*daysStartPlanned)+(dailyFee*daysPlannedBack*2));
        }else{
            if(daysPlannedBack == 0){
                return abs((dailyFee*daysStartPlanned));
            }else{
                return abs((int) ((int) (dailyFee*(daysStartPlanned+daysPlannedBack))-(dailyFee*daysPlannedBack*0.5)));
            }
        }
    }
    
    public boolean checkEndDate(int id, String backDate) throws InvalidInputException{
        String query = "SELECT rentalstart FROM rentals WHERE clientid = '" + id + "' AND backdate = '" + "-" + "'";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    this.startDate = rs.getString(1);
                }
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.toString());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tempStartDate = LocalDate.parse(startDate, formatter);
        LocalDate tempBackDate = LocalDate.parse(backDate, formatter);
        if(tempStartDate.compareTo(tempBackDate)>0){
            throw new InvalidInputException();
        }else{
            return true;
        }
    }
    
    public int getCarID() {
        return carID;
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
    
    public boolean getInService(){
        return inService;
    }
}
