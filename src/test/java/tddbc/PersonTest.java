package tddbc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class PersonTest {

    public static class 佐藤太郎の場合 {

        Person sut;

        @Before
        public void setUp() throws Exception {
            sut = new Person("佐藤", "太郎", Person.Gender.Male);
        }

        @Test
        public void 佐藤太郎を生成できる() throws Exception {
            assertThat(sut, is(instanceOf(Person.class)));
        }

        @Test
        public void 佐藤太郎の名字は佐藤である() throws Exception {
            assertThat(sut.getFamilyName(), is("佐藤"));
        }

        @Test
        public void 佐藤太郎の名前は太郎である() throws Exception {
            assertThat(sut.getFirstName(), is("太郎"));
        }

        @Test
        public void 佐藤太郎の氏名は佐藤太郎である() throws Exception {
            assertThat(sut.getFullName(), is("佐藤太郎"));
        }

        @Test
        public void 佐藤太郎の性別は男である() throws Exception {
            assertThat(sut.isMale(), is(true));
        }

		@Test
		public void 佐藤太郎の性別は女ではない() throws Exception {
			assertThat(sut.isFemale(), is(false));
		}

    }

    public static class 鈴木花子の場合 {

        Person sut;

        @Before
        public void setUp() throws Exception {
            sut = new Person("鈴木", "花子", Person.Gender.Female);
        }

        @Test
        public void 鈴木花子を生成できる() throws Exception {
            assertThat(sut, is(instanceOf(Person.class)));
        }

        @Test
        public void 鈴木花子の名字は鈴木である() throws Exception {
            assertThat(sut.getFamilyName(), is("鈴木"));
        }

        @Test
        public void 鈴木花子の名前は一郎である() throws Exception {
            assertThat(sut.getFirstName(), is("花子"));
        }

        @Test
        public void 鈴木花子の氏名は鈴木一郎である() throws Exception {
            assertThat(sut.getFullName(), is("鈴木花子"));
        }

		@Test
		public void 鈴木花子の性別は男ではない() throws Exception {
			assertThat(sut.isMale(), is(false));
		}

		@Test
		public void 鈴木花子の性別は女である() throws Exception {
			assertThat(sut.isFemale(), is(true));
		}

    }

    public static class 名字または名前がない人は生成できない {
		@Rule
		public ExpectedException expectedException = ExpectedException.none();

		@Test
		public void 名字がない人は生成できない() throws Exception {
			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("familyName");

			new Person("", "太郎", null);
		}

        @Test
        public void 名前がない人は生成できない() throws Exception {
			expectedException.expect(IllegalArgumentException.class);
			expectedException.expectMessage("firstName");

            new Person("佐藤", "", Person.Gender.Female);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 名字と名前がない人は生成できない() throws Exception {
            new Person("", "", null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 名字がnullの人は生成できない() throws Exception {
            new Person(null, "太郎", null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 名前がnullの人は生成できない() throws Exception {
            new Person("佐藤", null, null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 名字と名前がnullの人は生成できない() throws Exception {
            new Person(null, null, null);
        }

        @Test
        public void 性別がない人は生成できない() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("gender is null.");

            new Person("佐藤", "太郎", null);
        }
    }
}
