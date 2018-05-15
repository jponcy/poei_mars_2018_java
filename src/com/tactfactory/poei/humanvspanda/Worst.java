
package com.tactfactory.poei.humanvspanda;

public class Worst extends Human {

    public Worst()
    {}

    public Worst(String lastname, String firstname) {
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }

    @Override
    public String getName() {
        return super.getName() + " => I swear, I'm a good guy!";
    }
}
