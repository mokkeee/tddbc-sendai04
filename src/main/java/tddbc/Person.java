package tddbc;

public class Person {

    public static enum Gender {
        Male,
        Female,
    }

    ;

    private String familyName;
    private String firstName;
    private Gender gender;

    public Person(String familyName, String firstName, Gender gender) throws IllegalArgumentException {
        if (familyName == null || familyName.equals("")) {
            throw new IllegalArgumentException("familyName:" + familyName);
        }

        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException("firstName:" + firstName);
        }

        if (gender == null) {
            throw new IllegalArgumentException("gender is null.");
        }

        this.familyName = familyName;
        this.firstName = firstName;
        this.gender = gender;
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
        if (gender == Gender.Male) {
            return true;
        }

        return false;
    }

    public boolean isFemale() {
        if (gender == Gender.Female) {
            return true;
        }

        return false;
    }

}
