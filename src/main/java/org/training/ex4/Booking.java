package org.training.ex4;

public class Booking {

    private int startTime;
    private int duration;

    public Booking(int startTime, int duration) {
        this.startTime = startTime;
        this.duration = duration;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getEndTime() {
        return getStartTime() + getDuration();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Booking)) {
            return false;
        }

        Booking bookObj = (Booking) obj;
        return this.startTime == bookObj.startTime
                && this.duration == bookObj.duration;
    }

    @Override
    public String toString() {
        return String.format("Booked from %d to %d", startTime, startTime + duration);
    }
}
