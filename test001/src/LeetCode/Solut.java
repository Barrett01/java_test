package LeetCode;
/*
两数之和
 */
public class Solut {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 11, 7}, 9);
        System.out.println(ints[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for(int i=0 ;i < nums.length; i++){
            for(int j =i+1;j<nums.length;j++){
                /*
                错误分析 是每次内循环结束后 外循环第二次进来 会导致内循环没递进；
                如果j =1；的话 已经nums.length-i-1;
                 */
                if(nums[i]+nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;

    }
}
