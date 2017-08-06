package es.joanmiralles.kata.pomodoro.entity;

public class Pomodoro {

    private int duration = 25;
    private PomodoroStatus status = PomodoroStatus.STOPPED;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PomodoroStatus getStatus() {
        return status;
    }
}
