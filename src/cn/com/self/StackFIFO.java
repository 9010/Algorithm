package cn.com.self;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 2019.4.2 zx
 * 相对而言比较简单
 */
public class StackFIFO {
    public static void main(String[] args) {
        StackFIFO stackFIFO = new StackFIFO();
        stackFIFO.push(5);
        stackFIFO.push(4);
        stackFIFO.push(3);
        System.out.println(stackFIFO.pop());  //5
        System.out.println(stackFIFO.pop());  //4
        stackFIFO.push(2);
        stackFIFO.push(1);
        System.out.println(stackFIFO.pop());  //3
        stackFIFO.push(0);
        System.out.println(stackFIFO.pop());  //2
        System.out.println(stackFIFO.pop());  //1
        System.out.println(stackFIFO.pop());  //0
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
