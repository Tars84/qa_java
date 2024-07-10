package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    @Mock
    Feline feline;

    @Test
    public void createLionThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Используйте допустимые значения пола животного - самец или самка");

        new Lion("Не определено", feline);
    }

    @Test
    public void getKittensIsCorrect() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedCount = 2;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);

        assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void getFoodIsCorrect() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedListOfFood = List.of("Пища");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Некорректный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood)
        );
    }
}

