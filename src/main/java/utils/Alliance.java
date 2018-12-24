package utils;

public enum Alliance {

    WHITE(1),
    BLACK(-1);

    public int indicator;

    Alliance(int indicator){
        this.indicator = indicator;
    }

    public void setCounterIndicator(){
       indicator = indicator * -1;
    }
}
