package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;

/**
 * The test cases for the cell class
 * 
 */
public class TestCell {
  /**
   * At initialization, the Cell should be empty and not contain a
   * LifeForm
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }
  
  /**
   * Checks to see if we change the LifeForm held by the cell that
   * getLifeForm properly responds to this change.
   */
  @Test
  public void testAddLifeForm() {
    LifeForm bob = new LifeForm("Bob", 40);
    LifeForm fred = new LifeForm("Fred", 40);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    // The cell is not empty so this should fail.
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }
  
  /**
   * tests the remove lifeform method
   */
  @Test
  public void testRemoveLifeForm() {
    LifeForm bob = new LifeForm("Bob", 45);
    Cell cell = new Cell();
    cell.addLifeForm(bob);
    cell.removeLifeForm();
    assertNull(cell.getLifeForm());
  }
  
  @Test
  public void testAddLifeFormIfPresent() {
    LifeForm jill = new LifeForm("Jill", 120);
    LifeForm timmy = new LifeForm("Timmy", 12);
    Cell cell = new Cell();
    cell.addLifeForm(jill);
    assertFalse(cell.addLifeForm(timmy));
  }
}
