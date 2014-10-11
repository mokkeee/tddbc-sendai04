package tddbc;

/**
 * Created by guest on 2014/10/11.
 */
public class Person {

	private String familyName;
	private String firstName;

	public Person(String familyName, String firstName) {
        if (familyName == null || familyName.equals("")) {
            throw new IllegalArgumentException();
        }
		this.familyName = familyName;

        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException();
        }
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

}
