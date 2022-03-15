package com.carolina.suppliers;

import com.carolina.model.Address;
import com.carolina.model.Person;

import java.util.Date;

public class Supplier extends Person {
    private Long supplierId;
    private Date startDate;

    public Supplier(String name, String email, Address address, Long supplierId, Date startDate) {
        super(name, email, address);
        this.supplierId = supplierId;
        this.startDate = startDate;
    }

    public Supplier(String name, String email, Address address, Date startDate) {
        super(name, email, address);
        this.startDate = startDate;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public Boolean validateEmail() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;
        if (!super.equals(o)) return false;

        Supplier supplier = (Supplier) o;

        if (getSupplierId() != null ? !getSupplierId().equals(supplier.getSupplierId()) : supplier.getSupplierId() != null)
            return false;
        return getStartDate() != null ? getStartDate().equals(supplier.getStartDate()) : supplier.getStartDate() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getSupplierId() != null ? getSupplierId().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        return result;
    }
}
