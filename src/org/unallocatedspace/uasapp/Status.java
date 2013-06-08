package org.unallocatedspace.uasapp;

import android.app.Activity;
import java.lang.String;
import java.net.MalformedURLException;

/**
 * This class is a container which keeps other objects.
 */
public class Status {
    private static final String OCCUPANCY_SENSOR =
        "http://www.unallocatedspace.org/status";
    private Info space;
    private String spaceStatus;

/**
 * Creates member objects from the Info class and adds them to the array
 * members.
 */
    Status(Activity activity) {
        try {
           this.space = new Info(activity, OCCUPANCY_SENSOR);
           this.refresh();
        } catch(MalformedURLException e) {
/* We should catch this exception but I don't know where to log it or how better
 * to handle it. Will update this later.
 */
        }
    }

/**
 * Refreshes all member objects.
 *
 * Calls getMessage() methods of all other objects to keep them up to date.
 * Each time the activity page awakens, it will call this method to ensure
 * freshness.
 */
    public void refresh() {
        this.spaceStatus = this.space.getMessage();
    }
}
