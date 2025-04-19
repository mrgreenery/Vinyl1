package model;

public class BorrowedAndReservedState implements VinylState
{
  public BorrowedAndReservedState(Vinyl vinyl)
  {
    //logging takes place in setState in Vinyl class
  }

  @Override public void reserveVinyl(Vinyl vinyl)
  {
     //does nothing
  }

  @Override public void borrowVinyl(Vinyl vinyl)
  {
    //does nothing
  }

  @Override
  public void returnVinyl(Vinyl vinyl) {
    vinyl.setState(vinyl.getReservedState());
   }

   //vinyl library decides on removal
  @Override public void removeVinyl(Vinyl vinyl)
  {
    vinyl.setFlaggedForRemoval(true);
  }
}
