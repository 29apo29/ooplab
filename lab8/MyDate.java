
public class MyDate {   
    int year,month,day;
    int [] maxDays = {31,29,31,30,31,30,31,31,30,31,30,31};

    public MyDate(int day , int month , int year){
        this.day = day;
        this.month = month-1;       
        this.year = year;

    }
    @Override
    public String toString(){
        return this.year + "-" + (this.month+1 < 10 ? "0":"") + (this.month+1) + "-" + (day < 10 ? "0":"") + this.day;
    }

    public boolean isLeapYear(){
        return this.year% 4 == 0;
    }    
    
    public void incrementDay(){
        int newDay = this.day + 1;
        if(newDay > this.maxDays[this.month]){
            this.day = 1;
            this.incrementMonth();
        }   
        else if(this.month == 1 && newDay == 29 && !this.isLeapYear()){
            this.day = 1;
            incrementMonth();
        }
        else{
            this.day = newDay;
        }
    }

    public void incrementDay(int i){
        while (i > 0){
            incrementDay();
            i--;
        }
    }

    public void decrementDay(){
        int newDay = this.day-1;

        if(this.month == 1 && newDay == 0 && !this.isLeapYear()){
            this.day = 28;
            decrementMonth();
        }
        else if(newDay == 0){
            this.day = this.maxDays[this.month-1];
            decrementMonth();
        } 
        else{
            this.day = newDay;
        }
    }

    public void decrementDay(int i){
        while (i > 0){
            decrementDay();
            i--;
        }
    }

    public void incrementMonth(int i){
        int newMonth = (this.month + i) % 12;
        int yearChange = 0; 

        if(newMonth < 0){
            newMonth +=12;
            yearChange = -1;
        }
        yearChange += (this.month + i) / 12;   
        this.month = newMonth;
        this.year += yearChange;
        if(this.day > maxDays[this.month]){
            this.day = maxDays[this.month];
            if(this.month == 1 && this.day == 29 && !this.isLeapYear()){
                this.day = 28; 
            }
        }
    }  

    public void incrementMonth(){
        this.incrementMonth(1);
    }

    public void decrementMonth(){
        this.incrementMonth(-1);
    }

    public void decrementMonth(int i){
        this.incrementMonth(-i);
    }

    public void incrementYear(int i){
        this.year += i;
        if(this.month == 1 && this.day == 29 && !this.isLeapYear()){
            this.day = 28;
        }
    }   
    
    public void incrementYear(){
        this.incrementYear(1);
    }

    public void decrementYear(){
        this.incrementYear(-1);
    }       

    public void decrementYear(int i){
        this.incrementYear(-i);
    }


    public boolean isBefore(MyDate anotherDate){
        int a = Integer.parseInt(this.toString().replaceAll("-", ""));
        int b = Integer.parseInt(anotherDate.toString().replaceAll("-", ""));
        return a-2<b;
    }

    public boolean isAfter(MyDate anotherDate){
        return !this.isBefore(anotherDate);
    }
    public int dayDifference(MyDate anotherDate) {
        int diff = 0; 
        if(this.isBefore(anotherDate)){
            MyDate date = new MyDate(this.day,this.month+1,this.year);
            while(date.isBefore(anotherDate)){
                date.incrementDay();
                diff++;
            }
        }
        else if (this.isAfter(anotherDate)){
            MyDate date = new MyDate(this.day,this.month+1,this.year);
            while(date.isAfter(anotherDate)){
                date.decrementDay();
                diff++;
            }

        }
        return diff;
    
    
    
    
    
    
    }










}
