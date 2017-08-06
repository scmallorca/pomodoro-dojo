package es.joanmiralles.kata.pomodoro.boundary;

import es.joanmiralles.kata.pomodoro.entity.Pomodoro;

public class PomodoroHandler {

    public void start(Pomodoro pomodoro) {
        pomodoro.start();
    }

    public void stop(Pomodoro pomodoro) throws Exception {
        if (pomodoro.getStatus() == Pomodoro.Status.STOPPED) {
            throw new Exception("Pomodoro has not been started previously");
        }
        pomodoro.stop();
    }
}
