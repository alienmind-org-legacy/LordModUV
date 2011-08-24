package org.alienmind.lordmoduv;

import java.io.IOException;

import org.alienmind.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class LordModUVMenu extends ListActivity {
	static final String CMD_SU="/system/xbin/su";
	static final String CMD_C="-c";
	
	String[] actions;
	String[] descriptions; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		actions      = getResources().getStringArray(R.array.actions_array);
		descriptions = getResources().getStringArray(R.array.descriptions_array);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, descriptions));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
						Toast.LENGTH_SHORT).show();				
				String[] str={CMD_SU,CMD_C,actions[position]};
				try {				
					Process p = Runtime.getRuntime().exec(str);
					//p.getInputStream().read(b, offset, length);
				} catch (IOException e) {
					Toast.makeText(getApplicationContext(), e.getStackTrace().toString(), Toast.LENGTH_LONG).show();
				} 
				
			}
		});
	}
		

}