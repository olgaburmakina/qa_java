package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest extends TestCase {

    @Mock
    Feline feline;

    @Test
    public void eatMeat() throws Exception {
        var feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"),feline.eatMeat());
    };

    @Test
    public void getFamily() {
        var feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    };

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    };
}

