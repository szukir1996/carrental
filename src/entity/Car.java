package entity;

import exception.InvalidInputException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;
import database.ConnectionFactory;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
       
    private int id;
    private String licensePlate;
    private String brand;
    private String type;
    private int yearOfManufacture;
    private String dailyFee;
    private String lastService;
    private int inService;
    private boolean rented = false;

    public Car(int id, String licensePlate, String brand, String type, int yearOfManufacture, String dailyFee, String lastService, boolean inService)
    throws InvalidInputException{
        Pattern p = Pattern.compile("[A-Z][A-Z][A-Z][-][1-9][1-9][1-9]");
        Matcher m = p.matcher(licensePlate);
        boolean a = m.matches();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if(!licensePlate.isEmpty()&& a && 
           !brand.isEmpty() && 
           !type.isEmpty() && 
           yearOfManufacture<=year && yearOfManufacture > 1886 &&
           !dailyFee.isEmpty() && Integer.parseInt(dailyFee)>=0 &&
           !lastService.isEmpty()){
            this.id = id;
            this.licensePlate = licensePlate;
            this.brand = brand;
            this.type = type;
            this.yearOfManufacture = yearOfManufacture;
            this.dailyFee = dailyFee;
            this.lastService = lastService;
            if(inService){
                this.inService = 1;
            }else{
                this.inService = 0;
            }
        }else{
            throw new InvalidInputException();
        }
    }
    
    public int getID(){
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getDailyFee() {
        return dailyFee;
    }

    public String getLastService() {
        return lastService;
    }

    public int isInService() {
        return inService;
    }
    
    public boolean getRented(){
        return rented;
    }
    
    public void setRented(boolean rented){
        this.rented = rented;
    }
    
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
        int d = Integer.parseInt(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.licensePlate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.licensePlate, other.licensePlate)) {
            return false;
        }
        return true;
    }
    
    public boolean addCar() {
        String cmd = "INSERT INTO cars (platenumber,brand,type,yom,dailyfee,lastservicedate,inservice) "
                + "VALUES('" + licensePlate + "','" + brand + "','" + type + "','" + yearOfManufacture + "','" + dailyFee + "','" + lastService + "','" + inService + "')";
        try {
            Connection conn = ConnectionFactory.getConnection();
            try (Statement stmt = conn.createStatement()) {
                return stmt.execute(cmd);
            }
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }         
        return false;
    }
}
