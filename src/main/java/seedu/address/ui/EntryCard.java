package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import seedu.address.model.account.entry.Entry;

public class EntryCard extends UiPart<Node> {

    private static final String FXML = "EntryCard.FXML";

    public final Entry entry;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label amount;
    @FXML
    private Label description;
    @FXML
    private Label entryCategory;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code EntryCard} with the given {@code entry } and index to display.
     */
    public EntryCard(Entry entry, int displayIndex) {
        super(FXML);
        this.entry = entry;
        id.setText(displayIndex + ". ");
        amount.setText(entry.getAmount().toString());
        description.setText(entry.getDescription().toString());
        // TODO: change this to Catergory
        // entryCategory.setText(entry.getCategory());
        entry.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EntryCard)) {
            return false;
        }

        // state check
        EntryCard card = (EntryCard) other;
        return id.getText().equals(card.id.getText())
                && entry.equals(card.entry);
    }
}
