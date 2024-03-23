package edu.baylor.GroupFive.ui.utils.buttons;
import edu.baylor.GroupFive.ui.utils.DashboardButton;
import edu.baylor.GroupFive.ui.utils.interfaces.InputDelegate;

public class AddReservationButton extends DashboardButton {
    public AddReservationButton(InputDelegate page, String path) {
        super(path);
        addActionListener(e -> {
            page.onPageSwitch("addReservation");
        });
    }
}
