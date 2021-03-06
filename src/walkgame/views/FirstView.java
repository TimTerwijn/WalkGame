package walkgame.views;

import walkgame.controllers.FirstController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import walkgame.objects.Floor;
import walkgame.objects.Player;
import walkgame.objects.microObjects.Coordinate;

public class FirstView extends View
{
    private FirstController firstController;
    public Player player;

    private Group root;
    public Scene scene;
    private Stage primaryStage;

    private static Coordinate screenSize = new Coordinate(300, 300);
    private Coordinate gameSize = new Coordinate(400, 400);
    public static Coordinate screenCenter = new Coordinate(screenSize.getX() / 2f, screenSize.getY() / 2f);

    public FirstView(Stage primaryStage)
    {
        firstController = new FirstController(this);
        player = new Player(screenCenter, "Jack");

        createFloor();
        createRoot();
        createScene();

        this.primaryStage = primaryStage;
    }



    @Override
    public void render()
    {

    }



    private void createFloor()
    {
        new Floor(player.getX(), player.getY(), new Image("walkgame/res/floor1.png"));
        new Floor(Floor.floorList.get(0).getX() + new Image("walkgame/res/floor1.png").getWidth(), player.getY(), new Image("walkgame/res/floor1.png"));
    }

    @Override
    protected void createRoot()
    {
        Pane map = new Pane();
        for (Floor f : Floor.floorList) {
            map.getChildren().add(f);
        }

        map.setMinSize(gameSize.getX(), gameSize.getY());
        root = new Group(map, player);
    }

    @Override
    protected void createScene()
    {
        scene = new Scene(root, FirstView.screenSize.getX(), FirstView.screenSize.getY(), Color.BLACK);

        scene.setOnKeyPressed(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                firstController.pressButton(k);
            }
        });

        scene.setOnKeyReleased(event -> {
            KeyCode k = event.getCode();
            if(k == KeyCode.W || k == KeyCode.D || k == KeyCode.S || k == KeyCode.A)
            {
                firstController.releaseButton(k);
            }
        });
    }
}