package entity;

import database.ConnectionFactory;
import exception.InvalidInputException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Rental {
    private int carID;
    private int clientID;
    private String clientName;
    private String plateNumber;
    private String rentalStart;
    private String rentalEnd;
    private String backDate;
    private int payed;

    public Rental(int clientID, String clientName, int carID , String plateNumber, String rentalStart, String rentalEnd, String backDate, int payed)
    throws InvalidInputException{
        if(!rentalEnd.isEmpty()){
            this.clientID = clientID;
            this.clientName = clientName;
            this.carID = carID;
            this.plateNumber = plateNumber;
            this.rentalStart = rentalStart;
            this.rentalEnd = rentalEnd;
            this.backDate = backDate;
            this.payed = payed;
        }else{
            throw new InvalidInputException();
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

    public String getRentalStart() {
        return rentalStart;
    }

    public String getRentalEnd() {
        return rentalEnd;
    }

    public String getBackDate() {
        return backDate;
    }

    public int getPayed() {
        return payed;
    }
    
    public void addRental(){
        String cmd = "INSERT INTO rentals (clientid,name,carid,platenumber,rentalstart,rentalend,backdate,payed) "
                + "VALUES('" + clientID + "','" + clientName + "','" + carID + "','" + plateNumber + "','" + rentalStart + "','" + rentalEnd + "','" + backDate + "','" + payed + "')";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(cmd);
            }
        } catch (ClassNotFoundException | SQLException ex){
        }
    }
    
}
