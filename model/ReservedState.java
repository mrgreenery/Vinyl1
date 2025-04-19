package model;

public class ReservedState implements VinylState
{
  public ReservedState(Vinyl vinyl)
  {
    //logging takes place in setState in Vinyl class
  }

  @Override public void reserveVinyl(Vinyl vinyl)
  {
    //does nothing
  }

  @Override public void borrowVinyl(Vinyl vinyl)
  {
     vinyl.setState(vinyl.getBorrowedState());
  }

  @Override public void returnVinyl(Vinyl vinyl)
  {
    //does nothing
  }

  //vinyl library decides on removal
  @Override public void removeVinyl(Vinyl vinyl)
  {
    vinyl.setFlaggedForRemoval(true);
  }
}
