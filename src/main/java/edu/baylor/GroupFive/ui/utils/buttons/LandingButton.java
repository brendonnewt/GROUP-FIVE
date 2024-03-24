package edu.baylor.GroupFive.ui.utils.buttons;

import java.awt.Dimension;

public class LandingButton extends PageButton {
    Dimension buttonSize = new Dimension(415, 120);
    
    public LandingButton(String path) {
        super(path);
        setPreferredSize(buttonSize);
        setMaximumSize(buttonSize);
        setMinimumSize(buttonSize);
    }
}
