package bot.duke.ui;

import bot.duke.Duke;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class GuiWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    @FXML
    public void initialize() {
        CmdUx.setGuiWindow(this);
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        addLabelToDialogBox(">>>" + input + "\n");
        duke.getResponse(input);
        userInput.clear();
    }

    /**
     * Adds the specified String into the dialog container as a Label.
     *
     * @param input String to add to the dialog container as a Label.
     */
    @FXML
    public void addLabelToDialogBox(String input) {
        Label output = new Label(input);
        output.setWrapText(false);
        output.setTextFill(Color.GREEN);
        dialogContainer.getChildren().add(output);
    }
}