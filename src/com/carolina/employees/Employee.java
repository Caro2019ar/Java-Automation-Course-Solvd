package com.carolina.employees;

import com.carolina.employees.roles.AppUserRole;
import com.carolina.model.Address;
import com.carolina.model.Person;

import java.util.Date;

public class Employee extends Person {
 private Long employeeId;
 private Date startDate;
 private AppUserRole userRole;

    public Employee(String name, String email, Address address, Date startDate) {
        super(name, email, address);
        this.startDate = startDate;
        this.userRole = AppUserRole.USER;
    }

    public AppUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(AppUserRole userRole) {
        this.userRole = userRole;
    }

    public Long getEmployeeId() {
        return employeeId;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (getEmployeeId() != null ? !getEmployeeId().equals(employee.getEmployeeId()) : employee.getEmployeeId() != null)
            return false;
        return getStartDate() != null ? getStartDate().equals(employee.getStartDate()) : employee.getStartDate() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getEmployeeId() != null ? getEmployeeId().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        return result;
    }

    public Boolean isAdmin() {
        return false;
    }
}
