/**
* @author Xiqing chu
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.ArrayList;

public class SolutionTest {
  @Test
  public void basic() {
    int[] inputs = {1,2,3};
    ListNode head = buildList(inputs);
    Solution s = new Solution();
    ListNode new_list = s.deleteDuplicates(head);
    int[] result = readList(new_list);
    assertArrayEquals(inputs, result);
  }

  @Test
  public void case1() {
    int[] inputs = {1,1,2,3};
    ListNode head = buildList(inputs);
    Solution s = new Solution();
    ListNode new_list = s.deleteDuplicates(head);
    int[] result = readList(new_list);
    int[] expected = {2,3};
    assertArrayEquals(expected, result);
  }

  @Test
  public void case2() {
    int[] inputs = {1,1,2,3,3};
    ListNode head = buildList(inputs);
    Solution s = new Solution();
    ListNode new_list = s.deleteDuplicates(head);
    int[] result = readList(new_list);
    int[] expected = {2};
    assertArrayEquals(expected, result);
  }

  @Test
  public void case3() {
    int[] inputs = {1,1,2,3,3,5};
    ListNode head = buildList(inputs);
    Solution s = new Solution();
    ListNode new_list = s.deleteDuplicates(head);
    int[] result = readList(new_list);
    int[] expected = {2,5};
    assertArrayEquals(expected, result);
  }

  @Test
  public void case4() {
    int[] inputs = {1,1,2,2,3,3,5,5};
    ListNode head = buildList(inputs);
    Solution s = new Solution();
    ListNode new_list = s.deleteDuplicates(head);
    int[] result = readList(new_list);
    int[] expected = {};
    assertArrayEquals(expected, result);
  }

  @Test
  public void case5() {
    int[] inputs = {5,4,3,2,2,1,-1};
    ListNode head = buildList(inputs);
    Solution s = new Solution();
    ListNode new_list = s.deleteDuplicates(head);
    int[] result = readList(new_list);
    int[] expected = {5,4,3,1,-1};
    assertArrayEquals(expected, result);
  }

  // build a list from an array
  private ListNode buildList(int[] inputs){
    ArrayList<ListNode> bucket = new ArrayList();
    for (int i = 0; i < inputs.length; i++){
        ListNode temp = new ListNode(inputs[i]);
        temp.next = null;
        bucket.add(temp);
    }

    for (int i = 0; i < (inputs.length - 1); i++){
        ListNode temp = bucket.get(i);
        temp.next = bucket.get(i+1);
    }
    return bucket.get(0);
  }

  // turn list back to int array
  private int[] readList(ListNode head){
      // build an arrayList of elements
      ArrayList<ListNode> bucket = new ArrayList();
      while(head != null){
        bucket.add(head);
        head = head.next;
      }
      // stuff int value into array
      int[] values = new int[bucket.size()];
      for (int i = 0; i< bucket.size() ;i++){
          values[i] = bucket.get(i).val;
      }
      return values;
  }
}
