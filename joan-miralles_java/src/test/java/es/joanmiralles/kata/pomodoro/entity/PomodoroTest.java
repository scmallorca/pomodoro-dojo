package es.joanmiralles.kata.pomodoro.entity;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PomodoroTest {

    public static final int THIRTY_MIN_DURATION_IN_SECONDS = 30 * 60;

    @Test
    public void test_create_default_pomodoro() {
        Pomodoro pomodoro = new Pomodoro();
        assertThat(pomodoro.getDurationInSeconds(), is(Pomodoro.DEFAULT_POMODORO_DURATION_IN_SECONDS));
    }

    @Test
    public void test_create_pomodoro_with_any_duration() {
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setDurationInSeconds(THIRTY_MIN_DURATION_IN_SECONDS);
        assertThat(pomodoro.getDurationInSeconds(), is(THIRTY_MIN_DURATION_IN_SECONDS));
    }

    @Test
    public void test_just_created_pomodoro_should_be_stopped() {
        Pomodoro pomodoro = new Pomodoro();
        assertThat(pomodoro.getStatus(), is(Pomodoro.Status.STOPPED));
    }

}
