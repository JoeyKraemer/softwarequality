package com.ArestiKramer.JabberPoint.controller.keycontroller;

import com.ArestiKramer.JabberPoint.controller.Command;
import com.ArestiKramer.JabberPoint.controller.Receiver;
import com.ArestiKramer.JabberPoint.presentation.Presentation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <p>This is the KeyController, it executes commands when keys are pressed</p>
 *
 * @author Caterina Aresti & Joey Kramer
 * @version 2.0 2024/04/07
 */

public class KeyController extends KeyAdapter implements Receiver
{
    private final Presentation presentation;
    private final NextSlideCommand nextSlideCommand;
    private final PreviousSlideCommand previousSlideCommand;
    private final QuitCommand quitCommand;

    public KeyController(Presentation presentation)
    {
        this.presentation = presentation;
        this.nextSlideCommand = new NextSlideCommand(this.presentation);
        this.previousSlideCommand = new PreviousSlideCommand(this.presentation);
        this.quitCommand = new QuitCommand(this.presentation);
    }

    @Override
    public void executeCommand(Command command)
    {
        command.execute();
    }

    public void keyPressed(KeyEvent keyEvent)
    {

        switch (keyEvent.getKeyCode())
        {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
                executeCommand(this.nextSlideCommand);
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
                executeCommand(this.previousSlideCommand);
                break;
            case KeyEvent.VK_Q:
                executeCommand(this.quitCommand);
                break;
            default: // check for characters on any keyboard type. Note: .getKeyCode() only works on QWERTY
                switch (keyEvent.getKeyChar()) {
                    case '+':
                        executeCommand(this.nextSlideCommand);
                        break;
                    case '-':
                        executeCommand(this.previousSlideCommand);
                        break;
                    default:
                }
                break;
        }
    }
}
