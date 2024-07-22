package baki.rentAcar.business.concretes;

import baki.rentAcar.business.abstracts.ModelService;
import baki.rentAcar.business.requests.CreateModelRequest;
import baki.rentAcar.business.responces.GetAllModelsResponse;
import baki.rentAcar.core.utilities.mappers.ModelMapperService;
import baki.rentAcar.dataAccess.abstracts.ModelRepository;
import baki.rentAcar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        //Business
        List<Model> models = modelRepository.findAll();
        List <GetAllModelsResponse> modelsResponse = models.stream().map(model->this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }


}
