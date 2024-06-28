package com.ArestiKramer.JabberPoint.controller.keycontroller;

import com.ArestiKramer.JabberPoint.presentation.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

public class KeyControllerTest {

    private static class PresentationStub extends Presentation {
        int nextSlideCalls = 0;
        int previousSlideCalls = 0;
        int exitCalls = 0;

        @Override
        public void nextSlide() {
            nextSlideCalls++;
        }

        @Override
        public void previousSlide() {
            previousSlideCalls++;
        }

        @Override
        public void exit() {
            exitCalls++;
        }
    }

    private PresentationStub presentation;
    private KeyController keyController;

    @BeforeEach
    void setup() {
        presentation = mock(PresentationStub.class);
        keyController = new KeyController(presentation);
    }

    @Test
    void nextSlideCommand_caseNextSlide_fourExecutions() {
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 0, '+'));

        verify(presentation, times(4)).nextSlide();
    }

    @Test
    void previousSlideCommand_casePreviousSlide_threeExecutions() {
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED));
        keyController.keyPressed(new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, 0, '-'));

        verify(presentation, times(3)).previousSlide();
    }
}