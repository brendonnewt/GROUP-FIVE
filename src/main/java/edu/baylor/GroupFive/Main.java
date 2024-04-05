package edu.baylor.GroupFive;

import javax.swing.SwingUtilities;

import edu.baylor.GroupFive.ui.landing.LandingPage;
import edu.baylor.GroupFive.ui.utils.Page;
import edu.baylor.GroupFive.ui.utils.interfaces.InputDelegate;
import edu.baylor.GroupFive.database.dbSetup;
import edu.baylor.GroupFive.util.logging.G5Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Main {
    public static final Marker RESERVATIONS = MarkerManager.getMarker("RESERVATIONS");

    public static void main(String[] args) {
        G5Logger.initLogging(args);
        Logger logger = LogManager.getLogger(Main.class);
        logger.info("Logging initiated. Invoking dbSetup...");
        dbSetup db = new dbSetup();

        logger.info("dbSetup finished. Queuing initial window/page load with swing...");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                logger.info("Loading landing page...");
                @SuppressWarnings("unused")
                InputDelegate landing = new LandingPage();
                //InputDelegate landing = new Page(null); // Will be changed to LoginPage
            }
        });
    }
}