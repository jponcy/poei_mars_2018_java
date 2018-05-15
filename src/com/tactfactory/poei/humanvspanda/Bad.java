
package com.tactfactory.poei.humanvspanda;

public class Bad extends Human {

    public Bad() {
    }

    public Bad(String lastname, String firstname) {
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }

    @Override
    public String getName() {
        return super.getName() + " => I'm a bad guy";
    }
}
