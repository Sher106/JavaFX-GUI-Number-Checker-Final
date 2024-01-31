//**************************************************************************

// Project.java     Author: Hall/ Sherica
//
//Demonstrates Number Checker, Image Display and Scene change in GUI
//*************************************************************************

//Imports for JavaFX functioning in the code
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

//Creating a Class to build the code in, so that everything happens within the Project
public class Project extends Application
{

    //Declaring individual components so that they can be used throughout the code
    protected Text text = new Text(30, 20, "Counter");
    public RadioButton leftButton, rightButton;
    public Image img;
    public VBox finalStack;
    public TextField num;
    public ImageView imageView;
    public int number;

//Start is a class in the Application
    @Override
    public void start(Stage primaryStage)
    {

        // Creating RadioButtons, its specifications and action response
        HBox paneForRadioButtons = new HBox(20);

        num = new TextField();
        num.setOnAction(this::processButtonPress);

        ToggleGroup group = new ToggleGroup();

        leftButton = new RadioButton("Left");  // Labeling Button
        leftButton.setToggleGroup(group);
        leftButton.setTranslateY(10);  //Positioning Button in the Y plane

        rightButton = new RadioButton("Right");  //Labeling Button
        rightButton.setToggleGroup(group);
        rightButton.setTranslateY(10);  //Positioning Button in the Y plane


        paneForRadioButtons.getChildren().addAll(leftButton, rightButton);
        paneForRadioButtons.setAlignment(Pos.CENTER); //Setting general position of RadioButton


        // Creating Buttons
        HBox paneForButtons = new HBox(20);
        Button submit = new Button("Submit");
        submit.setOnAction(this::processButtonPress);
        paneForButtons.getChildren().addAll(submit);
        paneForButtons.setAlignment(Pos.CENTER);
        submit.setTranslateY(20);

        // Creating Image specifications
        imageView = new ImageView(img);  //Creating a stage for image to be seen

        //Positioning image
        imageView.setViewport(new Rectangle2D(60, 60, 400, 500));
        imageView.setTranslateY(40);
        imageView.setTranslateX(40);

        finalStack = new VBox(text, num, paneForRadioButtons, paneForButtons, imageView);
        finalStack.setStyle("-fx-background-color: lightgreen");

        // Create a scene and place it in the stage
        Scene scene = new Scene(finalStack, 500, 600);
        primaryStage.setTitle("Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//Creating instructions for button so image changes and background changes
    private void processButtonPress(ActionEvent event) {
        if (leftButton.isSelected()) {
            finalStack.setStyle("-fx-background-color: lightpink"); //Setting a style for left button
        } else if (rightButton.isSelected()) {
            finalStack.setStyle("-fx-background-color: purple");  //Setting a style for right button
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

    //Where execution of method created starts
    public static void main(String[] args) {
        launch(args);
    }
}


