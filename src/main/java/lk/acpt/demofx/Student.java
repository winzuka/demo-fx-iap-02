package lk.acpt.demofx;

public class Student {

    private String address;
    private String name;
    private String nic;
    private String mobileNo;

    public Student(String address, String name, String nic, String mobileNo) {
        this.address = address;
        this.name = name;
        this.nic = nic;
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
