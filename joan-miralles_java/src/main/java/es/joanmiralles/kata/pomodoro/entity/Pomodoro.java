package es.joanmiralles.kata.pomodoro.entity;

public class Pomodoro {

    public static final int DEFAULT_POMODORO_DURATION_IN_SECONDS = 25*60;

    private int durationInSeconds;
    private Pomodoro.Status status;
    private int leftDurationInSeconds;

    public Pomodoro() {
        this(DEFAULT_POMODORO_DURATION_IN_SECONDS);
    }

    public Pomodoro(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
        this.leftDurationInSeconds = durationInSeconds;
        this.status = Pomodoro.Status.STOPPED;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public Pomodoro.Status getStatus() {
        return status;
    }

    public int getLeftDurationInSeconds() {
        return leftDurationInSeconds;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setLeftDurationInSeconds(int leftDurationInSeconds) {
        this.leftDurationInSeconds = leftDurationInSeconds;
    }

    public enum Status {
        STARTED, STOPPED
    }
}
