package model;

public class AvailableState implements VinylState {

  public AvailableState(Vinyl vinyl) {
    //logging takes place in setState in Vinyl class
  }

  //Sets the new state to reserved
  @Override
  public void reserveVinyl(Vinyl vinyl) {
    if (vinyl.isFlaggedForRemoval()) {
      System.out.println("Cannot reserve a vinyl that is flagged for removal.");
      return;
    }
    vinyl.setState(vinyl.getReservedState());
  }

  //Sets the new state to borrowed
  @Override
  public void borrowVinyl(Vinyl vinyl) {
     vinyl.setState(vinyl.getBorrowedState());
  }


  @Override public void returnVinyl(Vinyl vinyl)
  {
    //does nothing, because vinyl is already available
  }

  //vinyl library decides on removal
  @Override
  public void removeVinyl(Vinyl vinyl) {
    vinyl.setFlaggedForRemoval(true);
  }
}
