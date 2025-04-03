class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify the code
        ListNode current = dummy; // Pointer to build the result list
        int carry = 0; // Carry for sum greater than 9

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Carry for next addition
            current.next = new ListNode(sum % 10); // Store the last digit
            current = current.next; // Move forward
        }

        return dummy.next; // Return the actual result (skip dummy node)
    }
}


// Example usage
ListNode l1 = new ListNode(2);
l1.next = new ListNode(4);
l1.next.next = new ListNode(3);

ListNode l2 = new ListNode(5);
l2.next = new ListNode(6);
l2.next.next = new ListNode(4);

Solution solution = new Solution();
ListNode result = solution.addTwoNumbers(l1, l2);

// Print result
while (result != null) {
    System.out.print(result.val + " -> ");
    result = result.next;
}
// Output: 7 -> 0 -> 8 ->