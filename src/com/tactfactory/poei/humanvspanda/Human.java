
package com.tactfactory.poei.humanvspanda;

public abstract class Human implements Client {

    private String lastname;

    private String firstname;

    @Override
    public String getName() {
        return this.lastname + " " + this.firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
