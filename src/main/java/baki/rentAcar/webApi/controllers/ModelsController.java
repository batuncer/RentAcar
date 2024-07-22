package baki.rentAcar.webApi.controllers;


import baki.rentAcar.business.abstracts.ModelService;
import baki.rentAcar.business.requests.CreateModelRequest;
import baki.rentAcar.business.responces.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private final ModelService modelService;

    @GetMapping
    public List<GetAllModelsResponse> getAllModels() {
        return modelService.getAll();
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() @Valid()  CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);
    }
}
