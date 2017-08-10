package org.madisonbaseball.mba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BracketFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BracketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BracketFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    boolean isWebviewOpen;
    public WebView mWebview;
    ImageView middleschool;
    ImageView highschool;

    boolean highschoolActive;

    public BracketFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static BracketFragment newInstance() {
        BracketFragment fragment = new BracketFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainActivity)getActivity()).mFragment = this;
        highschoolActive = true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bracket, container, false);

        mWebview = (WebView)view.findViewById(R.id.bracket_webview);
        mWebview.getSettings().setJavaScriptEnabled(true);
        //mWebview.setWebChromeClient(new WebChromeClient());
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        mWebview.getSettings().setAllowFileAccessFromFileURLs(true);
        mWebview.loadUrl("file:///android_asset/hs2/index.html");

      highschool = (ImageView) view.findViewById(R.id.highschool);
        middleschool = (ImageView) view.findViewById(R.id.middle_school);
        middleschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highschoolActive) {
                    highschool.setImageDrawable(getResources().getDrawable(R.drawable.hs_inactive));
                    middleschool.setImageDrawable(getResources().getDrawable(R.drawable.msactive));

                    highschoolActive = false;
                    mWebview.loadUrl("file:///android_asset/ms2/index.html");
                    //load proper thing
                }
            }
        });

        highschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!highschoolActive) {
                    highschool.setImageDrawable(getResources().getDrawable(R.drawable.hsactive));
                    middleschool.setImageDrawable(getResources().getDrawable(R.drawable.ms_inactive));

                    mWebview.loadUrl("file:///android_asset/hs2/index.html");
                    highschoolActive = true;

                    //load proper thing
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
