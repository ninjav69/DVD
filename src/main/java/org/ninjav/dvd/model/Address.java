package org.ninjav.dvd.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: apickard
 * Date: 10/7/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Address {
    private int addressId;

    @javax.persistence.Column(name = "address_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    private String address;

    @javax.persistence.Column(name = "address", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address2;

    @javax.persistence.Column(name = "address2", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    private String district;

    @javax.persistence.Column(name = "district", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    private String postalCode;

    @javax.persistence.Column(name = "postal_code", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String phone;

    @javax.persistence.Column(name = "phone", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address1 = (Address) o;

        if (addressId != address1.addressId) return false;
        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (address2 != null ? !address2.equals(address1.address2) : address1.address2 != null) return false;
        if (district != null ? !district.equals(address1.district) : address1.district != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(address1.lastUpdate) : address1.lastUpdate != null) return false;
        if (phone != null ? !phone.equals(address1.phone) : address1.phone != null) return false;
        if (postalCode != null ? !postalCode.equals(address1.postalCode) : address1.postalCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    private City cityByCityId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "city_id", referencedColumnName = "city_id", nullable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    private Collection<Customer> customersByAddressId;

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Customer> getCustomersByAddressId() {
        return customersByAddressId;
    }

    public void setCustomersByAddressId(Collection<Customer> customersByAddressId) {
        this.customersByAddressId = customersByAddressId;
    }

    private Collection<Staff> staffsByAddressId;

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Staff> getStaffsByAddressId() {
        return staffsByAddressId;
    }

    public void setStaffsByAddressId(Collection<Staff> staffsByAddressId) {
        this.staffsByAddressId = staffsByAddressId;
    }

    private Collection<Store> storesByAddressId;

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Store> getStoresByAddressId() {
        return storesByAddressId;
    }

    public void setStoresByAddressId(Collection<Store> storesByAddressId) {
        this.storesByAddressId = storesByAddressId;
    }
}
