package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class leetcode207 {
    public static void main(String[] args){
        int[] test = new int[3];
        System.out.println(test[1]);
    }
}

class Solution207{
    /**
     *
     * @param numCourses 课程数
     * @param prerequisites 先修课与课的关系
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites){
        //记录入度数组
        int[] inDegree = new int[numCourses];
        //创建邻接表，存储每门课程的后续课程
        /*
        为每门课程都创建一个邻接表
        创建完成是[ [],[],[],[] ]
        adjList = [
            [],  // 课程0的后续课程
            [],  // 课程1的后续课程
            [],  // 课程2的后续课程
            [],  // 课程3的后续课程
]

         */
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        //计算每门课程的入度
        for (int[] prereqiusite : prerequisites){
            int course = prereqiusite[0];
            int precourse = prereqiusite[1];
            inDegree[course]++;
            adjList.get(precourse).add(course);
        }
        //存储入度为0的课程的队列
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        //记录已经学完的课程
        int count = 0;
        while(!queue.isEmpty()){
            int selectedCourse = queue.poll();//将学完的课程出队列
            count++;
            //获取当前课程的后续课程列表
            List<Integer> nextCourses = adjList.get(selectedCourse);
            for (int nextCourse : nextCourses){
                inDegree[nextCourse]--;//将入度减1
                if (inDegree[nextCourse] == 0)
                    queue.offer(nextCourse);
            }
        }
        return count == numCourses;
    }
}