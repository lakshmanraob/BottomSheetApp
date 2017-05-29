package sheet.bottom.com.bottomsheetapp.firebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sheet.bottom.com.bottomsheetapp.R;

/**
 * Created by labattula on 26/05/17.
 */

public class ReactFragment extends Fragment {

    static ReactFragment fragment;

    public static ReactFragment getInstance(String fragmentName) {
        if (fragment == null) {
            Bundle bundle = new Bundle();
            bundle.putString("title", fragmentName);
            fragment = new ReactFragment();
            fragment.setArguments(bundle);
            fragment = new ReactFragment();
        }
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View reactView = inflater.inflate(R.layout.fragment_react, container, false);

        return reactView;
    }


}
