
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

@Points("12-05.1")
public class ListTest<Type> {

    String className = "List";
    Reflex.ClassRef<Object> classRef;
    List<Type> testList;

    // Define some rules for the tests
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        classRef = Reflex.reflect(className);
        this.testList = new List<>();
    }

    @Test
    public void noTests() {

    }

    @Test
    public void classListExistsAndIsPublic() {
        assertTrue("The class List must be public, so it has to be defined as\npublic class " + this.className + " {...\n}", this.classRef.isPublic());
    }

    @Test
    public void constructorNoParamsIsPublic() {
        this.classRef.ctor().takingNoParams().requirePublic();
    }

    @Test
    public void classListHasOnlyTwoObjectVariables() {
        sanitaryCheck(this.className, 2, "two object variables");
    }

    @Test
    public void addMethodExists() {
        this.classRef.method("add").returningVoid().taking(Object.class).requirePublic();
    }

    @Test
    public void addMethodExtendsArrayLength() {

        int initialFullLength = this.testList.getFullLength();
        for (int i = 0; i <= initialFullLength; i++) {
            this.testList.add((Type) new Object());
        }
        int newFullLength = this.testList.getFullLength();
        assertEquals(initialFullLength + initialFullLength / 2, newFullLength);
        assertEquals(initialFullLength + 1, this.testList.size());
    }

    @Test
    public void valueMethodExistsAndIsPublic() {
        this.classRef.method("value").returning(Object.class).taking(int.class).requirePublic();
    }

    @Test
    public void valueWorks() {

        this.testList.add((Type) "A");
        testList.add((Type) "B");
        testList.add((Type) (Object) 3);
        assertEquals("A", testList.value(0));
        assertEquals("B", testList.value(1));
        assertEquals(3, testList.value(2));
        // Test out-of-bounds access:
        this.exceptionRule.expect(IndexOutOfBoundsException.class);
        testList.value(testList.size());
    }

    @Test
    public void containsMethodExistsAndIsPublic() {
        classRef.method("contains").returning(boolean.class).taking(Object.class).requirePublic();
    }

    @Test
    public void containsWorks() {
        List<Object> testList = new List<>();
        testList.add("A");
        testList.add("B");
        testList.add(3);
        assertTrue(testList.contains("A"));
        assertTrue(testList.contains("B"));
        assertTrue(testList.contains(3));
        assertFalse(testList.contains("C"));
    }

    @Test
    public void removeMethodExistsAndIsPublic() {
        classRef.method("remove").returningVoid().taking(Object.class).requirePublic();
    }

    @Test
    public void removeWorks() {
        List<Object> testList = new List<>();
        testList.add("A");
        testList.add("B");
        testList.add(3);
        testList.remove("A");
        assertFalse(testList.contains("A"));
        assertTrue(testList.contains("B"));
        assertTrue(testList.contains(3));
        assertFalse(testList.contains("C"));
    }

    @Test
    public void sizeMethodExistsAndIsPublic() {
        classRef.method("size").returning(int.class).takingNoParams().requirePublic();
    }

    @Test
    public void growMethodExistsAndIsPrivate() {
        classRef.method("grow").returningVoid().takingNoParams().requirePrivate();
    }
    @Test
    public void indexOfValueMethodExistsAndIsPrivate() {
        classRef.method("indexOfValue").returning(int.class).taking(Object.class).requirePrivate();
    }

    @Test
    public void moveToTheLeftMethodExistsAndIsPrivate() {
        classRef.method("moveToTheLeft").returningVoid().taking(int.class).requirePrivate();
    }

    // Private methods for test classes
    private void sanitaryCheck(String klassName, int n, String m) throws SecurityException {
        Field[] fields = ReflectionUtils.findClass(klassName).getDeclaredFields();

        for (Field field : fields) {
            assertFalse("you don't need \"static variables\", remove the variable " + fieldName(field.toString(), klassName) + " from the class " + klassName, field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("the visibility of all object variables for the class should be private, change the following variables in the class  " + klassName + ": " + fieldName(field.toString(), klassName), field.toString().contains("private"));
        }

        if (fields.length > 1) {
            int var = 0;
            for (Field field : fields) {
                if (!field.toString().contains("final")) {
                    var++;
                }
            }
            assertTrue("the class " + klassName + " only needs " + m + ", remove unnecessary variables", var <= n);
        }
    }

    private String fieldName(String toString, String klassName) {
        return toString.replace(klassName + ".", "").replace("java.lang.", "").replace("java.util.", "");
    }

}
