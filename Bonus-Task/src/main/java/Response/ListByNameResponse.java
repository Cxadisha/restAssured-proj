package Response;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

public class ListByNameResponse {

    private int ID;
    private String Name;
    private String SSN;
    private Date DOB;

    public ListByNameResponse(int ID, String name, String SSN, Date DOB) {
        this.ID = ID;
        Name = name;
        this.SSN = SSN;
        this.DOB = DOB;
    }

    public ListByNameResponse() {};

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
}
