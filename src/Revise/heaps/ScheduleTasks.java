package Revise.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class TaskNode {
    String taskName;
    int count;
    TaskNode(String taskName, int count) {
        this.taskName = taskName;
        this.count = count;
    }
}

public class ScheduleTasks {

    public static void scheduleTasks(List<TaskNode> taskList) {
        PriorityQueue<TaskNode> pq = new PriorityQueue<>(new Comparator<TaskNode>() {
            @Override
            public int compare(TaskNode t1, TaskNode t2) {
                return t2.count - t1.count;
            }
        });
        for (TaskNode node : taskList) {
            pq.add(node);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().taskName);
        }
        while (!pq.isEmpty()) {
            TaskNode temp = pq.poll();
            System.out.print(temp.taskName + "--");
            temp.count--;
            if (temp.count > 0) {
                pq.add(temp);
            }
        }
    }

    public static void main(String a[]) {
        List<TaskNode> list = new ArrayList<>();
        list.add(new TaskNode("A", 5));
        list.add(new TaskNode("B", 3));
        list.add(new TaskNode("C", 1));
        list.add(new TaskNode("D", 2));
        ScheduleTasks.scheduleTasks(list);
    }
}
