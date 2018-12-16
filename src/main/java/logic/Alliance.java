package logic;

public enum Alliance {
    WHITE(1),
    BLACK(-1);

    public final int indicator;

    Alliance(int indicator){
        this.indicator = indicator;
    }
}
