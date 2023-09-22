package environment;

import lifeform.LifeForm;

/**
 * A cell that can hold a LifeForm
 *
 */
public class Cell {
  
  LifeForm lifeFormOne;
  
  /**
   * @return the LifeForm in this cell.
   */
  public LifeForm getLifeForm() {
    return lifeFormOne;
  }
  
  /**
   * Tries to add the LifeForm to the cell. Will not add if a
   * LifeForm is already present.
   * @param entity the lifeform held in the cell
   * @return true if the LifeForm is was added to the cell, false otherwise.
   */
  public boolean addLifeForm(LifeForm entity) {
    if (lifeFormOne == null) {
      lifeFormOne = entity;
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * removes lifeform from cell (sets it to null)
   */
  public void removeLifeForm() {
    lifeFormOne = null;
  }
}
