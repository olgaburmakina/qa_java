package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class CatTest extends TestCase {

    @Mock
    Feline feline;

    @Test
    public void testGetSound() {
        var cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        var cat = new Cat(feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
