package baki.rentAcar.business.abstracts;

import baki.rentAcar.business.requests.CreateBrandRequest;
import baki.rentAcar.business.requests.UpdateBrandRequest;
import baki.rentAcar.business.responces.GetAllBrandsResponse;
import baki.rentAcar.business.responces.GetByIdBrandsResponse;

import java.util.List;


public interface BrandService {

    List<GetAllBrandsResponse> getAll();
    GetByIdBrandsResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
