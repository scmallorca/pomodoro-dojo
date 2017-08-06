package es.joanmiralles.kata.pomodoro.entity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PomodoroTest {

    @Test
    public void test_create_default_pomodoro() {
        Pomodoro pomodoro = new Pomodoro();
        assertTrue(pomodoro.getDuration() == 25);
    }

    @Test
    public void test_create_pomodoro_with_any_duration() {
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setDuration(30);
        assertTrue(pomodoro.getDuration() == 30);
    }

}
