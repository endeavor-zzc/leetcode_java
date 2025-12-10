package Skill;

/**
 * 寻找重复数
 */
public class leetcode287 {
    /**
     * 参考环形链表
     * 将数组看成链表，使用快慢指针，慢指针走一步，快指针走两部，一定回到环中相遇
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums){
        int slow = 0;
        int fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];  //相当于fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        /*
        从【起点】走到【入环口】的距离，刚好等于从【相遇点】继续绕圈走到【入环口】的距离
         */
        int head = 0;
        while (slow != head){
            slow = nums[slow];
            head = nums[head];
        }
        return slow;
    }
}
