package com.example.mapsalud.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUsersPageResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("per_page")
    private int per_page;
    @SerializedName("total")
    private int total;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("data")
    private List<GetDataResponse> listData;

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

    public List<GetDataResponse> getListData() {
        return listData;
    }

    public void setListData(List<GetDataResponse> listData) {
        this.listData = listData;
    }
}
