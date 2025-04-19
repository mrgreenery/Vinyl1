package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.VinylLibrary;
import simulation.Simulator;
import view.edit.Edit;
import view.show.Show;
import viewModel.EditViewModel;
import viewModel.ShowViewModel;

public class VinylApp extends Application {
  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    VinylLibrary sharedLibrary = new VinylLibrary();
    EditViewModel editViewModel = new EditViewModel(sharedLibrary);
    ShowViewModel showViewModel = new ShowViewModel(sharedLibrary);

    // Show View
    FXMLLoader showLoader = new FXMLLoader(getClass().getResource("/view/show/show.fxml"));
    Parent showRoot = showLoader.load();
    Show showController = showLoader.getController();
    showController.init(showViewModel);

    Stage showStage = new Stage();
    showStage.setScene(new Scene(showRoot));
    showStage.setTitle("Vinyl Library - View Only");
    showStage.setX(100);
    showStage.setY(100);
    showStage.show();

    // Edit View
    FXMLLoader editLoader = new FXMLLoader(getClass().getResource("/view/edit/edit.fxml"));
    Parent editRoot = editLoader.load();
    Edit editController = editLoader.getController();
    editController.init(editViewModel);

    Stage editStage = new Stage();
    editStage.setScene(new Scene(editRoot));
    editStage.setTitle("Vinyl Library - Edit View");
    editStage.setX(750);
    editStage.setY(100);
    editStage.show();

//    Simulator simulator = new Simulator(sharedLibrary);
//    Thread simThread = new Thread(simulator);
//    simThread.setDaemon(true);
//    simThread.start();

  }

}
