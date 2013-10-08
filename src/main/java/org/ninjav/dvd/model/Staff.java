package org.ninjav.dvd.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: apickard
 * Date: 10/7/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Staff {
    private int staffId;

    @javax.persistence.Column(name = "staff_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    private String firstName;

    @javax.persistence.Column(name = "first_name", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    @javax.persistence.Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    @Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String email;

    @javax.persistence.Column(name = "email", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private short storeId;

    @javax.persistence.Column(name = "store_id", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getStoreId() {
        return storeId;
    }

    public void setStoreId(short storeId) {
        this.storeId = storeId;
    }

    private boolean active;

    @javax.persistence.Column(name = "active", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Basic
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private String username;

    @javax.persistence.Column(name = "username", nullable = false, insertable = true, updatable = true, length = 16, precision = 0)
    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    @javax.persistence.Column(name = "password", nullable = true, insertable = true, updatable = true, length = 40, precision = 0)
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Timestamp lastUpdate;

    @javax.persistence.Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 29, precision = 6)
    @Basic
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    private byte[] picture;

    @javax.persistence.Column(name = "picture", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    @Basic
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (active != staff.active) return false;
        if (staffId != staff.staffId) return false;
        if (storeId != staff.storeId) return false;
        if (email != null ? !email.equals(staff.email) : staff.email != null) return false;
        if (firstName != null ? !firstName.equals(staff.firstName) : staff.firstName != null) return false;
        if (lastName != null ? !lastName.equals(staff.lastName) : staff.lastName != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(staff.lastUpdate) : staff.lastUpdate != null) return false;
        if (password != null ? !password.equals(staff.password) : staff.password != null) return false;
        if (!Arrays.equals(picture, staff.picture)) return false;
        if (username != null ? !username.equals(staff.username) : staff.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) storeId;
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        result = 31 * result + (picture != null ? Arrays.hashCode(picture) : 0);
        return result;
    }

    private Collection<Payment> paymentsByStaffId;

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<Payment> getPaymentsByStaffId() {
        return paymentsByStaffId;
    }

    public void setPaymentsByStaffId(Collection<Payment> paymentsByStaffId) {
        this.paymentsByStaffId = paymentsByStaffId;
    }

    private Collection<Rental> rentalsByStaffId;

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<Rental> getRentalsByStaffId() {
        return rentalsByStaffId;
    }

    public void setRentalsByStaffId(Collection<Rental> rentalsByStaffId) {
        this.rentalsByStaffId = rentalsByStaffId;
    }

    private Address addressByAddressId;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    private Collection<Store> storesByStaffId;

    @OneToMany(mappedBy = "staffByManagerStaffId")
    public Collection<Store> getStoresByStaffId() {
        return storesByStaffId;
    }

    public void setStoresByStaffId(Collection<Store> storesByStaffId) {
        this.storesByStaffId = storesByStaffId;
    }
}
