package Ontap.baitap1.model;

public abstract class  Phone {
    //: ID, Tên điện thoại, Giá bán, Số lượng, Nhà sản xuất.
    private String idPhone;
    private String namePhone;
    private String costPhone;
    private String numberPhone;
    private String producerPhone;

    public Phone() {
    }

    public Phone(String idPhone, String namePhone, String costPhone, String numberPhone, String producerPhone) {
        this.idPhone = idPhone;
        this.namePhone = namePhone;
        this.costPhone = costPhone;
        this.numberPhone = numberPhone;
        this.producerPhone = producerPhone;
    }

    public  String getInfoToCSV() {
        return this.idPhone + "," + this.namePhone + "," + this.costPhone + "," + this.numberPhone+ "," + this.producerPhone ;
    }
    public String getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(String idPhone) {
        this.idPhone = idPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public String getCostPhone() {
        return costPhone;
    }

    public void setCostPhone(String costPhone) {
        this.costPhone = costPhone;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getProducerPhone() {
        return producerPhone;
    }

    public void setProducerPhone(String producerPhone) {
        this.producerPhone = producerPhone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "idPhone='" + idPhone + '\'' +
                ", namePhone='" + namePhone + '\'' +
                ", costPhone='" + costPhone + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", producerPhone='" + producerPhone + '\'' +
                '}';
    }
}
