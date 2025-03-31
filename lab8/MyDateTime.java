
public class MyDateTime {
    private MyDate date;
    private MyTime time;

    public MyDateTime(MyDate date, MyTime time) {
        this.date = date;
        this.time = time;
    }

    public MyDate getDate() {
        return this.date;
    }

    public MyTime getTime() {
        return this.time;
    }

    public String toString() {
        return date.toString() + " " + time.toString();
    }

    public void incrementDay() {
        date.incrementDay();
    }

    public void incrementHour() {
        time.incrementHour(1);
    }

    public void incrementHour(int value) {
        time.incrementHour(value);

    }

    public void decrementHour(int value) {
        time.incrementHour(value * (-1));

    }

    public void incrementMinute(int value) {
        time.incrementMinute(value);
    }

    public void decrementMinute(int value) {
        time.incrementMinute(value * (-1));
    }

    public void incrementYear(int value) {
        date.incrementYear(value);
    }

    public void decrementDay() {
        date.decrementDay();
    }

    public void decrementYear() {
        date.decrementYear();
    }

    public void decrementMonth() {
        date.decrementMonth();
    }

    public void incrementDay(int value) {
        date.incrementDay(value);
    }

    public void decrementMonth(int value) {
        date.decrementMonth(value);
    }

    public void decrementDay(int value) {
        date.decrementDay(value);
    }

    public void decrementYear(int value) {
        date.decrementYear(value);
    }

    public void incrementYear() {
        date.incrementYear(0);
    }

    public void incrementMonth(int value) {
        date.incrementMonth(value);
    }

    public void incrementMonth() {
        date.incrementMonth();
    }

    public boolean isBefore(MyDateTime anotherDateTime) {
        boolean isBef = date.isBefore(anotherDateTime.getDate());
        if (!isBef) {
            return false;
        }
        int dayDiff = date.dayDifference(anotherDateTime.getDate());
        if (dayDiff != 0) {
            return true;
        }
        int thisTimeInt = Integer.parseInt(this.time.toString().replaceAll("-", ""));
        int anotherTimeInt = Integer.parseInt(anotherDateTime.getTime().toString().replaceAll("-", ""));
        if (anotherTimeInt > thisTimeInt) {
            return false;
        }
        return true;
    }

    public boolean isAfter(MyDateTime anotherDateTime) {
        boolean isAft = date.isBefore(anotherDateTime.getDate());
        if (isAft) {
            return true;
        }
        int dayDiff = date.dayDifference(anotherDateTime.getDate());
        if (dayDiff != 0) {
            return false;
        }
        int thisTimeInt = Integer.parseInt(this.time.toString().replaceAll("-", ""));
        int anotherTimeInt = Integer.parseInt(anotherDateTime.getTime().toString().replaceAll("-", ""));
        if (anotherTimeInt < thisTimeInt) {
            return false;
        }
        return true;

    }

    public String dayTimeDifference(MyDateTime anotherDateTime) {
        return this.date.dayDifference(anotherDateTime.getDate())+" day"+ this.time.minuteDifference(anotherDateTime.getTime()) + " minute";
    }
}
