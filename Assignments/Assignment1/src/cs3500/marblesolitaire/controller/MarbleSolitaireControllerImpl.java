package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  MarbleSolitaireView view;
  MarbleSolitaireModel model;
  Readable readable;
  Scanner sc;

  public MarbleSolitaireControllerImpl
          (MarbleSolitaireModel model, MarbleSolitaireView view, Readable readable)
          throws IllegalArgumentException {
    if (model == null || view == null || readable == null) {
      throw new IllegalArgumentException("null parameters");
    }
    this.view = view;
    this.model = model;
    this.readable = readable;
    this.sc = new Scanner(this.readable);
  }

  @Override
  public void playGame() throws IllegalStateException {
    ArrayList<Integer> toFrom;

    while (!model.isGameOver()) {
      toFrom = new ArrayList<>();
      this.showGame();
      if (sc.hasNext("q") || sc.hasNext("Q")) {
        this.quit();
        break;
      }
      this.getFromInput(toFrom);
      if (toFrom.size() != 4 || this.anyNegative(toFrom)) {
        this.invalidMove();
        continue;
      }
      this.moveModel(toFrom.get(0), toFrom.get(1), toFrom.get(2), toFrom.get(3));
    }
    this.gameOver();
  }

  private void showGame() throws IllegalStateException {
    try {
      view.renderBoard();
      view.renderMessage("\nScore: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Illegal States");
    }
  }

  private void quit() throws IllegalStateException {
    try {
      view.renderMessage("Game quit!\n");
      view.renderMessage("State of the game when quit\n");
      this.showGame();
    } catch (IOException e) {
      throw new IllegalStateException("Illegal States");
    }
  }

  private void invalidMove() throws IllegalStateException {
    try {
      view.renderMessage("Invalid move. Play again. Either negative or illegal move\n");
    } catch (IOException x) {
      throw new IllegalStateException("Illegal States");
    }
  }

  private void getFromInput(ArrayList<Integer> toFrom) {
    for (int i = 0; i < 4; i++) {
      toFrom.add(sc.nextInt());
    }
  }

  private boolean anyNegative(ArrayList<Integer> toFrom) {
    for (int i = 0; i < 4; i++) {
      if (toFrom.get(i) < 0) {
        return true;
      }
    }
    return false;
  }

  private void moveModel(int sRow, int sCol, int eRow, int eCol) throws IllegalStateException {
    try {
      model.move(sRow, sCol, eRow, eCol);
    } catch (IllegalArgumentException e) {
      this.invalidMove();
    }
  }

  private void gameOver() throws IllegalStateException {
    try {
      view.renderMessage("Game over!\n");
      this.showGame();
    } catch (IOException e) {
      throw new IllegalStateException("Illegal States");
    }
  }
}

