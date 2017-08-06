package es.joanmiralles.kata.pomodoro.entity;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PomodoroTest {

    @Test
    public void test_create_default_pomodoro() {
        Pomodoro pomodoro = new Pomodoro();
        assertThat(pomodoro.getDuration(), is(25));
    }

    @Test
    public void test_create_pomodoro_with_any_duration() {
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setDuration(30);
        assertThat(pomodoro.getDuration(), is(30));
    }

    @Test
    public void test_just_created_pomodoro_should_be_stopped() {
        Pomodoro pomodoro = new Pomodoro();
        assertThat(pomodoro.getStatus(), is(PomodoroStatus.STOPPED));
    }
}
