package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import lifeform.LifeForm;

/**
 * The test cases for the environment class
 * 
 */
public class TestEnvironment {
  
  /**
   * Test basic environment with one empty cell
   */
  @Test
  public void testOneEmptyCellEnvironment() {
    Environment e = new Environment(1,1);
    assertNull(e.getLifeForm(0, 0));
  }
  
  /**
   * Test add lifeform if cell is null
   */
  @Test
  public void testAddLifeFormOne() {
    Environment e = new Environment(1,1);
    LifeForm lf = new LifeForm("Markus", 25);
    e.addLifeForm(lf, 0, 0);
    assertEquals(lf, e.getLifeForm(0, 0));
  }
  
  /**
   * Test add lifeform if cell is full already
   */
  @Test
  public void testAddLifeFormTwo() {
    Environment e = new Environment(1,1);
    LifeForm lf = new LifeForm("Markus", 25);
    LifeForm lf2 = new LifeForm("Jimmy", 55);
    e.addLifeForm(lf, 0, 0);
    e.addLifeForm(lf2, 0, 0);
    assertFalse(e.addLifeForm(lf2, 0, 0));
  }
  
  /**
   * Test add lifeform if the pos it out 
   *  of environment bounds
   */
  @Test
  public void testAddLifeFormThree() {
    Environment e = new Environment(1,1);
    LifeForm lf = new LifeForm("Jimmy", 55);
    assertFalse(e.addLifeForm(lf, 3, 2));
  }
  
  /**
   * Test that checks if there is a LifeForm in a
   *  specific position in an environment
   */
  @Test
  public void testLifeFormWithinEnvironment() {
    Environment e = new Environment(2, 3);
    LifeForm lf = new LifeForm("John", 40);
    e.addLifeForm(lf, 1, 2);
    e.getLifeForm(1,2);
    assertEquals(lf, e.getLifeForm(1, 2));
  }
  
  /**
   * Test that checks the removeLifeForm method
   */
  @Test
  public void testRemovingLifeFormFromCell() {
    Environment e = new Environment(5, 5);
    LifeForm lf = new LifeForm("Frankie", 70);
    e.addLifeForm(lf, 1, 1);
    e.removeLifeForm(1, 1);
    assertNull(e.getLifeForm(1, 1));
  }
  
  /**
   * Test that checks the removeLifeForm method if we try
   *  removing out of bounds
   */
  @Test
  public void testRemovingLifeFromCellOutOfBounds() {
    Environment e = new Environment(5, 5);
    LifeForm lf = new LifeForm("Frank", 90);
    e.removeLifeForm(7, 7);
  }
}
