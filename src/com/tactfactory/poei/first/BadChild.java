package com.tactfactory.poei.first;
class BadParent {

    private int vie = 100; // PV.

    protected void prendreDegats(int douleur) {
        this.vie = Math.max(0, this.vie - douleur);
    }

    public boolean estMort() {
        return this.vie == 0;
    }
}

public class BadChild extends BadParent {

    private int frappePower = 1;

    public void frapper() {
        super.prendreDegats(this.frappePower);
    }

    public void getBatteDeBaseball() {
        this.frappePower = 20;
    }

    public void getMachineGun() {
        this.frappePower = 100000;
    }

    public void cmdSuicide() {
        this.prendreDegats(100);
    }
}
