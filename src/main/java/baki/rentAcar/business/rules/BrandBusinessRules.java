package baki.rentAcar.business.rules;


import baki.rentAcar.core.utilities.exceptions.BusinessException;
import baki.rentAcar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String brandName) {
        if(this.brandRepository.existsByName(brandName)){
            throw new BusinessException("Brand " + brandName + " already exists");
        }
    }
}
