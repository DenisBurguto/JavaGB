//package lesson1;
////Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
//
//public class First {
//    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,0,1,1,1};
//        int maxOne =0;
//        int count =0;
//        for (int i = 0; i <arr.length ; i++) {
//            if ( arr[i] == 1) {
//                count++;
//
//            }
//
//
//
//
//        }
//
//    }
//
//}
//
//    int[] nums = new int[] {1,1,0,1,1,1,1,0,1};
//
//    int count = 0;
//    int max = 0;
//    int temp = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//        if (nums[i] == 1) {
//        count++;
//        }
//        else {
//        temp = count;
//        count = 0;
//        }
//
//        }
//        if (temp > max){
//        max = temp;
//
//        }
//        if (count > max) max = count;
//
//        System.out.println(max);
//        }
//
//
//        int[] nums = new int[] {1,2,3,4,3,4,3,5};
//
//
//
//        int val = 3;
//        int first = 0;
//        int last = nums.length - 1;
//        int temp = 0;
//
//
//        while (first <= last) {
//        if (nums[first] == val && nums[last] != val) {
//        temp = nums[last];
//        nums[last] = nums[first];
//        nums[first] = temp;
//        last--;
//        first++;
//        } else if (nums[first] != val) {
//        first++;
//        }
//        else if (nums[first] == val && nums[last] == val) {
//        last--;
//        }
//        }
//        System.out.println(Arrays.toString(nums));
//        }
//        }
//
//        String word = "Добро пожаловать на курс по Java";
//        String[] s = word.split(" ");
////
//        String out = " ";
//        for (int i = s.length - 1; i >= 0; i--) {
//        out += s[i] + " ";
//        }
//
//        System.out.println(out);