import annotations.TestMethodInfo;
import enums.Priority;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExerciseTwo {
    @Test
    @TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
    public void annotation() {
        assertEquals(1, 1);
    }
}

