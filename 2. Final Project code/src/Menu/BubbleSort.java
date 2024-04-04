package Menu;

public class BubbleSort implements SortAlgorithm {
	
	public void sort(int[] data) {
	for(int i = 0; i < data.length-1; i++){
        for(int j = 1; j < data.length - i; j++){
            if (data[j-1] > data[j]) {
                int temp = data[j-1];
                data[j-1] = data[j];
                data[j] = temp;
            }
        }
    }
}
}
