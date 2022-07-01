package com.aweroc;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.copyOfRange;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void should_return_null_when_both_listnodes_are_null() {
        ListNode result = solution.addTwoNumbers(null, null);

        assertNull(result);
    }

    @Test
    void should_return_non_null_input_when_other_is_null() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        ListNode result1 = solution.addTwoNumbers(l1, null);
        ListNode result2 = solution.addTwoNumbers(null, l2);

        assertEquals(l1, result1);
        assertEquals(l2, result2);
    }

    @Test
    void should_return_listnode_with_zero_sum() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_single_digit_numbers() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode expected = new ListNode(3);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_double_digit_numbers() {
        ListNode l1 = listNode(1, 1);
        ListNode l2 = listNode(2, 2);
        ListNode expected = listNode(3, 3);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_three_digit_numbers() {
        ListNode l1 = listNode(1, 1, 1);
        ListNode l2 = listNode(2, 2, 2);
        ListNode expected = listNode(3, 3, 3);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_three_digit_numbers_with_leading_zero() {
        ListNode l1 = listNode(1, 1, 1);
        ListNode l2 = listNode(2, 2, 0);
        ListNode expected = listNode(3, 3, 1);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_two_and_three_digit_numbers() {
        ListNode l1 = listNode(1, 1, 1);
        ListNode l2 = listNode(2, 2);
        ListNode expected = listNode(3, 3, 1);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_single_and_three_digit_numbers() {
        ListNode l1 = listNode(1, 1, 1);
        ListNode l2 = new ListNode(2);
        ListNode expected = listNode(3, 1, 1);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_single_digit_numbers_with_remainder() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(2);
        ListNode expected = listNode(1, 1);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_double_digit_numbers_with_remainder() {
        ListNode l1 = listNode(9, 1);
        ListNode l2 = listNode(1, 1);
        ListNode expected = listNode(0, 3);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_return_sum_of_single_and_double_digit_numbers_with_remainder() {
        ListNode l1 = listNode(9, 9);
        ListNode l2 = listNode(1);
        ListNode expected = listNode(0, 0, 1);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_add_three_digit_numbers_with_remainder() {
        ListNode l1 = listNode(2, 4, 3);
        ListNode l2 = listNode(5, 6, 4);
        ListNode expected = listNode(7, 0, 8);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    @Test
    void should_add_seven_digit_and_four_digit_with_remainder() {
        ListNode l1 = listNode(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = listNode(9, 9, 9, 9);
        ListNode expected = listNode(8, 9, 9, 9, 0, 0, 0, 1);

        ListNode result = solution.addTwoNumbers(l1, l2);

        assertEquals(expected, result);
    }

    private ListNode listNode(Integer... values) {
        if(values.length == 0) {
            return null;
        }
        return new ListNode(values[0], listNode(copyOfRange(values, 1, values.length)));
    }
}
