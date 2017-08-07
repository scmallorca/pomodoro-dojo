package es.joanmiralles.kata.pomodoro.boundary;

import es.joanmiralles.kata.pomodoro.entity.Pomodoro;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Timer;
import java.util.TimerTask;

public class PomodoroHandler {

    private final Pomodoro pomodoro;
    private Timer timer;

    public PomodoroHandler(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }

    public void start() {
        this.pomodoro.setStatus(Pomodoro.Status.STARTED);
        this.pomodoro.setLeftDurationInSeconds(this.pomodoro.getDurationInSeconds());
        this.pomodoro.setInterruptions(0);
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(countdownTask(this.pomodoro), 0, 1000);
    }

    private TimerTask countdownTask(Pomodoro pomodoroIn) {
        return new TimerTask() {
            @Override
            public void run() {
                if (pomodoroIn.getLeftDurationInSeconds() == 1) {
                    ends();
                }
                pomodoroIn.setLeftDurationInSeconds(pomodoroIn.getLeftDurationInSeconds() - 1);
            }
        };
    }

    private void ends() {
        this.timer.cancel();
        this.pomodoro.setStatus(Pomodoro.Status.STOPPED);
    }

    public void stop() throws Exception {
        if (this.pomodoro.getStatus() == Pomodoro.Status.STOPPED) {
            throw new Exception("Pomodoro cannot stop because it has not been started previously");
        }
        throw new NotImplementedException();
    }

    public void interrupt() throws Exception {
        if (this.pomodoro.getStatus() == Pomodoro.Status.STOPPED) {
            throw new Exception("Pomodoro cannot interrupt because it has not been started previously");
        }
        this.pomodoro.setInterruptions(this.pomodoro.getInterruptions() + 1);
    }

}
