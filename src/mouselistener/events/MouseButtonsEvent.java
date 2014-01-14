package mouselistener.events;

/**
 * Created by Daniel on 27/12/2013.
 */
public class MouseButtonsEvent {
    public static final int NO_VALUE = 0;

    public static final int VALUE_1 = 1;
    public static final int VALUE_2 = 2;
    public static final int VALUE_3 = 3;
    public static final int VALUE_4 = 4;
    public static final int VALUE_5 = 5;

    public static final int BUTTON_1 = 1;                           // 0001 1
    public static final int BUTTON_2 = 2;                           // 0010 2
    public static final int BUTTON_3 = 4;                           // 0100 4

    public static final int BUTTON_MASK_1 = BUTTON_2;               // 0010 2
    public static final int BUTTON_MASK_2 = BUTTON_2 | BUTTON_1;    // 0011 3
    public static final int BUTTON_MASK_3 = BUTTON_3;               // 0100 4
    public static final int BUTTON_MASK_4 = BUTTON_1 | BUTTON_3;    // 0101 5
    public static final int BUTTON_MASK_5 = BUTTON_2 | BUTTON_3;    // 0110 6

    private int[] maskLookup = {NO_VALUE, BUTTON_1, BUTTON_2, BUTTON_3};
    private int[] valueLookup = {NO_VALUE, NO_VALUE, VALUE_1, VALUE_2, VALUE_3, VALUE_4, VALUE_5};
    private int buttonMask = NO_VALUE;

    public void registerButton(int button){
        buttonMask = buttonMask | maskLookup[button];
    }

    public int getButtonMask(){
        return buttonMask;
    }

    public int getNumericalValue()
    {
        return valueLookup[buttonMask];
    }
}
