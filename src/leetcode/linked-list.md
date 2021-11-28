#Linked List

+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort List](#sort-list)
<!---->

## Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        ListNode current;
        while (head != null){
            current = head;
            head = head.next;
            current.next = ans;
            ans = current;
        }
        return ans;
    }
}
```

## Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/
```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

## Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/
```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rev = null, current = null;
        while (slow != null){
            current = slow;
            slow = slow.next;
            current.next = rev;
            rev = current;
        }
        slow = head;
        while (slow != null && rev != null){
            if (slow.val != rev.val){
                return false;
            }
            slow = slow.next;
            rev = rev.next;
        }
        return true;
    }
}
```

## Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode junk = ans;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                ans.next = list1;
                list1 = list1.next;
            }else{
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }
        if (list1 != null){
            ans.next = list1;
        }
        if (list2 != null){
            ans.next = list2;
        }
        return junk.next;
    }
}
```

## Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
    
        while( a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;    
        }
        return a;
    }
}
```

## Sort List
https://leetcode.com/problems/sort-list/
```java
class Solution {
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        prev.next = null; // I cut the list by using NULL after middle node
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        return merge(left, right);
    }
    
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode junk = ans;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                ans.next = list1;
                list1 = list1.next;
            }else{
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }
        if (list1 != null){
            ans.next = list1;
        }
        if (list2 != null){
            ans.next = list2;
        }
        return junk.next;
    }
}
```