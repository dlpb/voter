package mouselistener;

import mouselistener.service.MouseListenerService;
import org.jnativehook.NativeHookException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by Daniel on 27/12/2013.
 */
public class MouseListenerMain {
    public static void main(String[] param) {


        try {
           // String project = printAndGetProject();
            new MouseListenerService("");
        } catch (NativeHookException e) {
            System.err.println("Could not start program. Unable to attach to mouse events: " + e.getMessage());
        }
    }

    private static String printAndGetProject() {
        URL oracle = null;
        try {
            oracle = new URL("http://localhost:9000/api/v1/projects");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner s = new Scanner(System.in);
        System.out.print("Enter project name: ");
        return s.nextLine();
    }
}
