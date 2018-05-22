
package com.tactfactory.studentmanager.io;

import java.util.Scanner;

public class IOConsole implements IOStream {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.scanner.close();
    }

    @Override
    public void write(String msg) {
        System.out.println(msg);
    }

    @Override
    public String read() {
        String result;
        while ("".equals((result = scanner.nextLine().trim())));

        return result;
    }
}
