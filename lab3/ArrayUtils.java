
public class ArrayUtils {
    public static int[] add(int[] series,int x){
        int[] newSeries = new int[series.length+1];
        for(int i = 0; i< series.length; i++){
            newSeries[i] = series[i];
        } 
        newSeries[series.length] = x;
        return newSeries;
    }
}
