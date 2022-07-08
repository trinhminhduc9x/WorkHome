package Ontap.baitap1.model;

public class GenuinePhone extends Phone {
    //thời gian bảo hành, phạm vi bảo hành (trong nước hoặc quốc tế).
    private String timePhone;
    private String coveragePhone;

    public GenuinePhone() {
    }


    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.timePhone + "," + this.coveragePhone;
    }

    public GenuinePhone(String timePhone, String coveragePhone) {
        this.timePhone = timePhone;
        this.coveragePhone = coveragePhone;
    }

    public GenuinePhone(String idPhone, String namePhone, String costPhone, String numberPhone, String producerPhone, String timePhone, String coveragePhone) {
        super(idPhone, namePhone, costPhone, numberPhone, producerPhone);
        this.timePhone = timePhone;
        this.coveragePhone = coveragePhone;
    }

    public String getTimePhone() {
        return timePhone;
    }

    public void setTimePhone(String timePhone) {
        this.timePhone = timePhone;
    }

    public String getCoveragePhone() {
        return coveragePhone;
    }

    public void setCoveragePhone(String coveragePhone) {
        this.coveragePhone = coveragePhone;
    }

    @Override
    public String toString() {
        return "GenuinePhone{" +
                super.toString() +
                "timePhone='" + timePhone + '\'' +
                ", coveragePhone='" + coveragePhone + '\'' +
                '}';
    }
}
