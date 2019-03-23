package com.example.mapsalud.presentation.main.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mapsalud.R;
import com.example.mapsalud.presentation.main.viewmodel.GetDataVM;

import java.util.ArrayList;
import java.util.List;

public class RVUserAdapter extends RecyclerView.Adapter<RVUserAdapter.RVUserAdapterViewHolder>{

    private final String TAG = RVUserAdapter.class.getSimpleName();
    private List<GetDataVM> mLstGetDataVM= new ArrayList<>();


    public RVUserAdapter() {
        this.mLstGetDataVM = new ArrayList<>();
    }

    public void clearAllAndAddAll(List<GetDataVM> lstGetDataVM) {
        mLstGetDataVM.clear();
        if (lstGetDataVM!=null){
            mLstGetDataVM.addAll(lstGetDataVM);
        }
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public RVUserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RVUserAdapterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RVUserAdapterViewHolder holder, int i) {
        GetDataVM getDataVM = mLstGetDataVM.get(i);
        holder.tvUserItemNombre.setText(getDataVM.getNombre());
        holder.tvUserItemApellido.setText(getDataVM.getApellido());
        Glide.with(holder.ivUserItem.getContext()).load(getDataVM.getImagen()).into(holder.ivUserItem);
    }

    @Override
    public int getItemCount() {
        return mLstGetDataVM.size();
    }

    static class RVUserAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserItemNombre,tvUserItemApellido;
        ImageView ivUserItem;

        public RVUserAdapterViewHolder(View itemView) {
            super(itemView);
            ivUserItem = (ImageView) itemView.findViewById(R.id.ivUserItem);
            tvUserItemNombre = (TextView) itemView.findViewById(R.id.tvUserItemNombre);
            tvUserItemApellido = (TextView) itemView.findViewById(R.id.tvUserItemApellido);

        }
    }
}
