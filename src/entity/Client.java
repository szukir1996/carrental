package entity;

import exception.InvalidInputException;
import java.sql.Connection;
import java.sql.Statement;
import database.ConnectionFactory;

public class Client {
    private int    ID;
    private String name;
    private String address;
    private String phoneNumber;

    public Client(int ID, String name, String address, String phoneNumber) throws InvalidInputException {
        if(isNumeric(phoneNumber) && !phoneNumber.isEmpty() && !address.isEmpty() && !name.isEmpty()){
            this.ID = ID;
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }else{
            throw new InvalidInputException();
        }
        
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.ID;
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
        final Client other = (Client) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }

    public boolean addClient() {
        String cmd = "INSERT INTO clients (name,address,phonenumber) VALUES('" + name + "','" + address + "','" + phoneNumber + "')";
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
    
    public String getAllClient(){
        String cmd = "SELECT * FROM clients";
        return cmd;
    }
}
