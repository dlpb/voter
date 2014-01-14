package mouselistener.service;

import mouselistener.events.MouseButtonsEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Daniel on 27/12/2013.
 */
public class MouseListener implements NativeMouseListener {

    private Timer countdown;
    private MouseButtonsEvent event = new MouseButtonsEvent();
    private MouseButtonsService mbs;

    public MouseListener(MouseButtonsService mbs) {
        this.mbs = mbs;
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        //DO NOTHING
    }

    @Override
    public void nativeMousePressed(final NativeMouseEvent nativeMouseEvent) {

        countdown = new Timer();
        countdown.schedule(new TimerTask() {

            @Override
            public void run() {
                mbs.fireEvent(event);
                event = new MouseButtonsEvent();
            }
        }, 500);
        event.registerButton(nativeMouseEvent.getButton());

    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        //DO NOTHING
    }
}
