package tddbc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by guest on 2014/10/11.
 */
public class PersonTest {

	@Test
	public void 佐藤太郎を生成できる() throws Exception {
		Person sut = new Person("佐藤", "太郎");
		assertThat(sut, is(instanceOf(Person.class)));
	}

    @Test
    public void 佐藤太郎の名字は佐藤である() throws Exception {
		Person sut = new Person("佐藤", "太郎");
        assertThat(sut.getFamilyName(), is("佐藤"));
    }

	@Test
	public void 佐藤太郎の名前は太郎である() throws Exception {
		Person sut = new Person("佐藤", "太郎");
		assertThat(sut.getFirstName(), is("太郎"));
	}

    @Test
    public void 佐藤太郎の氏名は佐藤太郎である() throws Exception {
		Person sut = new Person("佐藤", "太郎");
        assertThat(sut.getFullName(), is("佐藤太郎"));
    }


}
