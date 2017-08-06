package es.joanmiralles.kata.pomodoro.entity;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Timer;
import java.util.TimerTask;

public class Pomodoro {

    public static final int DEFAULT_POMODORO_DURATION_IN_SECONDS = 25*60;

    private int durationInSeconds = DEFAULT_POMODORO_DURATION_IN_SECONDS;
    private PomodoroStatus status = PomodoroStatus.STOPPED;
    private int leftDurationInSeconds = DEFAULT_POMODORO_DURATION_IN_SECONDS;
    private Timer timer;

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public PomodoroStatus getStatus() {
        return status;
    }

    public void setStatus(PomodoroStatus status) {
        this.status = status;
    }

    public int getLeftDurationInSeconds() {
        return leftDurationInSeconds;
    }

    public void start() {
        status = PomodoroStatus.STARTED;
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(countdownTask(), 0, 1000);
    }

    private TimerTask countdownTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (leftDurationInSeconds == 1) {
                    timer.cancel();
                    status = PomodoroStatus.STOPPED;
                }
                leftDurationInSeconds--;
            }
        };
    }

    public void stop() {
        throw new NotImplementedException();
    }
}
