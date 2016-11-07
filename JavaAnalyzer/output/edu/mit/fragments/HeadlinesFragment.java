package edu.mit.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener mCallback;
    public static interface OnHeadlineSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */
        public void onArticleSelected(int position, String value);
        
        String jlc$CompilerVersion$jl7 = "2.7.1";
        long jlc$SourceLastModified$jl7 = 1478515351000L;
        String jlc$ClassType$jl7 =
          ("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");
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB
          ? android.R.layout.simple_list_item_activated_1
          : android.R.layout.simple_list_item_1;
        setListAdapter(new ArrayAdapter<String>(getActivity(), layout,
                                                Ipsum.Headlines));
    }
    
    @Override
    public void onStart() {
        super.onStart();
        if (getFragmentManager().findFragmentById(R.id.article_fragment) !=
              null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try { mCallback = (OnHeadlineSelectedListener) activity; }
        catch (ClassCastException e) {
            throw new ClassCastException(
              activity.toString() +
                " must implement OnHeadlineSelectedListener");
        }
    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Activity activity = (Activity) mCallback;
        TelephonyManager mgr =
          (TelephonyManager)
            activity.getSystemService(activity.TELEPHONY_SERVICE);
        String imei = mgr.getDeviceId();
        mCallback.onArticleSelected(position, imei);
        getListView().setItemChecked(position, true);
    }
    
    public HeadlinesFragment() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1478515351000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "mgWvndj0Oqe5fbHQKi+uQAKHHw20EH81bno87PZfCmkRCkiCKbNxqfpR1L5n" +
       "j8/NK4NP73CqvNZoTbYXnhwXfv7Pn6TP/OaVRa7rem6YH9ew4gjJTIHIbUsn" +
       "wQFRZweR+NLxP64/vKtw9D+4aztiCsVZfvvA+Vf2bZW/niRVflxWvACiRD3R" +
       "aGywGDxZ9MORmNzou+AGNO0t8G0lpHqf23eEYzJw+wf6U/ipwWXS7vZtcX8G" +
       "0JxwocaNzxbq1Hlpw07vKemKxoTwe5YB9KPYDHNSZ+gZi8GttjxsDVkqxL86" +
       "6T4dpNnWtyaefOeCEzBxjIptZifnHn4/fWouGXqMdVa8h8I0zoNMnHMFNh/D" +
       "EN68nBRB0ff7S7Pf/9bsiaSr4yAnqUkwS5B6n46mXqOfer4pW8U9gbCWHpxk" +
       "lqUqbJlsrbwKxEQuGiU3wrcTXhTU7XPXGyXI5JDbZ5eOkrC/S8usTWFjcFJr" +
       "4OPeEhUKC4xmLmk0nJ64bvNsh+9OQupbnb7uz9drHmRy1e0vf+gkWu0lETx/" +
       "0r1QTk2qfFrI/+IytjuBzazIo17OqVyIGe+B/7Hx9sN3N4w7nb7hd9drPGTy" +
       "ttu/sbTxUi7Ou8Zb5xlvSlXGGU/j1TessqkKhJqEybS/MuZmN3Z5TqpU91et" +
       "2HxKM/Rxoc0jy7jiG9h8DUpMQ0fxA5wVM1DiT8Q8cuq/6JEyaFZRCWAJ3lbx" +
       "q5rzS5B8cb6pbt38kV+I95n/a009PH/yJU0LF0OhcY1psbwqlKx3SiNTdM+A" +
       "+IrSBK5kfywO/E1n8zlIcHczWBra8OIFmIJFHF40Pae1hTMCTeppWE5E6wvf" +
       "tq3LlDbxkqQzctuIHyu9u7zk/Fw5Kl+a33/w/qu3P+08HWWNzswgl7osqXUe" +
       "qH49sHlJbh6vmv7uayufrb/Jux0iT9fY2ToWf5vtLZpcvKZmnl/33TuemX9T" +
       "PCn/DWkUr0JFFgAA");
}
