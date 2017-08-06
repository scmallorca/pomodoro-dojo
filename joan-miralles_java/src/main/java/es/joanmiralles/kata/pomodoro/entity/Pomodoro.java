package es.joanmiralles.kata.pomodoro.entity;

public class Pomodoro {

    public static final int DEFAULT_POMODORO_DURATION_IN_SECONDS = 25 * 60;

    private int durationInSeconds;
    private Pomodoro.Status status;
    private int leftDurationInSeconds;
    private int interruptions;

    public Pomodoro() {
        this(DEFAULT_POMODORO_DURATION_IN_SECONDS);
    }

    public Pomodoro(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
        this.leftDurationInSeconds = durationInSeconds;
        this.status = Pomodoro.Status.STOPPED;
        this.interruptions = 0;
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

    public int getInterruptions() {
        return interruptions;
    }

    public void setInterruptions(int interruptions) {
        this.interruptions = interruptions;
    }

    public enum Status {
        STARTED, STOPPED
    }

    @Override
    public String toString() {
        return "Pomodoro{" +
                "durationInSeconds=" + durationInSeconds +
                ", status=" + status +
                ", leftDurationInSeconds=" + leftDurationInSeconds +
                ", interruptions=" + interruptions +
                '}';
    }
}
