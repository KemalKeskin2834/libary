package com.kemalkeskin.library.service.abstracts;

import com.kemalkeskin.library.service.dtoS.requests.RentalBookRequest;
import com.kemalkeskin.library.service.dtoS.responses.RentalBookResponse;

import java.util.List;

public interface RentalBookService {

    List<RentalBookResponse>listRentalBooks();

    void rentedBook(RentalBookRequest rentalBookRequest);

    void returnbook(int id);


}
