
package com.tactfactory.studentmanager;

import com.tactfactory.studentmanager.io.IOConsole;
import com.tactfactory.studentmanager.io.IOStream;

public class Main {


    private CRUDStrategy<?> current;
    private IOStream io = new IOConsole();

    public static void main(String[] args) {
        new Main().process();
    }

    private void process() {
        while (true) {
            this.io.write("Que voulez vous gérer ?\n\t1) Etudiants\n\t2) Matières (bientôt disponible)\n\t0) Quitter");

            switch (this.io.read()) {
                case "0":
                    this.io.write("Merci et à  bientôt !");
                    System.exit(0);
                    break;
                case "1":
                    if (!(this.current instanceof StudentCRUD))
                        this.current = new StudentCRUD();
                    break;
                case "2":
                    this.current = null;
                    this.io.write("Pas encore disponible.");
                    break;
                default:
                    break;
            }

            if (this.current != null) this.current.process();
        }
    }

}
