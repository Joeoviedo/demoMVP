package com.example.mapsalud.data.model.maper;

import com.example.mapsalud.data.model.response.GetDataResponse;
import com.example.mapsalud.data.model.response.GetUsersPageResponse;
import com.example.mapsalud.domain.model.GetData;
import com.example.mapsalud.domain.model.GetUsersPage;

import java.util.ArrayList;
import java.util.List;

public class UserPageDataMapper {

    public GetUsersPage convertGetUsersPageResponseToGetUsersPage(GetUsersPageResponse getUsersPageResponse) {
        if (getUsersPageResponse == null)
            return null;

        GetUsersPage getUsersPage = new GetUsersPage();
        getUsersPage.setPage(getUsersPageResponse.getPage());
        getUsersPage.setPer_page(getUsersPageResponse.getPer_page());
        getUsersPage.setTotal(getUsersPageResponse.getTotal());
        getUsersPage.setTotal_pages(getUsersPageResponse.getTotal());

        List<GetData> lstData = new ArrayList<>();

        if (getUsersPageResponse.getListData() != null){
            for (GetDataResponse getDataResponse : getUsersPageResponse.getListData())
                    lstData.add(convertGetDataResponseToGetData(getDataResponse));
        }
        getUsersPage.setListData(lstData);

        return getUsersPage;
    }

    public GetData convertGetDataResponseToGetData(GetDataResponse getDataResponse) {
        if (getDataResponse == null)
            return null;

        GetData getData = new GetData();
        getData.setId(getDataResponse.getId());
        getData.setNombre(getDataResponse.getNombre());
        getData.setApellido(getDataResponse.getApellido());
        getData.setImagen(getDataResponse.getImagen());

        return  getData;
    }
}
