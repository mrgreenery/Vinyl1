package simulation;

import model.Vinyl;
import model.VinylLibrary;

import java.util.List;
import java.util.Random;

public class Simulator implements Runnable {
  private VinylLibrary vinylLibrary; //share library used by the app
  private Random random = new Random();//randommnr generator

  //constructor receives the vinyl Library
  public Simulator(VinylLibrary vinylLibrary) {
    this.vinylLibrary = vinylLibrary;
  }


  //run methods, loops until interrupted. No more actions when list is empty.
  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(2000 + random.nextInt(3000)); //waits 2 to 5 sec between actions
      } catch (InterruptedException e) {
        break; // stops the thread
      }

      //gets the list of current vinyls
      List<Vinyl> vinyls = vinylLibrary.getVinyls();
      //if list is empty, skip the cycle.
      if (vinyls.isEmpty()) continue;

      //select a random vinyl
      Vinyl selected = vinyls.get(random.nextInt(vinyls.size()));
      //choose a random action
      int action = random.nextInt(4); // 0 = reserve, 1 = borrow, 2 = return, 3 = remove

      //the chosen action
      switch (action) {
        case 0 -> vinylLibrary.reserveVinyl(selected);
        case 1 -> vinylLibrary.borrowVinyl(selected);
        case 2 -> vinylLibrary.returnVinyl(selected);
        case 3 -> vinylLibrary.removeVinyl(selected);
      }

      //print to console what happened
      System.out.println("Simulated user performed action " + action + " on " + selected);
    }
  }
}
