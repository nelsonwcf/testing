package scraps;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeletionDistanceNewSolutionTest extends TestCase {

  @BeforeEach
  protected void setUp() {
  }

  @AfterEach
  protected void tearDown() {
  }

  @Test
  public void deletionDistance1() {
    assertEquals("1st Test", 0, DeletionDistanceNewSolution.deletionDistance("",""));
  }

  @Test
  public void deletionDistance2() {
    assertEquals("2nd Test", 3, DeletionDistanceNewSolution.deletionDistance("","hit"));
  }

  @Test
  public void deletionDistance3() {
    assertEquals("3rd Test", 4, DeletionDistanceNewSolution.deletionDistance("neat",""));
  }

  @Test
  public void deletionDistance4() {
    assertEquals("4th Test", 3, DeletionDistanceNewSolution.deletionDistance("heat","hit"));
  }

  @Test
  public void deletionDistance5() {
    assertEquals("5th Test", 2, DeletionDistanceNewSolution.deletionDistance("hot","not"));
  }

  @Test
  public void deletionDistance6() {
    assertEquals("6th Test", 9, DeletionDistanceNewSolution.deletionDistance("some","thing"));
  }
  @Test
  public void deletionDistance7() {
    assertEquals("7th Test", 1, DeletionDistanceNewSolution.deletionDistance("abc","adbc"));
  }
  @Test
  public void deletionDistance8() {
    assertEquals("8th Test", 0, DeletionDistanceNewSolution.deletionDistance("awesome","awesome"));
  }
  @Test
  public void deletionDistance9() {
    assertEquals("9th Test", 2, DeletionDistanceNewSolution.deletionDistance("ab","ba"));
  }
}