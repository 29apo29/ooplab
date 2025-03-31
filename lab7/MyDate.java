public class MyDate {
    private int day;
    private  int month;
    private int year;
    private int[] maxDays = {31,29,31,30,31,30,31,31,30,31,30,31};

    public MyDate(int dd, int mm, int yyyy){
        this.day = dd;
        this.month = mm;
        this.year = yyyy;
    }

    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.day;
    }
    public int getYear(){
        return this.day;
    }

    public String toString(){
        return this.year+"-"+(this.month%10 == this.month?"0":"")+this.month+"-"+(this.day<=9?"0":"")+this.day;
    }
    public void incrementDay(){
        if(this.day  == maxDays[this.month-1]){
            this.day=1;
            incrementMonth();
        }else{
            this.day += 1;
        }
    }
    public void incrementMonth(){
        if(this.month == 12){
            incrementYear();
            this.month=1;
        }else{
            this.month +=1;
        }
    }
    public void incrementMonth(int i){
        int newMonth = (this.month+i)%12;
        int yearChange = 0;
        if(newMonth ==0){
            newMonth +=12;
            yearChange = -1;
        }
        yearChange += (this.month+1)/12;
        this.month = newMonth;
        this.year = yearChange;
        if(this.day > maxDays[this.month-1]){
            this.day = maxDays[this.month-1];
            if(this.month == 1 && this.day == 29 && !inLeapYear()){
                this.day = 28;
            }
        }
    }
    public void incrementYear(){
        this.year +=1;
    }
    public void incrementYear(int i){
        while(i>0){
            incrementYear();
            i--;
        }
    }
    public void decrementDay(){
        if(this.day ==1){
            decrementMonth();
            this.day = maxDays[this.month-1];
        }else{
            this.day -= 1;
        }
    }
    public void decrementMonth(){
        if(this.month == 1){
            decrementYear();
            this.month = 12;
        }else{
            this.month -=1;
        }
    }
    public void decrementYear(){
        this.year -=1;
    }
    public boolean inLeapYear(){
        return this.year%4 == 0 && this.year %100 != 0 ;
    }

}
