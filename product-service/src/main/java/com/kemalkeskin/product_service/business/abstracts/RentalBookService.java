package com.kemalkeskin.product_service.business.abstracts;

import com.kemalkeskin.product_service.business.dtoS.requests.RentalBookRequest;
import com.kemalkeskin.product_service.business.dtoS.responses.RentalBookResponse;

import java.util.List;

public interface RentalBookService {

    List<RentalBookResponse>listRentalBooks();

    void rentedBook(RentalBookRequest rentalBookRequest);

    void returnbook(int id);


}
