import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseManagementTest {
    private ExerciseManagement management;

    @Before
    public void initialize() {
        this.management = new ExerciseManagement();
    }
    @Test
    public void exerciseListEmptyAtBeginning() {
        assertEquals(0, this.management.exerciseList().size());
    }

    @Test
    public void addingExerciseGrowsListByOne() {
        this.management.add("Write a test");
        assertEquals(1, this.management.exerciseList().size());
    }

    @Test
    public void addedExerciseIsInList() {
        this.management.add("Write a test");
        assertTrue(this.management.exerciseList().contains("Write a test"));
    }

    @Test
    public void exerciseCanBeMarkedAsCompleted() {
        this.management.add("New exercise");
        this.management.markAsCompleted("New exercise");
        assertTrue(this.management.isCompleted("New exercise"));
    }

    @Test
    public void ifNotMarkedCompletedIsNotCompleted() {
        this.management.add("New exercise");
        this.management.markAsCompleted("New exercise");
        assertFalse(this.management.isCompleted("Some exercise"));
    }
}
