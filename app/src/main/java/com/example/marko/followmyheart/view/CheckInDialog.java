package com.example.marko.followmyheart.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marko.followmyheart.R;


public class CheckInDialog extends Dialog {

    public TextView tv_integral_value;
    public ImageView checkin_close;
    protected View view;

    public CheckInDialog(@NonNull Context context) {
        super(context);
        setDialog(context);
    }

    public CheckInDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
       setDialog(context);
    }

    private void setDialog(Context context) {
        // 点击外部不隐藏
        setCanceledOnTouchOutside(false);
        view = LayoutInflater.from(context).inflate(R.layout.dialog_chack_in, null);
        setContentView(view);
        checkin_close =  view.findViewById(R.id.iv_checkin_close);
        tv_integral_value =  view.findViewById(R.id.tv_integral_value);
        setOwnerActivity(scanForActivity(context));

    }
    /**
     * 转换成Activity
     *
     * @param context
     * @return
     */
    private Activity scanForActivity(Context context) {
        if (context == null)
            return null;
        else if (context instanceof Activity)
            return (Activity) context;
        else if (context instanceof ContextWrapper)
            return scanForActivity(((ContextWrapper) context).getBaseContext());

        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 居中
        getWindow().getAttributes().gravity = Gravity.CENTER;

    }
}
