package edu.mit.icc_service_messages;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class MessengerService extends Service {
    /** Command to the service to display a message */
    static final int MSG_SAY_HELLO = 1;
    /**
     * Handler of incoming messages from clients.
     */
    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    int tainted = msg.arg1;
                    Log.i("DroidBench", "Tainted: " + tainted);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
        
        public IncomingHandler() { super(); }
        
        public static final String jlc$CompilerVersion$jl7 = "2.7.1";
        public static final long jlc$SourceLastModified$jl7 = 1478513627000L;
        public static final String jlc$ClassType$jl7 =
          ("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" +
           "xK6HAMQanzZ+lu9uOn1lw2L5tSAqcLFwXPuXS9SUrRdcSgn0qzq3EF8pE3E1" +
           "z7V/iNs1Ak8Y7P6F8z6VHVc2cgnXiXEhHxbb9gGjmakeTZXTLkMeDmiqw2jU" +
           "eY/4HeolU8CxNP8/E1AF25U8Ytg1DoqdkCA6SQ528qGFoYqEqH0OGfiufpKv" +
           "IapCbVX7nQ5SGqq6ufutW2fsuPG3m77D5PDwqw8iR4aDWT35wnFtcTaN3ZcL" +
           "YSv48DiP5AWT3SIoWn85N/TJO0OHgo6iqxkq7AfjCCs08qHVNvwKJxvL3Wz0" +
           "DCrym/f8kY5+QqmqkBySnATOl8IATb7eIsN62UN1KKDx7HFfaPZXhXx2JFQy" +
           "a2Tbd6Imu51/KZS8eErTsqI5O7KLTUriqjBMqY2WpnhBEZg7mWQMzci3LLTq" +
           "sVnEGbTgNguGCmDM3lRhCTb5tM/MF7eOmdKB8ejXaHcDE3vAD3cLc0JYfAhn" +
           "oCJlfwrH5HMjGzfvu/vUKbt9gE/owUHx4QTfgXaT4sLNggm5ZXgVt9Xfn3q+" +
           "dFEm5HLaF59sNfkLdUvSZKK0Dn4868OVb4/cEG3FvwnPdrWhEAAA");
    }
    
    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    final Messenger mMessenger = new Messenger(new IncomingHandler());
    
    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding",
                       Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }
    
    public MessengerService() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513627000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "Sra3bDBee878dONz+7+/8DpPr/8F40mR0LsTAAA=");
}
