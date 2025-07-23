import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class leetcode438 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();
        Solution438 solution438 = new Solution438();
        List<Integer> result = solution438.findAnagrams(input1, input2);
        System.out.println(result);
    }
}

class Solution438{
    public List<Integer> findAnagrams(String s, String p){
        int p_length = p.length();
        int s_length = s.length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - p_length; i++) {

        }
        return result;
    }
}