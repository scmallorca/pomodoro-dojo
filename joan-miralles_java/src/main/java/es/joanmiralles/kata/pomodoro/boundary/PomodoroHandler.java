package es.joanmiralles.kata.pomodoro.boundary;

import es.joanmiralles.kata.pomodoro.entity.Pomodoro;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Timer;
import java.util.TimerTask;

public class PomodoroHandler {

    private Timer timer;

    public void start(Pomodoro pomodoro) {
        pomodoro.setStatus(Pomodoro.Status.STARTED);
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(countdownTask(pomodoro), 0, 1000);
    }

    private TimerTask countdownTask(Pomodoro pomodoro) {
        return new TimerTask() {
            @Override
            public void run() {
                if (pomodoro.getLeftDurationInSeconds() == 1) {
                    timer.cancel();
                    ends(pomodoro);
                }
                pomodoro.setLeftDurationInSeconds(pomodoro.getLeftDurationInSeconds() - 1);
            }
        };
    }

    private void ends(Pomodoro pomodoro) {
        pomodoro.setStatus(Pomodoro.Status.STOPPED);
        pomodoro.setLeftDurationInSeconds(pomodoro.getDurationInSeconds());
    }

    public void stop(Pomodoro pomodoro) throws Exception {
        if (pomodoro.getStatus() == Pomodoro.Status.STOPPED) {
            throw new Exception("Pomodoro has not been started previously");
        }
        stop();
    }


    private void stop() {
        throw new NotImplementedException();
    }

}
