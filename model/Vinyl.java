package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vinyl{
  private VinylState currentState;
  private VinylState availableState, borrowedAndReservedState, borrowedState, reservedState;
  private String title;
  private String artist;
  private int releaseYear;
  private boolean flaggedForRemoval = false;
  private VinylLibrary vinylLibrary;

  //constructor: initializes vinyl with parameters and sets the start state to available.
  public Vinyl (String title, String artist, int releaseYear)
  {
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;

    this.availableState = new AvailableState(this);
    this.reservedState = new ReservedState(this);
    this.borrowedState = new BorrowedState(this);
    this.borrowedAndReservedState = new BorrowedAndReservedState(this);
    this.currentState = availableState;
  }

  //getters for different states
  public VinylState getReservedState(){return reservedState;}
  public VinylState getAvailableState(){return availableState; }
  public VinylState getBorrowedState(){return borrowedState;}
  public VinylState getBorrowedAndReservedState(){return borrowedAndReservedState;}


  public void reserveVinyl() {currentState.reserveVinyl(this);}
  public void borrowVinyl(){currentState.borrowVinyl(this);}
  public void returnVinyl(){currentState.returnVinyl(this);}
  public void removeVinyl(){currentState.removeVinyl(this);}

  //changes current state and notifies the library (observer)
  public void setState(VinylState state)
  {
    VinylState oldState = this.currentState;
    this.currentState = state;
    //Log for state change:
    System.out.println("State changed from " + oldState.getClass().getSimpleName()
    +" to " +state.getClass().getSimpleName()+".");

    if(vinylLibrary != null)
    {
    vinylLibrary.notifyStateChanged(this);
    }
  }

  //getter for current state
  public VinylState getCurrentState()
  {
    return currentState;
  }

  public boolean isFlaggedForRemoval() {
    return flaggedForRemoval;
  }

  //sets flag for removal
  public void setFlaggedForRemoval(boolean flagged)
  {
      this.flaggedForRemoval = flagged;
  }

  //sets vinyl library (where the vinyl object belongs to)
  public void setVinylLibrary(VinylLibrary vinylLibrary)
  {
    this.vinylLibrary = vinylLibrary;
  }

  @Override
  public String toString() {
    String stateName = currentState.getClass().getSimpleName().replace("State", "");
    return title + " - " + artist + " (" + releaseYear + ") [" + stateName + "]";
  }

}
