
package com.tactfactory.poei.humanvspanda;

public class Panda implements Client {

    private String name;


    public Panda()
    {}

    public Panda(String name) {
        this.setName(name);
    }

    public void congratulate() {
        System.out.println(
                (this.name == null || "".equals(this.name) ? "Ce panda" : this.name)
                + " est le meilleur ! Vive les panda !!");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
