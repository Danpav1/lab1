package environment;

import lifeform.LifeForm;

/**
 * Keeps track of the environment of the game
 */
public class Environment {
  private Cell[][] cells;
  
  /**
   * Constructor that creates an environment (2d boolean array of cells which 
   * hold lifeforms) of size rows, cols
   * @param x
   * @param y
   */
  public Environment(int rows, int cols) {
    cells = new Cell[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        cells[r][c] = new Cell();
  
      }
    }
  }
  
  /**
  * Returns a cell at pos row, col
  * @param row
  * @param col
  * @return LifeForm
  */
  public LifeForm getLifeForm(int row, int col) {
    return cells[row][col].getLifeForm();
  }
  
  /**
   * Adds a cell that is given to pos row, col
   * @param lf
   * @param row
   * @param col
   */
  public boolean addLifeForm(LifeForm lf, int row, int col) {
    if (!isInBounds(row, col)) {
      return false;
    } else if (cells[row][col].getLifeForm() != null) {
      return false;
    } else {
      cells[row][col].addLifeForm(lf);
      return true;
    }
  }
  
  /**
   * Removes a lifeform from pos row, col. returns nothing
   *  if cell is already empty
   * @param row
   * @param col
   */
  public void removeLifeForm(int row, int col) {
    if (!isInBounds(row, col)) {
      return;
    } else {
      cells[row][col].removeLifeForm();
      return;
    }
  }
  
  /**
   * Helper function that checks if input row, col is within cells
   *  bounds.
   * @param row
   * @param col
   * @return
   */
  public boolean isInBounds(int row, int col) {
    return (row < cells.length && col < cells[0].length && row >= 0 && col >= 0);
  }
}
