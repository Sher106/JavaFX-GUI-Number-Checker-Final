import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.text.Text;

class Project2 extends Application {
    protected Text text = new Text(30, 20, "Counter");
    public RadioButton leftButton, rightButton;
    public Image img, img2;
    public VBox finalStack;
    public TextField num;
    public ImageView imageView;
    public String url, url2;
    public Button submit;
    public Stage primaryStage;
    public int number;

    @Override
    public void start(Stage primaryStage) {
        // Creating RadioButtons
        HBox paneForRadioButtons = new HBox(20);

        num = new TextField();
        num.setOnAction(this::processButtonPress);

        ToggleGroup group = new ToggleGroup();

        leftButton = new RadioButton("Left");
        leftButton.setToggleGroup(group);

        rightButton = new RadioButton("Right");
        rightButton.setToggleGroup(group);


        paneForRadioButtons.getChildren().addAll(leftButton, rightButton);
        paneForRadioButtons.setAlignment(Pos.CENTER);


        // Creating Buttons
        HBox paneForButtons = new HBox(20);
        Button submit = new Button("Submit");
        submit.setOnAction(this::processButtonPress);
        paneForButtons.getChildren().addAll(submit);
        paneForButtons.setAlignment(Pos.CENTER);

        // Input Image

        imageView = new ImageView(img);

        imageView.setViewport(new Rectangle2D(60, 60, 300, 300));


        finalStack = new VBox(text, num, paneForRadioButtons, paneForButtons, imageView);
        finalStack.setStyle("-fx-background-color: lightgreen");

        // Create a scene and place it in the stage
        Scene scene = new Scene(finalStack, 450, 500);
        primaryStage.setTitle("Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void processButtonPress(ActionEvent event) {
        if (leftButton.isSelected()) {
            finalStack.setStyle("-fx-background-color: lightpink");
        } else if (rightButton.isSelected()) {
            finalStack.setStyle("-fx-background-color: purple");
        } else {
            finalStack.setStyle("-fx-background-color: lightgreen");
        }

        number = Integer.parseInt(num.getText());
        if (number % 2 == 0) {
            img = new Image("red-cross.gif");
        } else {
            img = new Image("oh-oh-no.gif");
        }
        imageView.setImage(img);
    }


    //Method for Submit Button


    public static void main(String[] args) {
        launch(args);
    }
}


