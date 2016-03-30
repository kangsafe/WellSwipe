package com.well.swipe.preference;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.well.swipe.R;

/**
 * Created by mingwei on 3/31/16.
 */
public abstract class SwipeDialog {

    private Context mContext;

    private Dialog mDialog;

    private Display mDisplay;

    private WindowManager mWindowManager;

    public SwipeDialog(Context context) {
        this.mContext = context;
        this.mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        this.mDisplay = mWindowManager.getDefaultDisplay();
        init(onCreateView());
    }

    /**
     * 初始化View
     *
     * @param view
     */
    private void init(View view) {
        view.setMinimumWidth(mDisplay.getWidth());
        mDialog = new Dialog(mContext, R.style.DialogStyle);
        mDialog.setContentView(view);
        Window dialogWindow = mDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);
    }

    public void show() {
        mDialog.show();
    }

    public void dissmis() {
        mDialog.dismiss();
    }

    public Context getContext() {
        return mContext;
    }

    /**
     * 留给子类实现，返回一个View作为Dialog的ContentView
     *
     * @return
     */
    public abstract View onCreateView();
}
