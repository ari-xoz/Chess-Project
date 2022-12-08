import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChessBoard extends Application {
  private static final int TILE_SIZE = 75;
  private static final int WIDTH = 8;
  private static final int HEIGHT = 8;

  public void start(Stage primaryStage) {
    GridPane board = new GridPane();
    for (int row = 0; row < HEIGHT; row++) {
      for (int col = 0; col < WIDTH; col++) {
        Label tile = new Label();
        tile.setPrefSize(TILE_SIZE, TILE_SIZE);
        // Set the background color of the tile based on its position
        if ((row + col) % 2 == 0) {
          tile.setStyle("-fx-background-color: #ffe9c5");
        } else {
          tile.setStyle("-fx-background-color: #8d816d");
        }
        board.add(tile, col, row);
        
      }
    }
    for (int r = 0; r < HEIGHT; r++) {
      board.add(new ImageView("Pawn.png"),r,1);
      board.add(new ImageView("Pawn.png"),r,6);
    }
    board.add(new ImageView("king.png"),4,0);
    board.add(new ImageView("king.png"),4,7);
    board.add(new ImageView("Rook.png"),0,0);
    board.add(new ImageView("Rook.png"),7,7);
    board.add(new ImageView("Rook.png"),7,0);
    board.add(new ImageView("Rook.png"),0,7);
    board.add(new ImageView("Knight.png"),1,0);
    board.add(new ImageView("Knight.png"),6,0);
    board.add(new ImageView("Knight.png"),1,7);
    board.add(new ImageView("Knight.png"),6,7);
    board.add(new ImageView("Queen.png"),3,0);
    board.add(new ImageView("Queen.png"),3,7);
    board.add(new ImageView("Bishop.png"),2,0);
    board.add(new ImageView("Bishop.png"),5,0);
    board.add(new ImageView("Bishop.png"),2,7);
    board.add(new ImageView("Bishop.png"),5,7);
    board.setAlignment(Pos.CENTER);
    Scene scene = new Scene(board, WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}