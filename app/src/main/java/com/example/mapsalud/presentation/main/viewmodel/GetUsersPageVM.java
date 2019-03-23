package com.example.mapsalud.presentation.main.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class GetUsersPageVM implements Parcelable {


    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<GetDataVM> listData;

    public GetUsersPageVM() {
    }

    protected GetUsersPageVM(Parcel in) {
        page = in.readInt();
        per_page = in.readInt();
        total = in.readInt();
        total_pages = in.readInt();
        listData = in.createTypedArrayList(GetDataVM.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(per_page);
        dest.writeInt(total);
        dest.writeInt(total_pages);
        dest.writeTypedList(listData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GetUsersPageVM> CREATOR = new Creator<GetUsersPageVM>() {
        @Override
        public GetUsersPageVM createFromParcel(Parcel in) {
            return new GetUsersPageVM(in);
        }

        @Override
        public GetUsersPageVM[] newArray(int size) {
            return new GetUsersPageVM[size];
        }
    };

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<GetDataVM> getListData() {
        return listData;
    }

    public void setListData(List<GetDataVM> listData) {
        this.listData = listData;
    }
}
