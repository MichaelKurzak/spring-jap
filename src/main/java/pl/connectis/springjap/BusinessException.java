package pl.connectis.springjap;

import org.hibernate.jdbc.TooManyRowsAffectedException;

import javax.annotation.security.DenyAll;
import java.awt.datatransfer.Transferable;

public class BusinessException {

    public  BusinessException(){
    }
    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Throwable cause){
        super(message, cause);
    }

    public BusinessException (Throwable cause) {
        super(cause);
    }

    public BusinessException (String message, Throwable cause, boolean enbleSupperession, boolean writableStackTrace) {
        super(message, cause, enbleSupperession, writableStackTrace);
    }
}
