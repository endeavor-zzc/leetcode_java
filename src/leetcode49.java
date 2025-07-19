import java.lang.reflect.Array;
import java.util.*;

public class leetcode49 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一串字符串");

        String input = scanner.nextLine();
        String[] strs = input.split("\\s+"); // split()方法根据匹配给定的正则表达式来拆分字符串。

        Solution49 solution49 = new Solution49();
        List<List<String>> result = solution49.groupAnagrams(strs);

        System.out.println("输出结果");
        for (List<String> group : result)
            System.out.print(group);
    }
}

class Solution49{
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (var str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedStr = new String(array);
            // getOrDefault()是获取key对应的value,返回的是一个字符串列表
            List<String> list = hashMap.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            hashMap.put(sortedStr, list);
        }
        return new ArrayList<>(hashMap.values());
    }
}
