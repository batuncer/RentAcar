package baki.rentAcar.business.abstracts;


import baki.rentAcar.business.requests.CreateModelRequest;
import baki.rentAcar.business.responces.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
