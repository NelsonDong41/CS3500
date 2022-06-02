package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * class for the MarbleSolitaireController.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  MarbleSolitaireView view;
  MarbleSolitaireModel model;
  Readable readable;
  Scanner sc;

  /**
   * constructor for the MarbleSolitaireControllerImpl Object.
   *
   * @param model    : the game
   * @param view     : the view for the game
   * @param readable : input to the game
   * @throws IllegalArgumentException : if any of the params are null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable readable)
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
    ArrayList<Integer> invalids;
    boolean gameOver = false;

    while (!model.isGameOver()) {
      toFrom = new ArrayList<>();
      invalids = new ArrayList<>();
      this.showGame();

      while (toFrom.size() < 4) {
        if (sc.hasNext("q") || sc.hasNext("Q")) {
          this.quit();
          gameOver = true;
          break;
        } else if (sc.hasNextInt()) {
          toFrom.add(sc.nextInt() - 1);
          if (toFrom.get(toFrom.size() - 1) < 0) {
            invalids.add(toFrom.remove(toFrom.size() - 1));
            this.invalidInput();
          }
        } else if (sc.hasNext()) {
          this.invalidInput();
          sc.next();
        } else if (toFrom.size() < 4 && !sc.hasNext()) {
          throw new IllegalStateException("does not end");
        }
      }

      if (!gameOver) {
        this.moveModel(toFrom.get(0),
                toFrom.get(1),
                toFrom.get(2),
                toFrom.get(3));
      } else {
        break;
      }
    }
    if (model.isGameOver()) {
      this.gameOver();
    }
  }

  private void showGame() throws IllegalStateException {
    try {
      view.renderBoard();
      view.renderMessage("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Illegal States");
    }
  }

  private void quit() throws IllegalStateException {
    try {
      view.renderMessage("Game quit!\n");
      view.renderMessage("State of game when quit:\n");
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

  private void invalidInput() throws IllegalStateException {
    try {
      view.renderMessage("Invalid input, Please enter new one\n");
    } catch (IOException e) {
      throw new IllegalStateException("Illegal States");
    }
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

