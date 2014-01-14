package mouselistener.service;

import mouselistener.events.MouseButtonsEvent;
import mouselistener.events.MouseButtonsEventListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * Created by Daniel on 04/01/2014.
 */
public class URLPosterListener implements MouseButtonsEventListener {
    private final String project
            ;

    public URLPosterListener(String project){
        this.project = project;
    }
    @Override
    public void buttonsPressed(MouseButtonsEvent event) {

        int vote = event.getNumericalValue();
        if(vote == 0)
            return;

        URL url = null;
        try {
            url = new URL("http://localhost:9000/api/v1/vote");
        } catch (MalformedURLException ex) {
            System.err.println("Exception in URL:" + ex);
        }

        HttpURLConnection urlConn = null;
        try {
            // URL connection channel.
            urlConn = (HttpURLConnection) url.openConnection();
        } catch (IOException ex) {
            System.err.println("Could not create connection" + ex);
        }

        // Let the run-time system (RTS) know that we want input.
        urlConn.setDoInput (true);

        // Let the RTS know that we want to do output.
        urlConn.setDoOutput (true);

        // No caching, we want the real thing.
        urlConn.setUseCaches (false);

        try {
            urlConn.setRequestMethod("POST");
        } catch (ProtocolException ex) {
            System.err.println("Could not set protocol" + ex);
        }

        try {
            urlConn.connect();
        } catch (IOException ex) {
            System.err.println("Could not connect"  + ex);
        }

        DataOutputStream output = null;
        DataInputStream input = null;

        try {
            output = new DataOutputStream(urlConn.getOutputStream());
        } catch (IOException ex) {
            System.err.println("Coulnd nt write to output stream" + ex);
        }

        // Specify the content type if needed.
        //urlConn.setRequestProperty("Content-Type",
        //  "application/x-www-form-urlencoded");

        // Construct the POST data.
        String content =
                "project=" + URLEncoder.encode(project) +
                        "&vote=" + (vote);

        // Send the request data.
        try {
            output.writeBytes(content);
            System.out.println("writing " + content + " to " + urlConn.getURL());
            output.flush();
            output.close();
        } catch (IOException ex) {
        }

        // Get response data.
        String str = null;
        try {
            input = new DataInputStream (urlConn.getInputStream());
            while (null != ((str = input.readLine()))) {
                System.out.println(str);
            }
            input.close ();
        } catch (IOException ex) {
        }
    }
}
