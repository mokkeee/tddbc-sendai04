package tddbc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by guest on 2014/10/11.
 */
public class PersonTest {

    @Test
    public void 佐藤太郎の名字は佐藤である() throws Exception {
        Person sut = new Person();
        assertThat(sut.getFamilyName(), is("佐藤"));
    }

}
