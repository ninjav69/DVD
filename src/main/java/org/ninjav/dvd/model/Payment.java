package org.ninjav.dvd.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: apickard
 * Date: 10/7/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Payment {
    private int paymentId;

    @javax.persistence.Column(name = "payment_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    private BigDecimal amount;

    @javax.persistence.Column(name = "amount", nullable = false, insertable = true, updatable = true, length = 5, precision = 2)
    @Basic
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private Timestamp paymentDate;

    @javax.persistence.Column(name = "payment_date", nullable = false, insertable = true, updatable = true, length = 29, precision = 6)
    @Basic
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (paymentId != payment.paymentId) return false;
        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
        if (paymentDate != null ? !paymentDate.equals(payment.paymentDate) : payment.paymentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        return result;
    }

    private Customer customerByCustomerId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    private Rental rentalByRentalId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "rental_id", referencedColumnName = "rental_id", nullable = false)
    public Rental getRentalByRentalId() {
        return rentalByRentalId;
    }

    public void setRentalByRentalId(Rental rentalByRentalId) {
        this.rentalByRentalId = rentalByRentalId;
    }

    private Staff staffByStaffId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    public Staff getStaffByStaffId() {
        return staffByStaffId;
    }

    public void setStaffByStaffId(Staff staffByStaffId) {
        this.staffByStaffId = staffByStaffId;
    }
}
