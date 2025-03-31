// Copy Paste at lab3
public class ArrayUtils {
    public static String[] add(String[] series, String x) {
        String[] newSeries = new String[series.length + 1];
        for (int i = 0; i < series.length; i++) {
            newSeries[i] = series[i];
        }
        newSeries[series.length] = x;
        return newSeries;
    }

    public static int indexOf(String[] series, String val) {
        int counter = 0;
        for (String seriesVal : series) {
            if (seriesVal.equals(val)) {
                break;
            }
            counter++;
        }
        return counter != series.length ? counter : -1;
    }

    public static boolean contains(String[] series, String val) {
        boolean result = false;
        for (String seriesVal : series) {
            if (seriesVal.equals(val)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
