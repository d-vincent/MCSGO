package org.madisonbaseball.mba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bracket, container, false);

        mWebview = (WebView)view.findViewById(R.id.bracket_webview);
        mWebview.loadUrl("http://challonge.com/DD20177UTournament/module");

        view.findViewById(R.id.seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebview.setVisibility(View.VISIBLE);
                mWebview.loadUrl("http://challonge.com/DD20177UTournament/module");
            }
        });

        view.findViewById(R.id.nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebview.setVisibility(View.VISIBLE);
                mWebview.loadUrl("http://challonge.com/DD20179UTournament/module");
            }
        });

        view.findViewById(R.id.eleven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebview.setVisibility(View.VISIBLE);
                mWebview.loadUrl("http://challonge.com/DD201711UTournament/module");
            }
        });
        view.findViewById(R.id.fourteen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebview.setVisibility(View.VISIBLE);
                mWebview.loadUrl("http://challonge.com/DD201714UTournament/module");
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
