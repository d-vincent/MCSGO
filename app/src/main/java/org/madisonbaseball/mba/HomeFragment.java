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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    WebView homeWebview;
    WebView diningWebview;
    WebView bracketWebview;
    WebView weatherWebview;
    String url;
    int mState;

    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(int state) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt("state", state);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mState = (int)args.get("state");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        homeWebview = (WebView) view.findViewById(R.id.home_webview);

        homeWebview.setWebViewClient(new WebViewClient());
        homeWebview.getSettings().setJavaScriptEnabled(true);
        homeWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        homeWebview.getSettings().setAllowFileAccess(true);
        homeWebview.getSettings().setDomStorageEnabled(true);
        homeWebview.setWebChromeClient(new WebChromeClient());
        homeWebview.loadUrl("https://www.juicer.io/api/feeds/mcs/iframe");

        String heh = "<iframe src='https://www.juicer.io/api/feeds/mcs/iframe' frameborder='0' width ='100%' height='100%' style='display:block:margin:0 auto;'><iframe>";


        weatherWebview = (WebView)view.findViewById(R.id.weather_webview);
        weatherWebview.getSettings().setJavaScriptEnabled(true);
        weatherWebview.getSettings().setDomStorageEnabled(true);
        weatherWebview.setWebViewClient(new WebViewClient());
        weatherWebview.loadUrl("https://sis.madisoncity.k12.al.us");

        bracketWebview = (WebView)view.findViewById(R.id.bracket_webview);
        bracketWebview.loadUrl("google.com");


        diningWebview = (WebView)view.findViewById(R.id.dining_webview);
        diningWebview.getSettings().setJavaScriptEnabled(true);
        diningWebview.setWebViewClient(new WebViewClient());
        diningWebview.loadUrl("https://scorestream.com/widgets/scoreboards/vert?userWidgetId=12324");

        loadNewPage(mState);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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

    public void loadNewPage(int state){

        switch (state){
            case 0:
                mState = 0;
                homeWebview.setVisibility(View.VISIBLE);
                weatherWebview.setVisibility(View.GONE);
                diningWebview.setVisibility(View.GONE);
                bracketWebview.setVisibility(View.GONE);

                break;
            case 1:
                mState = 1;
                homeWebview.setVisibility(View.GONE);
                weatherWebview.setVisibility(View.GONE);
                diningWebview.setVisibility(View.VISIBLE);
                bracketWebview.setVisibility(View.GONE);
                break;
            case 2:
                mState = 2;
                homeWebview.setVisibility(View.GONE);
                weatherWebview.setVisibility(View.VISIBLE);
                diningWebview.setVisibility(View.GONE);
                bracketWebview.setVisibility(View.GONE);
                break;
            case 3:
                mState = 3;
                homeWebview.setVisibility(View.GONE);
                weatherWebview.setVisibility(View.GONE);
                diningWebview.setVisibility(View.GONE);
                bracketWebview.setVisibility(View.VISIBLE);
                break;
        }

    }
}
