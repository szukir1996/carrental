package exception;

public class LicenseplateException extends Exception {
    
    public LicenseplateException(){
    }
    
    public LicenseplateException(String message){
        super("LicenseplateException");
    }
}
