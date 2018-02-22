package walkgame;

import gameloop.GameLoop;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        View view = new View(primaryStage);
        Controller controller = new Controller(view);
        new GameLoop(view).start();

        primaryStage.setScene(view.scene);

        primaryStage.setTitle("WalkGame");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
