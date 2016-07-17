package kumar.ankit.nilgiris;

/**
 * Created by Ankit on 22-06-2016.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FeedHolder extends RecyclerView.ViewHolder {
    TextView nameTxt,emailTxt,phoneTxt,dateTxt,reminderTxt,amountTxt;


    public FeedHolder(View itemView) {
        super(itemView);
        nameTxt= (TextView) itemView.findViewById(R.id.name_card);
        emailTxt= (TextView) itemView.findViewById(R.id.email_card);
        phoneTxt= (TextView) itemView.findViewById(R.id.phone_card);
        dateTxt= (TextView) itemView.findViewById(R.id.date_card);
        reminderTxt= (TextView) itemView.findViewById(R.id.reminder_card);
        amountTxt= (TextView) itemView.findViewById(R.id.amount_card);


    }
}