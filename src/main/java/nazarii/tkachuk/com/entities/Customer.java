package nazarii.tkachuk.com.entities;

import java.util.Objects;

public class Customer extends Person /*implements CSVSerializable8*/ {
    private String phoneNumber;
    private String email;

    public Customer() {
    }

    public Customer(Integer id) {
        super(id);
    }

    public Customer(String name, String lastName, String phoneNumber) {
        super(null, name, lastName);
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String lastName, String phoneNumber, String email) {
        super(null, name, lastName);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Customer(Integer id, String name, String lastName, String phoneNumber) {
        super(id, name, lastName);
        this.phoneNumber = phoneNumber;
    }

    public Customer(Integer id, String name, String lastName, String phoneNumber, String email) {
        super(id, name, lastName);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID = " + id +
                ", First name = '" + name + '\'' +
                ", Last name = '" + lastName + '\'' +
                ", Phone number = +380" + phoneNumber +
                ", email = " + email +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return phoneNumber.equals(customer.phoneNumber) &&
                email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber, email);
    }
    //    @Override
//    public String toCSVFormattedString() {
//        return String.format(CSVFormats.CUSTOMER.getFormatValue(), id+",", name +",", lastName+",",  phoneNumber);
//    }
//
//    @Override
//    public String toCSVString() {
//        return id + "," + name + "," + lastName + "," +  phoneNumber+"\n";
//    }
}
