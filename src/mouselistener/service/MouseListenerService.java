package mouselistener.service;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 * Created by Daniel on 27/12/2013.
 */
public class MouseListenerService{
    private static boolean initialised = false;
    private static MouseButtonsService mbs = new MouseButtonsService();

    public MouseListenerService(String project) throws NativeHookException {
        if (!initialised) {
            GlobalScreen.getInstance().registerNativeHook();
            GlobalScreen.getInstance().addNativeMouseListener(new MouseListener(mbs));
            mbs.addListener(new MouseButtonListener());
            mbs.addListener(new URLPosterListener(project));
        }
    }
}

