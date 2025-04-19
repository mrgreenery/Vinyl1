package view.show;

import javafx.fxml.FXML;
import model.Vinyl;
import viewModel.ShowViewModel;

import javafx.scene.control.ListView;

public class Show
{
  @FXML private ListView<Vinyl> listView;
  private ShowViewModel showViewModel;

  //empty constructor for FXML
  public Show ()
  {
  }

  public void init(ShowViewModel showViewModel){
    this.showViewModel=showViewModel;
    listView.setItems(showViewModel.getVinyls());
  }
}
