package com.aweroc;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(isNull(l1) && isNull(l2)) {
            return null;
        }
        else if(isNull(l1) || isNull(l2)) {
            return ofNullable(l1).orElse(l2);
        }
        return addTwoNumbers(l1, l2, false);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean remainder) {
        if (nonNull(l1) && nonNull(l2)) {
            SumResult sum = add(l1.val, l2.val, remainder);
            return new ListNode(sum.value, addTwoNumbers(l1.next, l2.next, sum.remainder));
        }
        else if(isNull(l1) && isNull(l2) && remainder) {
            return new ListNode(1);
        }
        else if(nonNull(l1) || nonNull(l2)) {
            ListNode existing = ofNullable(l1).orElse(l2);
            SumResult sum = add(existing.val, 0, remainder);
            return new ListNode(sum.value, addTwoNumbers(existing.next, null, sum.remainder));
        }
        return null;
    }

    private SumResult add(int val1, int val2, boolean addOne) {
        int sum = val1 + val2 + (addOne ? 1 : 0);
        boolean remainder = false;
        if(sum > 9) {
            sum -= 10;
            remainder = true;
        }
        return new SumResult(sum, remainder);
    }


    private final static class SumResult {
        int value;
        boolean remainder;

        public SumResult(int value, boolean remainder) {
            this.value = value;
            this.remainder = remainder;
        }
    }
}
