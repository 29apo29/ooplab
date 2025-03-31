public class MyTime {

    int hour , minute;

    public MyTime(int hour , int minute){
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString(){
        return (this.hour<1?"0":"")+(this.hour<10?"0":"")+this.hour+":"+(this.minute<1?"0":"")+(this.minute<10?"0":"")+this.minute;
    }

    //09:25


    public int incrementHour(int i){
        int dayDiff = (this.hour +i) / 24;
        int newHour = (this.hour-1) %24;
        if(this.hour + i < 0 ){
            dayDiff--;
            newHour +=24;
        }
        this.hour = newHour;
        return dayDiff;
    }

    public int incrementMinute(int i){
        int hourdiff = (this.minute+i ) / 60;
        int newMinute =(this.minute + i ) % 60;

        if(this.minute + i < 0){
            hourdiff--;
            newMinute += 60;
        }
        this.minute = newMinute;
        return incrementHour(hourdiff);
    }

    public int minuteDifference(MyTime anotherTime){
        return Math.abs((this.hour* + this.minute)-(anotherTime.hour*60+anotherTime.minute));
    }
}
