package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class VinylLibrary implements PropertyChangeSubject {
  private List<Vinyl> vinyls;
  private PropertyChangeSupport support;

  public VinylLibrary() {
    vinyls = new ArrayList<>();
    support = new PropertyChangeSupport(this);

    //test date
    addVinyl(new Vinyl("Blackbird", "Alter Bridge", 2007));
    addVinyl(new Vinyl("The Concrete Confessional", "Hatebreed", 2016));
    addVinyl(new Vinyl("Around the Fur", "Deftones", 1997));
    addVinyl(new Vinyl("Cease to Begin", "Band of Horses", 2007));
    addVinyl(new Vinyl("Continuum", "John Mayer", 2006));
    addVinyl(new Vinyl("Origin of Symmetry", "Muse", 2001));
    addVinyl(new Vinyl("Follow The Leader", "Korn", 1998));
    addVinyl(new Vinyl("Nevermind", "Nirvana", 1991));
    addVinyl(new Vinyl("Dookie",  "Green Day", 1994));
    addVinyl(new Vinyl("A Black Mile To The Surface", "Manchester Orchestra", 2017));

  }

  //adds a new vinyl to library
  public void addVinyl(Vinyl vinyl) {
    if (vinyl != null && !vinyls.contains(vinyl)) {
      vinyls.add(vinyl);
      vinyl.setVinylLibrary(this);
      notifyStateChanged(vinyl);
    }
  }

  //removes a vinyl if it is available, otherwise marks for removal
  public boolean removeVinyl(Vinyl vinyl) {
    if (vinyl == null) return false;

    if (vinyl.getCurrentState() instanceof AvailableState) {
      vinyls.remove(vinyl);
      System.out.println("Vinyl is removed from the library.");
      notifyStateChanged(vinyl);
      return true;
    } else {
      vinyl.setFlaggedForRemoval(true);
      System.out.println("Vinyl is flagged for removal once it is returned.");
      notifyStateChanged(vinyl);
      return false;
    }
  }

  // returns vinyl to library. If marked for removal, then removes
  public void returnVinyl(Vinyl vinyl) {
    if (vinyl == null) return;

    vinyl.getCurrentState().returnVinyl(vinyl);

    if (vinyl.isFlaggedForRemoval() && vinyl.getCurrentState() instanceof AvailableState) {
      vinyls.remove(vinyl);
      System.out.println("Vinyl removed after return.");
    }

    notifyStateChanged(vinyl);
  }

  //borrows a vinyl from library if current state allows it
  public void borrowVinyl(Vinyl vinyl) {
    if (vinyl == null) return;

    vinyl.getCurrentState().borrowVinyl(vinyl);
    notifyStateChanged(vinyl);
  }

  //reservers a vinyl from library if current state allows it
  public void reserveVinyl(Vinyl vinyl)
  {
    if (vinyl == null) return;

    vinyl.getCurrentState().reserveVinyl(vinyl);
    notifyStateChanged(vinyl);
  }

  //return a list of all vinyls
  public List<Vinyl> getVinyls() {
    return vinyls;
  }

  //Observer pattern: ads a listener to all properties
  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  //adds a listener to specific properties
  @Override
  public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
    support.addPropertyChangeListener(name, listener);
  }

  //removes a listener of all properties
  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }

  //removes a listener from specific properties
  @Override
  public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
    support.removePropertyChangeListener(name, listener);
  }

  //notifies observers that vinyl state has been changed
  void notifyStateChanged(Vinyl vinyl) {
    support.firePropertyChange("stateChanged", null, vinyl);
  }
}
