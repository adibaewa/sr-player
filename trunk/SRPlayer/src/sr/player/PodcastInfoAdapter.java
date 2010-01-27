package sr.player;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PodcastInfoAdapter extends ArrayAdapter<PodcastInfo> {

        private ArrayList<PodcastInfo> items;
        private Context CurrentContext;
        private PodcastInfo CurrentItem;

        public PodcastInfoAdapter(Context context, int textViewResourceId, ArrayList<PodcastInfo> items) {
                super(context, textViewResourceId, items);
                this.items = items;
                CurrentContext = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;                
                if (v == null) {
                    LayoutInflater vi = (LayoutInflater)CurrentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = vi.inflate(R.layout.podlistitem, null);
                }
                CurrentItem = items.get(position);                
                String Title = CurrentItem.getTitle();
                String Desciption = CurrentItem.getDescription();
                TextView tt = (TextView) v.findViewById(R.id.text1);                
                if (tt != null) 
                {
                    tt.setText(Title);                            		
                }
                
                TextView bt = (TextView) v.findViewById(R.id.text2);
                if (CurrentItem.getType() == SRPlayerDBAdapter.AVSNITT_ATT_LADDA_NER)
                {                	
                	if ((Integer.parseInt(CurrentItem.getID())) == SRPlayerDBAdapter.AKTIV_NEDLADDNING)
                	{
                		bt.setText("Nedladdning p�g�r...");
                	}
                	else
                	{	                		
                		bt.setText("Avsnitt i k� f�r nedladdning...");
                	}
                	
            		bt.setVisibility(View.VISIBLE);
            		bt.setTextColor(Color.RED);
                }
                else if (bt != null) 
                {
                	if (Desciption != null)
                	{
                		bt.setText(Desciption);
                		bt.setVisibility(View.VISIBLE);
                		bt.setTextColor(Color.BLACK);
                	}                	
                }
                
                return v;
        }
}