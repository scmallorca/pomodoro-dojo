package es.joanmiralles.kata.pomodoro.entity;

import java.util.Timer;
import java.util.TimerTask;

public class Pomodoro {

    public static final int DEFAULT_POMODORO_DURATION_IN_SECONDS = 25*60;

    private int durationInSeconds = DEFAULT_POMODORO_DURATION_IN_SECONDS;
    private PomodoroStatus status = PomodoroStatus.STOPPED;
    private int leftDurationInSeconds = DEFAULT_POMODORO_DURATION_IN_SECONDS;

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
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (leftDurationInSeconds == 1) {
                    timer.cancel();
                    status = PomodoroStatus.STOPPED;
                }
                leftDurationInSeconds--;
            }
        }, 0, 1000);
    }
}
