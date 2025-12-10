package Substring;

/**
 * 最小覆盖子串
 */
public class leetcode76 {
    /**
     * <p>
     *     初始化 ansLeft=−1, ansRight=m，用来记录最短子串的左右端点，其中 m 是 s 的长度。
     * </p>
     * <p>用一个哈希表（或者数组）cntT 统计 t 中每个字母的出现次数。</p>
     * <p>初始化 left=0，以及一个空哈希表（或者数组）cntS，用来统计 s 子串中每个字母的出现次数。</p>
     * <p>遍历 s，设当前枚举的子串右端点为 right，把 s[right] 的出现次数加一</p>
     * <p>
     *     遍历 cntS 中的每个字母及其出现次数，如果出现次数都大于等于 cntT 中的字母出现次数：
     *     <p> a 如果 right−left < ansRight−ansLeft，说明我们找到了更短的子串，更新 ansLeft=left, ansRight=right。</p>
     *     <p> 把 s[left] 的出现次数减一</p>
     *     <p> 左端点右移，即 left 加一 </p>
     *     <div>
     *         重复上述三步，直到 cntS 有字母的出现次数小于 cntT 中该字母的出现次数为止。
     *     </div>
     * </p>
     * 最后，如果 ansLeft<0，说明没有找到符合要求的子串，返回空字符串，否则返回下标 ansLeft 到下标 ansRight 之间的子串。
     * @param S 较长串
     * @param t 较短串
     * @return
     */
    public String minWindow(String S, String t){
        int[] cntS = new int[128];  // s子串字母出现的次数
        int[] cntT = new int[128];  // t子串字母出现的次数
        for (char c : t.toCharArray()){
            cntT[c]++;
        }

        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;

        int left = 0;
        for (int right = 0; right < m; right++) {  //移动右端点
            cntS[s[right]]++;
            while (isCovered(cntS, cntT)){   //检查是否S涵盖T
                 if (right - left < ansRight - ansLeft){  //找到更短的子串
                     ansLeft = left;
                     ansRight = right;
                 }
                 cntS[s[left]]--;  //左端点字母移出子串
                 left++;
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]){
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]){
                return false;
            }
        }
        return true;
    }
}
