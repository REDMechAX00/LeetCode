import java.util.Arrays;

public class _4 {

    public static void main(String[] arguments) {
        int[] nums1 = new int[2];
        nums1[0] = 1;
        nums1[1] = 2;
        int[] nums2 = new int[2];
        nums2[0] = 3;
        nums2[1] = 4;

        System.out.println(findMedianSortedArrays(nums1, nums2) + "");
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] allNums = new int[nums1.length + nums2.length];
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            allNums[i] = nums1[i];
            count++;
        }
        for (int i : nums2) {
            allNums[count++] = i;
        }

        Arrays.sort(allNums);

        double median;
        if (allNums.length % 2 == 0) {
            median = ((double) allNums[allNums.length / 2] + (double) allNums[allNums.length / 2 - 1]) / 2;
        } else {
            median = allNums[allNums.length / 2];
        }

        return median;
    }

}





