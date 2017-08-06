package es.joanmiralles.kata.pomodoro.boundary;

import es.joanmiralles.kata.pomodoro.entity.Pomodoro;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.is;

public class PomodoroHandlerTest {

    private Pomodoro pomodoro;
    private PomodoroHandler handler;

    @Before
    public void setUp() {
        this.pomodoro = new Pomodoro();
        this.handler = new PomodoroHandler();
    }

    @Test
    public void when_pomodoro_starts_should_countdown_starts() throws InterruptedException {
        this.handler.start(this.pomodoro);
        Thread.sleep(1000);
        assertThat(this.pomodoro.getLeftDurationInSeconds(), lessThan(Pomodoro.DEFAULT_POMODORO_DURATION_IN_SECONDS));
    }

    @Test(expected = Exception.class)
    public void pomodoro_cant_stop_if_not_started_before() throws Exception {
        this.handler.stop(this.pomodoro);
    }

    @Test
    public void give_one_second_pomodoro_when_it_runs_out_then_it_finishes() throws InterruptedException {
        this.pomodoro = new Pomodoro(1);
        this.handler.start(this.pomodoro);
        Thread.sleep(1000);
        assertThat(this.pomodoro.getStatus(), is(Pomodoro.Status.STOPPED));
        assertThat(this.pomodoro.getLeftDurationInSeconds(), is(0));
    }
}
