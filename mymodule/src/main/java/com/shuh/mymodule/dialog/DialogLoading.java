package com.shuh.mymodule.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.shuh.mymodule.R;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class DialogLoading extends Dialog {

    private TextView loadingLabel;

    public DialogLoading(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_loading_layout);
        setCanceledOnTouchOutside(false);
        loadingLabel = (TextView) findViewById(R.id.loading_text);
    }

    public void setDialogLabel(String label) {
        loadingLabel.setText(label);
    }
}
