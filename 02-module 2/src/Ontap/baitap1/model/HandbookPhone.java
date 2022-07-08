package Ontap.baitap1.model;

public class HandbookPhone extends Phone {
    private String portablePhone;
    private String statusPhone;

    public HandbookPhone() {
    }

    public HandbookPhone(String portablePhone, String statusPhone) {
        this.portablePhone = portablePhone;
        this.statusPhone = statusPhone;
    }

    public HandbookPhone(String idPhone, String namePhone, String costPhone, String numberPhone, String producerPhone, String portablePhone, String statusPhone) {
        super(idPhone, namePhone, costPhone, numberPhone, producerPhone);
        this.portablePhone = portablePhone;
        this.statusPhone = statusPhone;
    }

    public String getInfoToCSV() {
        return super.getInfoToCSV()+  "," + this.portablePhone + "," + this.statusPhone;
    }
    public String getPortablePhone() {
        return portablePhone;
    }

    public void setPortablePhone(String portablePhone) {
        this.portablePhone = portablePhone;
    }

    public String getStatusPhone() {
        return statusPhone;
    }

    public void setStatusPhone(String statusPhone) {
        this.statusPhone = statusPhone;
    }

    @Override
    public String toString() {
        return "HandbookPhone{" +
                "portablePhone='" + portablePhone + '\'' +
                ", statusPhone='" + statusPhone + '\'' +
                '}';
    }
}
