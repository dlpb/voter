package mouselistener.service;

import mouselistener.events.MouseButtonsEvent;
import mouselistener.events.MouseButtonsEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 27/12/2013.
 */
public class MouseButtonsService {
    private List<MouseButtonsEventListener> listeners = new ArrayList<MouseButtonsEventListener>();

    public void addListener(MouseButtonsEventListener listener){
        listeners.add(listener);
    }

    public void fireEvent(MouseButtonsEvent event){
        for(MouseButtonsEventListener l: listeners)
            l.buttonsPressed(event);
    }
}
