package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw03.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw03.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

public class MarbleSolitaire {
  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if(i == 0) {
        System.out.print("Game Type: ");
      }
      else {
        System.out.print("Args: ");
      }
      System.out.println(args[i]);
    }

    MarbleSolitaireModel model = null;
    MarbleSolitaireView view = null;
    MarbleSolitaireController controller;
    int[] arguments;
    switch (args[0]) {
      case "triangle":
        arguments = commands(args, 5, 0, 0);
        model = new TriangleSolitaireModel(arguments[0], arguments[1], arguments[2]);
        view = new TriangleSolitaireTextView(model);
        break;
      case "english":
        arguments = commands(args, 3, 3, 3);
        model = new EnglishSolitaireModel(arguments[0], arguments[1], arguments[2]);
        view = new MarbleSolitaireTextView(model);
        break;
      case "european":
        arguments = commands(args, 3, 3, 3);
        model = new EuropeanSolitaireModel(arguments[0], arguments[1], arguments[2]);
        view = new MarbleSolitaireTextView(model);
        break;
      default:
        throw new IllegalArgumentException("wrong input");
    }
    controller = new MarbleSolitaireControllerImpl(model, view,
            new InputStreamReader(System.in));
    controller.playGame();
  }

  private static int[] commands(String[] args, int size, int row, int col) {
    int size2 = size;
    int row2 = row;
    int col2 = col;
    if (args.length == 3 && args[1].equalsIgnoreCase("-size")) {
      size2 = Integer.parseInt(args[2]);
      col2 = (size2 * 3 - 2)/2;
      row2 = (size2 * 3 - 2)/2;
    } else if (args.length == 4 && args[1].equalsIgnoreCase("-hole")) {
      row2 = Integer.parseInt(args[2]);
      col2 = Integer.parseInt(args[3]);
    } else if (args.length == 2 || args.length > 4) {
      throw new IllegalArgumentException("invalid arguments");
    }
    return new int[]{size2, row2, col2};
  }
}
