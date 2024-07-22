package baki.rentAcar.business.concretes;

import baki.rentAcar.business.abstracts.BrandService;
import baki.rentAcar.business.requests.CreateBrandRequest;
import baki.rentAcar.business.requests.UpdateBrandRequest;
import baki.rentAcar.business.responces.GetAllBrandsResponse;
import baki.rentAcar.business.responces.GetByIdBrandsResponse;
import baki.rentAcar.business.rules.BrandBusinessRules;
import baki.rentAcar.core.utilities.exceptions.BusinessException;
import baki.rentAcar.core.utilities.mappers.ModelMapperService;
import baki.rentAcar.dataAccess.abstracts.BrandRepository;
import baki.rentAcar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // business object
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        //Business
        List<Brand> brands = brandRepository.findAll();
        List <GetAllBrandsResponse> brandsResponse = brands.stream().map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public GetByIdBrandsResponse getById(int id) {
        Optional<Brand> brand = this.brandRepository.findById(id);
        GetByIdBrandsResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandsResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }

}
