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

    TextView phone4;
    TextView web4;
    TextView map4;

    TextView phone5;
    TextView web5;
    TextView map5;

    TextView phone6;
    TextView web6;
    TextView map6;

    TextView phone7;
    TextView web7;
    TextView map7;

    TextView phone8;
    TextView web8;
    TextView map8;

    TextView phone9;
    TextView web9;
    TextView map9;

    TextView phone10;
    TextView web10;
    TextView map10;

    TextView phone11;
    TextView web11;
    TextView map11;

    TextView phone12;
    TextView web12;
    TextView map12;

    TextView phone13;
    TextView web13;
    TextView map13;

    TextView phone14;
    TextView web14;
    TextView map14;

    TextView phone15;
    TextView web15;
    TextView map15;

    TextView phone16;
    TextView web16;
    TextView map16;





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

                    intent.setData(Uri.parse("tel:" + "2564648370"));
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
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        hospitalMap = (TextView)view.findViewById(R.id.map_1);
        hospitalMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String map = "http://maps.google.co.in/maps?q=" + "211 Celtic Drive, Madison, AL";
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

                    intent.setData(Uri.parse("tel:" + "2564648370"));
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

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://madisoncity.k12.al.us"));
                startActivity(browserIntent);

            }
        });
        fireMap = (TextView)view.findViewById(R.id.map_2);
        fireMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "4192 Sullivan Street, Madison, AL";
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

                    intent.setData(Uri.parse("tel:" + "2567744613"));
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
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://madisoncityschools.schoolinsites.com/?DivisionID=7841&ToggleSideNav="));
                startActivity(browserIntent);
            }
        });
        policeMap = (TextView)view.findViewById(R.id.map_3);
        policeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "217 Westchester Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone4 = (TextView)view.findViewById(R.id.phone_4);
        phone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2562165313"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web4 = (TextView)view.findViewById(R.id.web_4);
        web4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://paas.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map4 = (TextView)view.findViewById(R.id.map_4);
        map4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "11306 County Line Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone5 = (TextView)view.findViewById(R.id.phone_5);
        phone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2567722547"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web5 = (TextView)view.findViewById(R.id.web_5);
        web5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bjhs.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map5 = (TextView)view.findViewById(R.id.map_5);
        map5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "650 Hughes Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone6 = (TextView)view.findViewById(R.id.phone_6);
        phone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2562165313"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web6 = (TextView)view.findViewById(R.id.web_6);
        web6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://jchs.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map6 = (TextView)view.findViewById(R.id.map_6);
        map6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "11306 County Line Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone7 = (TextView)view.findViewById(R.id.phone_7);
        phone7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2568373735"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web7 = (TextView)view.findViewById(R.id.web_7);
        web7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dms.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map7 = (TextView)view.findViewById(R.id.map_7);
        map7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "1304 Hughes Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone8 = (TextView)view.findViewById(R.id.phone_8);
        phone8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2564300001"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web8 = (TextView)view.findViewById(R.id.web_8);
        web8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lms.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map8 = (TextView)view.findViewById(R.id.map_8);
        map8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "281 Dock Murphy Drive, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone9 = (TextView)view.findViewById(R.id.phone_9);
        phone9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2564302751"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web9 = (TextView)view.findViewById(R.id.web_9);
        web9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ces.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map9 = (TextView)view.findViewById(R.id.map_9);
        map9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "667 Balch Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone10 = (TextView)view.findViewById(R.id.phone_10);
        phone10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2567722075"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web10 = (TextView)view.findViewById(R.id.web_10);
        web10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hrtg.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map10 = (TextView)view.findViewById(R.id.map_10);
        map10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "11775 County Line Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone11 = (TextView)view.findViewById(R.id.phone_11);
        phone11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2564643614"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web11 = (TextView)view.findViewById(R.id.web_11);
        web11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hrzn.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map11 = (TextView)view.findViewById(R.id.map_11);
        map11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "7855 Old Madison Pike, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone12 = (TextView)view.findViewById(R.id.phone_12);
        phone12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2567729255"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web12 = (TextView)view.findViewById(R.id.web_12);
        web12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mes.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map12 = (TextView)view.findViewById(R.id.map_12);
        map12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "17 College Street, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone13 = (TextView)view.findViewById(R.id.phone_13);
        phone13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2567744690"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web13 = (TextView)view.findViewById(R.id.web_13);
        web13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mces.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map13 = (TextView)view.findViewById(R.id.map_13);
        map13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "847 Mill Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone14 = (TextView)view.findViewById(R.id.phone_14);
        phone14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2568248080"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web14 = (TextView)view.findViewById(R.id.web_14);
        web14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prek.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map14 = (TextView)view.findViewById(R.id.map_14);
        map14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "74 Nance Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone15 = (TextView)view.findViewById(R.id.phone_15);
        phone15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2568248106"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web15 = (TextView)view.findViewById(R.id.web_15);
        web15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://res.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map15 = (TextView)view.findViewById(R.id.map_15);
        map15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "50 Nance Road, Madison, AL";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                getActivity().startActivity(intent);
            }
        });

        phone16 = (TextView)view.findViewById(R.id.phone_16);
        phone16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);

                int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    intent.setData(Uri.parse("tel:" + "2568371189"));
                    getActivity().startActivity(intent);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                }
            }
        });
        web16 = (TextView)view.findViewById(R.id.web_16);
        web16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://wmes.madisoncity.k12.al.us"));
                startActivity(browserIntent);
            }
        });
        map16 = (TextView)view.findViewById(R.id.map_16);
        map16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String map = "http://maps.google.co.in/maps?q=" + "4976 Wall Triana Highway, Madison, AL";
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