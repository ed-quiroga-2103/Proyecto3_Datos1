package com.example.eduardo.messagingapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class userChat extends Activity {
    private ListView mList;
    private ArrayList<String> arrayList;
    private MyCustomAdapter mAdapter;

    public class MyCustomAdapter extends BaseAdapter {
        private ArrayList<String> mListItems;
        private LayoutInflater mLayoutInflater;

        public MyCustomAdapter(Context context, ArrayList<String> arrayList){

            mListItems = arrayList;

            //get the layout inflater
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            //getCount() represents how many items are in the list
            return mListItems.size();
        }

        @Override
        //get the data of an item from a specific position
        //i represents the position of the item in the list
        public Object getItem(int i) {
            return null;
        }

        @Override
        //get the position id of the item from the list
        public long getItemId(int i) {
            return 0;
        }

        @Override

        public View getView(int position, View view, ViewGroup viewGroup) {

            //check to see if the reused view is null or not, if is not null then reuse it
            if (view == null) {
                view = mLayoutInflater.inflate(R.layout.list_item, null);
            }

            //get the string item from the position "position" from array list to put it on the TextView
            String stringItem = mListItems.get(position);
            if (stringItem != null) {

                TextView itemName = (TextView) view.findViewById(R.id.list_item_text_view);

                if (itemName != null) {
                    //set the item name on the TextView
                    itemName.setText(stringItem);
                }
            }

            //this method must return the view corresponding to the data at the specified position.
            return view;

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatlayout);

        arrayList = new ArrayList<String>();

        final EditText editText = (EditText) findViewById(R.id.editText);
        Button send = (Button)findViewById(R.id.send_button);

        //relate the listView from java to the one created in xml
        mList = (ListView)findViewById(R.id.list);
        mAdapter = new MyCustomAdapter(this, arrayList);
        mList.setAdapter(mAdapter);

        // connect to the server

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = editText.getText().toString();

                //add the text in the arrayList
                arrayList.add("Me: " + message);

                //refresh the list
                mAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

    }

}
