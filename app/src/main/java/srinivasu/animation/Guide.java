package srinivasu.animation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Guide extends Activity {
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        showDialog(Guide.this,"Good Dadi");
    }

    public void showDialog(Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

/*
    private void showPopUp() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setCancelable(true);
        LayoutInflater inflater = this.getLayoutInflater();
        View titleView = inflater.inflate(R.layout.layout_title, null);
        alertBuilder.setCustomTitle(titleView);
        TextView title =  titleView.findViewById(R.id.title);
        title.setText("dadad");
        View convertView = inflater.inflate(R.layout.pop_up_list_view, null);
        listView =  convertView.findViewById(R.id.listView);
        final ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Cargo Provider");
        arrayList.add("Truck Owner");
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList));
        alertBuilder.setView(convertView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedString = arrayList.get(position);
                edtxtwho_u_r.setText(selectedString);
                dialog.dismiss();
            }
        });
        dialog = alertBuilder.create();
        dialog.show();
    }
*/
}
