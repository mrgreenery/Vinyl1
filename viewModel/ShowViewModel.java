package viewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vinyl;
import model.VinylLibrary;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ShowViewModel
{
  private ObservableList<Vinyl> vinyls = FXCollections.observableArrayList();
  private PropertyChangeListener listener;
  private VinylLibrary vinylLibrary;


  public ShowViewModel(VinylLibrary vinylLibrary)
  {
    this.vinylLibrary=vinylLibrary;
    vinylLibrary.addPropertyChangeListener("stateChanged", this::update);
    vinyls.addAll(vinylLibrary.getVinyls());
  }

  //private, because it is only used within this class.
  private void update(PropertyChangeEvent propertyChangeEvent)
  {
    Platform.runLater(() -> {
      vinyls.clear();
      vinyls.addAll(vinylLibrary.getVinyls());
    });
  }

  public ObservableList<Vinyl> getVinyls(){
    return vinyls;
  }

}
