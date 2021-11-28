# Design
+ [Min Stack](#min-stack)
+ [Implement Stack using Queues](#implement-stack-using-queues)
+ [Implement Queue using Stacks](#implement-queue-using-stacks)
<!---->

## Min Stack
https://leetcode.com/problems/min-stack/
```java
class MinStack {

    private Node head;

    private class Node {
        int value;
        int min;
        Node next;

        private Node(int value, int min, Node node) {
            this.value = value;
            this.min = min;
            this.next = node;
        }
    }

    public MinStack() {

    }

    public void push(int val) {
        if (head == null){
            head = new Node(val, val, null);
        }else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
```
## Implement Stack using Queues
https://leetcode.com/problems/implement-stack-using-queues/
```java
class MyStack {
    private Queue<Integer> que = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        int len = que.size();
        que.add(x);
        while (len > 0){
            que.add(que.remove());
            len--;
        }
    }
    
    public int pop() {
        int ans = que.peek();
        que.remove();
        return ans;
    }
    
    public int top() {
        return que.peek();
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}
```

## Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/
```java
class MyQueue {
    private Stack<Integer> justPush = new Stack<>();
    private Stack<Integer> amortization = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        justPush.add(x);
    }
    
    public int pop() {
        amortization();
        return amortization.pop();
    }
    
    public int peek() {
        amortization();
        return amortization.peek();
    }
    
    
    public boolean empty() {
        return justPush.isEmpty() && amortization.isEmpty();
    }
    
    
    public void amortization() {
        if (amortization.isEmpty()){
            while (!justPush.isEmpty())
                amortization.push(justPush.pop());
        }
    }
}
```