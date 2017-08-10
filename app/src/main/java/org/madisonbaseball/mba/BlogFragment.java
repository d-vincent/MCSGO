package org.madisonbaseball.mba;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView mRecyclerview;
    List<SimpleBlogItem> blogs;
    BlogAdapter mAdapter;
    public TextView content;
    public View holderview;
    View blogLink;


    // TODO: Rename and change types of parameters
    JSONObject blawg;

    private OnFragmentInteractionListener mListener;

    public BlogFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BlogFragment newInstance() {
        BlogFragment fragment = new BlogFragment();
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
        View view =  inflater.inflate(R.layout.fragment_blog, container, false);
        blogs = new ArrayList<>();


        //TODO This is the listener for the link to the forward blog
        blogLink = view.findViewById(R.id.blog_link);
        blogLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("URL FOR FORWARD BLOG GOES HERE"));
                startActivity(browserIntent);
            }
        });

        mRecyclerview = (RecyclerView)view.findViewById(R.id.blog_recycler);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new BlogAdapter(blogs);
        mRecyclerview.setAdapter(mAdapter);



        new JsonTask().execute("https://www.googleapis.com/blogger/v3/blogs/1892927545181815661/posts/?key=AIzaSyDjIS2fs_ZPBhrSSmnVV2NC7d_94zeJ7Ys");

        content = (TextView)view.findViewById(R.id.content_view);
        holderview = view.findViewById(R.id.holder);
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
    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                blawg = new JSONObject(result);
                JSONArray blogPosts = blawg.getJSONArray("items");
                blogs.clear();

                for (int i = 0; i < blogPosts.length(); i++){

                    //TODO this is where you'll have to do some heavy lifting to get the images to display. if you parse out object.getString("content") for the urls that will be a good start

                    JSONObject object = blogPosts.getJSONObject(i);
                    SimpleBlogItem item = new SimpleBlogItem();
                    item.setTitle(object.getString("title"));
                    item.setContent(object.getString("content"));

                    blogs.add(item);

                }

                mAdapter.notifyDataSetChanged();
            }catch (Exception e){

            }
        }
    }

    private class ProjectHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView title;


        public ProjectHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.blog_title);

        }

        @Override
        public void onClick(View v) {

        }
        public void bindProject(final SimpleBlogItem blog) {

            title.setText(blog.getTitle());
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holderview.setVisibility(itemView.VISIBLE);
                    content.setText(Html.fromHtml(blog.getContent()));
                }
            });
        }
    }

    private class BlogAdapter extends RecyclerView.Adapter<ProjectHolder> {

        public List<SimpleBlogItem> mBlogs;

        public BlogAdapter(List<SimpleBlogItem> blogs) {

            mBlogs = blogs;
        }

        @Override
        public ProjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_blog, parent, false);

            return new ProjectHolder(view);
        }

        @Override
        public void onBindViewHolder(ProjectHolder holder, int position) {
            SimpleBlogItem blog = mBlogs.get(position);
            holder.bindProject(blog);
        }

        @Override
        public int getItemCount() {
            return mBlogs.size();
        }

    }

    public void refresh(){

        new JsonTask().execute("https://www.googleapis.com/blogger/v3/blogs/1892927545181815661/posts/?key=AIzaSyDjIS2fs_ZPBhrSSmnVV2NC7d_94zeJ7Ys");
    }

}
