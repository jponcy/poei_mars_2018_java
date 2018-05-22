
package com.tactfactory.studentmanager.io;

/** Represents our input/output systems (console, file, RAM). */
public interface IOStream {

    /** Print the message into the implemented output. */
    void write(String msg);

    /** Read a string from input stream. */
    String read();
}
