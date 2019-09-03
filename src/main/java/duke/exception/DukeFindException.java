package duke.exception;

public class DukeFindException extends DukeException {

    public static final String EMPTY_DETAILS_ERROR_MSG = "☹ OOPS!!! The description of a event cannot be empty.";

    /**
     * Constructs the DukeFindException object with a custom error message.
     * @param message Custom error message
     */
    public DukeFindException(String message) {
        super(message);
    }

}