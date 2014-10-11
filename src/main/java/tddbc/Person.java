package tddbc;

public class Person {

	public static enum Gender {
		Male,
		Female,
	};

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
        return gender == Gender.Male;
    }

	public boolean isFemale() {
		return gender == Gender.Female;
	}
}
