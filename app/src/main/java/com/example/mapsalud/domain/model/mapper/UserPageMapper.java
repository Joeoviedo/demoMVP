package com.example.mapsalud.domain.model.mapper;

import com.example.mapsalud.domain.model.GetData;
import com.example.mapsalud.domain.model.GetUsersPage;
import com.example.mapsalud.presentation.main.viewmodel.GetDataVM;
import com.example.mapsalud.presentation.main.viewmodel.GetUsersPageVM;

import java.util.ArrayList;
import java.util.List;

public class UserPageMapper {

    public GetUsersPageVM convertGetUsersPageToGetUsersPageVM(GetUsersPage getUsersPage) {
        if (getUsersPage == null)
            return null;

        GetUsersPageVM usersPageVM = new GetUsersPageVM();
        usersPageVM.setPage(getUsersPage.getPage());
        usersPageVM.setPer_page(getUsersPage.getPer_page());
        usersPageVM.setTotal(getUsersPage.getTotal());
        usersPageVM.setTotal_pages(getUsersPage.getTotal());

        List<GetDataVM> lstData = new ArrayList<>();

        if (getUsersPage.getListData() != null){
            for (GetData getData : getUsersPage.getListData())
                lstData.add(convertGetDataToGetDataVM(getData));
        }
        usersPageVM.setListData(lstData);

        return usersPageVM;
    }

    public GetDataVM convertGetDataToGetDataVM(GetData getData) {
        if (getData == null)
            return null;

        GetDataVM getDataVM = new GetDataVM();
        getDataVM.setId(getData.getId());
        getDataVM.setNombre(getData.getNombre());
        getDataVM.setApellido(getData.getApellido());
        getDataVM.setImagen(getData.getImagen());

        return  getDataVM;
    }
}
