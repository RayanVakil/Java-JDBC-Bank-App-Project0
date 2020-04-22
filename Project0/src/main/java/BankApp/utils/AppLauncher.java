package BankApp.utils;

import BankApp.view.console.ConsoleLoginView;

/*
    contains method which can be used to launch the app
    with any view you want.
 */
public class AppLauncher {

    public static void lunch(String view){
        switch (view){
            case BankAppStrings.CONSOLE_VIEW :
               new ConsoleLoginView().lunch();
        }
    }
}
