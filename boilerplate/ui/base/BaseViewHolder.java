
package com.ciberciti.subscraze.boilerplate.ui.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Abhishek Patel on 12-10-2022.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
