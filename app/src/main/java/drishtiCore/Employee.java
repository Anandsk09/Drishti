package drishtiCore;

public class Employee {
    private String id;
    private String name;
    private String laptopSerialNumber;
    private String emailId;
    private String location;

    public Employee() {
    }

    public Employee(String id, String name, String laptopSerialNumber, String emailId, String location) {
        this.id = id;
        this.name = name;
        this.laptopSerialNumber = laptopSerialNumber;
        this.emailId = emailId;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLaptopSerialNumber() {
        return laptopSerialNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLaptopSerialNumber(String laptopSerialNumber) {
        this.laptopSerialNumber = laptopSerialNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
