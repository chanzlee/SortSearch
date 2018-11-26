public class Sort {
    public static void main(String[] args) {
        int[] array = {69, 10, 30, 2, 16, 8, 31, 22};
//        mergesort(array);
        quicksort(array);

    }

    public static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }


        //With out in-place algorithm, i= low, j = high, k= current
        //store elements into temp helper array and copy it back in the end.

//        while(i<=middle && j<=high) {
//            if(helperLeft[i] < helperRight[j]) {
//                helper[k++] = array[i++];
//            }else {
//                helper[k++] = array[j++];
//            }
//        }
//        while(i<=middle)
//            helper[k++] = array[i++];
//        while(j<=r)
//            helper[k++] = array[j++];
//        for(int index=low; index<k; index++)
//            array[index] = temp[index];


        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length -1);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quicksort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left<index-1) quicksort(arr,left, index-1);
        if (index < right) quicksort(arr, index, right);

    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (pivot < arr[right]) {
                right--;
            }

            if (left <= right) {
                //swap
                int temp = arr[left];
                arr[left]= arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
