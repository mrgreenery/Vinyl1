package model;

public class BorrowedState implements VinylState {

  public BorrowedState(Vinyl vinyl) {
    //logging takes place in setState in Vinyl class
  }

  @Override
  public void reserveVinyl(Vinyl vinyl) {
    if (vinyl.isFlaggedForRemoval()) {
      System.out.println("Cannot reserve a vinyl that is flagged for removal.");
      return;
    }
    vinyl.setState(vinyl.getBorrowedAndReservedState());
  }

  @Override
  public void borrowVinyl(Vinyl vinyl) {
    //no action
  }

  @Override
  public void returnVinyl(Vinyl vinyl) {
     vinyl.setState(vinyl.getAvailableState());
  }

  //vinyl library decides on removal
  @Override
  public void removeVinyl(Vinyl vinyl) {
     vinyl.setFlaggedForRemoval(true);
  }
}
