package mouselistener.service;

import mouselistener.events.MouseButtonsEvent;
import mouselistener.events.MouseButtonsEventListener;

/**
 * Created by Daniel on 27/12/2013.
 */
public class MouseButtonListener implements MouseButtonsEventListener{
    @Override
    public void buttonsPressed(MouseButtonsEvent event) {
        System.err.println("Vote is " + event.getNumericalValue());
    }
}
