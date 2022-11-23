import java.util.Arrays;

public class _1_Two_Sum {

    public static void main(String[] arguments) {

        int[] nums = new int[4];
        nums[0]=2;
        nums[1]=7;
        nums[2]=11;
        nums[3]=15;

        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    @SuppressWarnings("SameParameterValue")
    private static int[] twoSum ( int[] nums, int target){

        int[] solution = new int[2];

        int indexNum1 = 0;
        int indexNum2 = 0;
        int sum;

        do {
            indexNum2++;
            sum = nums[indexNum1] + nums[indexNum2];

            solution[0] = indexNum1;
            solution[1] = indexNum2;

            if ((indexNum2 + 1) == nums.length) {
                indexNum1++;
                indexNum2 = indexNum1;
            }
        }
        while (sum != target);

        return solution;
    }
}
