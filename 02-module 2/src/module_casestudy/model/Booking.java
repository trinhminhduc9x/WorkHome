package module_casestudy.model;

import module_casestudy.model.facility.Facility;
import module_casestudy.model.person.Customer;
import module_casestudy.model.person.Person;

import java.time.LocalDate;

public class Booking extends Person {
    private int idBooking;
    private LocalDate startDay;
    private LocalDate endDay;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(int idBooking, LocalDate startDay, LocalDate endDay, Customer customer, Facility facility) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customer = customer;
        this.facility = facility;
    }

    public Booking(String id, String name, LocalDate dateOfBirth, String gender, String idNumber, String phoneNumber, String email, int idBooking, LocalDate startDay, LocalDate endDay, Customer customer, Facility facility) {
        super(id, name, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customer = customer;
        this.facility = facility;
    }



    public String getInfoToCSV() {
        return this.idBooking + "," + this.startDay + "," + this.endDay + "," + this.customer + "," + this.facility ;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", customer=" + customer +
                ", facility=" + facility +
                '}';
    }
}
