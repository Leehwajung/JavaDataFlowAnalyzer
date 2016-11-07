package edu.mit.icc_service_messages;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.view.View;

/**
 * @testcase_name ICC-Service-Messages 
 * 
 * @description   Testing message passing mechanism through Services 
 * @dataflow source -> sink
 * @number_of_leaks 1
 * @challenges    The analysis tool has to be able through ICC message passing /
 Handler constructs.
 */
public class ActivityMessenger extends Activity {
    /** Messenger for communicating with the service. */
    Messenger mService = null;
    /** Flag indicating whether we have called bind on the service. */
    boolean mBound;
    /**
     * Class for interacting with the main interface of the service.
     */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            mService = new Messenger(service);
            mBound = true;
        }
        
        public void onServiceDisconnected(ComponentName className) {
            mService = null;
            mBound = false;
        }
    };
    
    public void sayHello(View v) {
        if (!mBound) return;
        TelephonyManager mgr = (TelephonyManager)
                                 getSystemService(TELEPHONY_SERVICE);
        int id = Integer.parseInt(mgr.getDeviceId());
        Message msg = Message.obtain(null, MessengerService.MSG_SAY_HELLO, id,
                                     0);
        try { mService.send(msg); }
        catch (RemoteException e) { e.printStackTrace(); }
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, MessengerService.class), mConnection,
                    Context.BIND_AUTO_CREATE);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }
    
    public ActivityMessenger() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478513627000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "buPTtz229Aa/Pv8XvfDub3wXAAA=");
}
