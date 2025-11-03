package Stack;

/**
 * 字符串解码
 */
public class leetcode394 {
    public static void main(String[] args){

    }
}

class Solution394{
    public int index = 0;
    public String decodeString(String s){
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']'){
            char ch = s.charAt(index);
            if (Character.isDigit(ch)){
                int k = 0; // 处理数字，解析完整的重复次数
                 while(index < s.length() && Character.isDigit(s.charAt(index))){
                     k = k * 10 + (s.charAt(index) - '0');
                     index++;
                 }
                 //跳过左括号
                index++;
                 //递归调用函数
                String substring = decodeString(s);
                //跳过右括号
                index++;
                //将重复k次的字符串添加到结果中
                for (int i = 0; i < k; i++) {
                    result.append(substring);
                }
            }else {
                result.append(ch);
                index++;
            }
        }
        return result.toString();
    }
}

