package com.carolina.clients;

import com.carolina.model.Address;
import com.carolina.model.Person;

import java.util.Date;

public class Client extends Person {
    private Long clientId;
    private Date registryDate;

    public Client(String name, String email, Address address, Long clientId) {
        super(name, email, address);
        this.clientId = clientId;
        this.registryDate = new Date();
    }

    public Long getClientId() {
        return clientId;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;

        if (getClientId() != null ? !getClientId().equals(client.getClientId()) : client.getClientId() != null)
            return false;
        return getRegistryDate() != null ? getRegistryDate().equals(client.getRegistryDate()) : client.getRegistryDate() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getClientId() != null ? getClientId().hashCode() : 0);
        result = 31 * result + (getRegistryDate() != null ? getRegistryDate().hashCode() : 0);
        return result;
    }

    @Override
    public Boolean validateEmail() {
        return true;
    }
}
