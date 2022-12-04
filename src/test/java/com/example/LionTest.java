package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)

public class LionTest extends TestCase {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    Feline feline = Mockito.mock(Feline.class);

    private final boolean expected;
    private final String gender;

    public LionTest(boolean expected, String gender) {
        this.expected = expected;
        this.gender = gender;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {true,"Самец"},
                {false, "Самка"},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("one", "two", "three"));
        var lion = new Lion(gender, feline);
        assertEquals(List.of("one", "two", "three"), lion.getFood());
    }

    @Test
    public void checkException() {
        Exception actualException = assertThrows(Exception.class, () ->
                new Lion("Чиполлино", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", actualException.getMessage());
    }
}


