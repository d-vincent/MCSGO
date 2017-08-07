package org.madisonbaseball.mba;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MadisonInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MadisonInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelFragment extends Fragment {

    private int mState;
    private String mParam2;

    TextView hospitalPhone;
    TextView hospitalWebsite;
    TextView hospitalMap;

    TextView firePhone;
    TextView fireWebsite;
    TextView fireMap;

    TextView policePhone;
    TextView policeWebsite;
    TextView policeMap;


    public HotelFragment() {
        // Required empty public constructor
    }


    public static HotelFragment newInstance() {
        HotelFragment fragment = new HotelFragment();
        Bundle args = new Bundle();


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.hotel_layout, container, false);
        hospitalPhone = (TextView)view.findViewById(R.id.phone_1);
        hospitalPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2562583000"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        hospitalWebsite = (TextView)view.findViewById(R.id.web_1);
        hospitalWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ihg.com/holidayinnexpress/hotels/us/en/madison/hsvmd/hoteldetail?cm_mmc=GoogleMaps-_-EX-_-USA-_-HSVMD"));
                startActivity(browserIntent);
            }
        });
        hospitalMap = (TextView)view.findViewById(R.id.map_1);
        hospitalMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String map = "http://maps.google.co.in/maps?q=" + "8956 Madison Blvd, Madison, A";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);

            }
        });

        firePhone = (TextView)view.findViewById(R.id.phone_2);
        firePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2564648999"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        fireWebsite = (TextView)view.findViewById(R.id.web_2);
        fireWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hamptoninn3.hilton.com/en/hotels/alabama/hampton-inn-madison-huntsville-airport-HSVMSHX/index.html"));
                startActivity(browserIntent);

            }
        });
        fireMap = (TextView)view.findViewById(R.id.map_2);
        fireMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "9225 Madison Blvd, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        policePhone = (TextView)view.findViewById(R.id.phone_3);
        policePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2567727170"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        policeWebsite = (TextView)view.findViewById(R.id.web_3);
        policeWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bestwestern.com/en_US/book/hotel-details.01122.html?iata=00171880&amp;ssob=BLBWI0004G&amp;cid=BLBWI0004G:google:gmb:01122"));
                startActivity(browserIntent);
            }
        });
        policeMap = (TextView)view.findViewById(R.id.map_3);
        policeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "9035 Madison Blvd, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
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