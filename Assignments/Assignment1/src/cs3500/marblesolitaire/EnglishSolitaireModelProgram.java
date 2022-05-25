package cs3500.marblesolitaire;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

public class EnglishSolitaireModelProgram {
  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel(3);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(model, view, br);
    controller.playGame();
  }
}
