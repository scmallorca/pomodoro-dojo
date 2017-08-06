package es.joanmiralles.kata.pomodoro.boundary;

import es.joanmiralles.kata.pomodoro.entity.Pomodoro;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.is;

public class PomodoroHandlerTest {

    private Pomodoro pomodoro;
    private PomodoroHandler handler;

    @Before
    public void setUp() {
        this.pomodoro = new Pomodoro();
        this.handler = new PomodoroHandler(this.pomodoro);
    }

    @Test
    public void when_pomodoro_starts_should_countdown_starts() throws InterruptedException {
        this.handler.start();
        Thread.sleep(1000);
        assertThat(this.pomodoro.getLeftDurationInSeconds(), lessThan(Pomodoro.DEFAULT_POMODORO_DURATION_IN_SECONDS));
    }

    @Test(expected = Exception.class)
    public void pomodoro_cant_stop_if_not_started_before() throws Exception {
        this.handler.stop();
    }

    @Test
    public void give_one_second_pomodoro_when_it_runs_out_then_it_finishes() throws InterruptedException {
        this.pomodoro = new Pomodoro(1);
        this.handler = new PomodoroHandler(this.pomodoro);
        this.handler.start();
        Thread.sleep(1000);
        assertThat(this.pomodoro.getStatus(), is(Pomodoro.Status.STOPPED));
        assertThat(this.pomodoro.getLeftDurationInSeconds(), is(0));
    }

    @Test
    public void give_one_second_pomodoro_if_time_do_not_exhausted_pomodoro_does_not_end() throws InterruptedException {
        this.pomodoro = new Pomodoro(1);
        this.handler = new PomodoroHandler(this.pomodoro);
        this.handler.start();
        assertThat(this.pomodoro.getStatus(), is(Pomodoro.Status.STARTED));
    }

    @Test
    public void give_created_pomodoro_then_it_has_no_interruptions() {
        assertThat(this.pomodoro.getInterruptions(), is(0));
    }

    @Test(expected = Exception.class)
    public void give_created_pomodoro_when_cannot_started_then_cannot_be_interrupted() throws Exception {
        this.handler.interrupt();
    }

    @Test
    public void give_created_pomodoro_counts_interruptions() throws Exception {
        this.handler.start();
        this.handler.interrupt();
        this.handler.interrupt();
        this.handler.interrupt();
        assertThat(this.pomodoro.getInterruptions(), is(3));
    }

    @Test
    public void give_started_pomodoro_when_start_it_again_then_it_is_restarted() throws InterruptedException {
        this.handler.start();
        Thread.sleep(1000);
        this.handler.start();
        assertThat(this.pomodoro.getLeftDurationInSeconds(), is(Pomodoro.DEFAULT_POMODORO_DURATION_IN_SECONDS));
    }

    @Test
    public void give_started_pomodoro_when_it_is_restarted_then_it_has_no_interruptions() throws Exception {
        this.handler.start();
        this.handler.interrupt();
        this.handler.start();
        assertThat(this.pomodoro.getInterruptions(), is(0));
    }
}
