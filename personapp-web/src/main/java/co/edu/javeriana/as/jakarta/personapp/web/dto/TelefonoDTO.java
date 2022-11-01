package co.edu.javeriana.as.jakarta.personapp.web.dto;

import java.io.Serializable;

public class TelefonoDTO implements Serializable{
    private String num;
    private String oper;

    public TelefonoDTO() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
}
