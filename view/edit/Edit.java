package view.edit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Vinyl;
import viewModel.EditViewModel;

public class Edit {
  @FXML private ListView<Vinyl> listView;
  @FXML private Label stateMessage;
  private EditViewModel editViewModel;

  public void init(EditViewModel editViewModel) {
    this.editViewModel = editViewModel;
    listView.setItems(editViewModel.getVinyls());

    listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
      stateMessage.setText(""); // deletes the stateMessage label if another vinyl is selected
    });
  }


  @FXML
  private void onReserve() {
    Vinyl selected = listView.getSelectionModel().getSelectedItem();
    if (selected != null) {
      editViewModel.reserveVinyl(selected);
      stateMessage.setText("Reserved: " + selected);
    } else {
      stateMessage.setText("No vinyl selected to reserve.");
    }
  }

  @FXML
  private void onBorrow() {
    Vinyl selected = listView.getSelectionModel().getSelectedItem();
    if (selected != null) {
      editViewModel.borrowVinyl(selected);
      stateMessage.setText("Borrowed: " + selected);
    } else {
      stateMessage.setText("No vinyl selected to borrow.");
    }
  }

  @FXML
  private void onReturn() {
    Vinyl selected = listView.getSelectionModel().getSelectedItem();
    if (selected != null) {
      editViewModel.returnVinyl(selected);
      stateMessage.setText("Returned: " + selected);
    } else {
      stateMessage.setText("No vinyl selected to return.");
    }
  }

  @FXML
  private void onRemove() {
    Vinyl selected = listView.getSelectionModel().getSelectedItem();
    if (selected != null) {
      boolean removed = editViewModel.removeVinyl(selected);
      if (removed) {
        stateMessage.setText("Removed: " + selected);
      } else {
        stateMessage.setText("Flagged for removal: " + selected);
      }
    } else {
      stateMessage.setText("No vinyl selected to remove.");
    }
  }

}
