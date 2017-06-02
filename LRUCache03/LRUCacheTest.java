/**
* @author Xiqing chu
*/

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LRUCacheTest {
  @Test
  public void evaluatesExpression() {
    LRUCache obj = new LRUCache(10);
    obj.put(1,10);
    assertEquals(10, obj.get(1));
  }

  @Test
  public void empty(){
    LRUCache obj = new LRUCache(10);
    assertEquals(-1, obj.get(1));
  }

  @Test
  public void overload(){
      LRUCache obj = new LRUCache(2);
      obj.put(1,1);
      obj.put(2,2);
      obj.put(3,3);
      assertEquals(-1, obj.get(1));
  }

  @Test
  public void recent(){
      LRUCache obj = new LRUCache(2);
      obj.put(1,1);
      obj.put(2,2);
      assertEquals(1, obj.get(1));
      obj.put(3,3);
      assertEquals(1, obj.get(1));
  }

  @Test
  public void more(){
      LRUCache obj = new LRUCache(20);
      for (int i=0; i<=20; i++){
          obj.put(i,i);
      }
      assertEquals(15, obj.get(15));
      obj.get(1);
      obj.get(3);
      obj.put(21,21);
      obj.put(22,22);
      obj.put(23,23);
      assertEquals(1, obj.get(1));
      assertEquals(-1, obj.get(2));
      assertEquals(3, obj.get(3));
  }
}