package baki.rentAcar.webApi.controllers;

import baki.rentAcar.business.requests.CreateBrandRequest;
import baki.rentAcar.business.requests.UpdateBrandRequest;
import baki.rentAcar.business.responces.GetAllBrandsResponse;
import baki.rentAcar.business.responces.GetByIdBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import baki.rentAcar.business.abstracts.BrandService;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;


    @GetMapping()
    public List<GetAllBrandsResponse> getAllBrands() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandsResponse getByIdBrand(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping("/{id}")
    public void update( @RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }
}
