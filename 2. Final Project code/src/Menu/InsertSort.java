package Menu;

public class InsertSort implements SortAlgorithm{
	public void sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int item = data[i];
            int j = i - 1;
            while ((j >= 0) && (item > data[j])) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = item;
        }
    }
}
