
package com.tactfactory.studentmanager;

public class Student {

    private String lastname;

    private String firstname;


    public Student() {
    }
    public Student(String lastname, String firstname) {
        this.setLastname(lastname);
        this.setFirstname(firstname);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.firstname + " " + this.lastname;
    }

    /** @return the lastname */
    public String getLastname() {
        return lastname;
    }

    /** @param lastname The lastname to set.
     * @return Student This. */
    public final Student setLastname(String lastname) {
        this.lastname = lastname.trim().toUpperCase();
        return this;
    }

    /** @return the firstname */
    public String getFirstname() {
        return firstname;
    }

    /** @param firstname The firstname to set.
     * @return Student This. */
    public final Student setFirstname(String firstname) {
        this.firstname = firstname.trim();
        this.firstname = Character.toUpperCase(this.firstname.charAt(0)) + this.firstname.substring(1).toLowerCase();
        return this;
    }
}
