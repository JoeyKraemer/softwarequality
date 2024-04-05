package jabberpoint.controller.menucontroller;

import jabberpoint.Presentation;
import jabberpoint.controller.Command;

public class ExitCommand extends Command {
    public ExitCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.exit(0);
    }
}
