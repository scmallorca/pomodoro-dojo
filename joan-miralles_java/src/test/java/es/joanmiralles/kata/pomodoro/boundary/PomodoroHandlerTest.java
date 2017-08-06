package es.joanmiralles.kata.pomodoro.boundary;

import es.joanmiralles.kata.pomodoro.entity.Pomodoro;
import es.joanmiralles.kata.pomodoro.entity.PomodoroStatus;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.is;

public class PomodoroHandlerTest {

    @Test
    public void when_pomodoro_starts_should_countdown_starts() throws InterruptedException {
        Pomodoro pomodoro = new Pomodoro();
        PomodoroHandler handler = new PomodoroHandler();
        handler.start(pomodoro);
        Thread.sleep(1100);
        assertThat(pomodoro.getLeftDurationInSeconds(), lessThan(Pomodoro.DEFAULT_POMODORO_DURATION_IN_SECONDS));
    }

    @Test(expected = Exception.class)
    public void pomodoro_cant_stop_if_not_started_before() throws Exception {
        Pomodoro pomodoro = new Pomodoro();
        PomodoroHandler handler = new PomodoroHandler();
        handler.stop(pomodoro);
    }

    @Test
    public void pomodoro_finishes_when_it_runs_out() throws InterruptedException {
        Pomodoro pomodoro = new Pomodoro(1);
        PomodoroHandler handler = new PomodoroHandler();
        handler.start(pomodoro);
        Thread.sleep(1000);
        assertThat(pomodoro.getStatus(), is(PomodoroStatus.STOPPED));
    }
}
