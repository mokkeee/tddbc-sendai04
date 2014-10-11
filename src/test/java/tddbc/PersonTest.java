package tddbc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
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

    @RunWith(Theories.class)
    public static class 結婚できるかテスト {
        static class Fixture {
            public Person p1;
            public Person p2;
            public boolean result;

            public Fixture(Person p1, Person p2, boolean r) {
                this.p1 = p1;
                this.p2 = p2;
                this.result = r;
            }
        }

        static Person p1 = new Person("佐藤", "太郎", Person.Gender.Male);
        static Person p2 = new Person("山田", "花子", Person.Gender.Female);
        static Person p3 = new Person("鈴木", "一郎", Person.Gender.Male);

        @DataPoints
        public static Fixture[] Params = {
                new Fixture(p1, p2, true),
                new Fixture(p1, p3, false),
        };

        @Theory
        public void 同姓とは結婚できない(Fixture f) {
            assertThat(f.p1.isMarriable(f.p2), is(f.result));
        }

    }

    @RunWith(Theories.class)
    public static class 名字_名前_性別がない人は生成できない {

        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        static class Fixture {
            public String familyName;
            public String firstName;
            public Person.Gender gender;

            public Fixture(String s, String s2, Person.Gender g) {
                this.familyName = s;
                this.firstName = s2;
                this.gender = g;
            }
        }

        @DataPoints
        public static Fixture[] Params = {
                new Fixture("", "太郎", Person.Gender.Male),
                new Fixture("佐藤", "", Person.Gender.Male),
                new Fixture("", "", Person.Gender.Male),
                new Fixture(null, "太郎", Person.Gender.Male),
                new Fixture("佐藤", null, Person.Gender.Male),
                new Fixture(null, null, Person.Gender.Male),
                new Fixture("佐藤", "太郎", null),
//				new Fixture("佐藤", "太郎", Person.Gender.Female),
        };

        @Theory
        public void 名字_名前_性別がない人は生成できない(Fixture f) throws Exception {
            expectedException.expect(IllegalArgumentException.class);

            new Person(f.familyName, f.firstName, f.gender);
        }

        @Test
        public void 名字がない人は生成できない() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("familyName");

            new Person("", "太郎", Person.Gender.Male);
        }

        @Test
        public void 名前がない人は生成できない() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("firstName");

            new Person("佐藤", "", Person.Gender.Female);
        }

        @Test
        public void 性別がない人は生成できない() throws Exception {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("gender is null.");

            new Person("佐藤", "太郎", null);
        }
    }
}
