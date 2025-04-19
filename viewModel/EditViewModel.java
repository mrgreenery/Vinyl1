package viewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vinyl;
import model.VinylLibrary;

import java.beans.PropertyChangeListener;

public class EditViewModel
{
  private ObservableList<Vinyl> vinyls = FXCollections.observableArrayList();
  private PropertyChangeListener listener;
  private VinylLibrary vinylLibrary;

  public EditViewModel(VinylLibrary vinylLibrary)
  {
    this.vinylLibrary = vinylLibrary;
    vinyls.addAll(vinylLibrary.getVinyls());

    listener = evt -> Platform.runLater(() -> {
      vinyls.clear();
      vinyls.addAll(vinylLibrary.getVinyls());
    });
    vinylLibrary.addPropertyChangeListener("stateChanged", listener);
  }

  public ObservableList<Vinyl> getVinyls()
  {
    return vinyls;
  }

  public void reserveVinyl(Vinyl selected){vinylLibrary.reserveVinyl(selected);  }
  public void borrowVinyl(Vinyl selected) {vinylLibrary.borrowVinyl(selected);  }
  public void returnVinyl(Vinyl selected) {vinylLibrary.returnVinyl(selected);  }
  public boolean removeVinyl(Vinyl selected) {return vinylLibrary.removeVinyl(selected);
  }
}
