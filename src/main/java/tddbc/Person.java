package tddbc;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Person {

    private String familyName;
    private String firstName;

    public Person(String familyName, String firstName) throws IllegalArgumentException {
        if (familyName == null || familyName.equals("")) {
            throw new IllegalArgumentException("familyName:" + familyName);
        }

        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException("firstName:" + firstName);
        }

        this.familyName = familyName;
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return familyName + firstName;
    }

    public boolean isMale() {
        return true;
    }

}
