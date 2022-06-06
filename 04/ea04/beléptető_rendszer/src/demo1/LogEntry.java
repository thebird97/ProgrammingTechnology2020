package demo1;

import java.time.LocalTime;

class LogEntry {
    private final LocalTime arrivalTime;
    private final LocalTime exitTime;

    public LogEntry(LocalTime arrivalTime, LocalTime exitTime) {
        this.arrivalTime = arrivalTime;
        this.exitTime = exitTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }
}
