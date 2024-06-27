package com.ArestiKramer.JabberPoint.controller.menucontroller;

import com.ArestiKramer.JabberPoint.controller.Command;
import com.ArestiKramer.JabberPoint.presentation.Presentation;

/**
 * <p>This is the ExitCommand, it's used in MenuController</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class ExitCommand extends Command
{
    public ExitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.presentation.exit();
    }
}