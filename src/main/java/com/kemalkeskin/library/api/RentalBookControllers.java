
package com.kemalkeskin.library.api;

import com.kemalkeskin.library.service.abstracts.RentalBookService;
import com.kemalkeskin.library.service.dtoS.requests.RentalBookRequest;
import com.kemalkeskin.library.service.dtoS.responses.RentalBookResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/rented")
@RestController
public class RentalBookControllers {

    private RentalBookService rentalBookService;

    @Autowired
    public RentalBookControllers(RentalBookService rentalBookService) {
        this.rentalBookService = rentalBookService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<RentalBookResponse> listRentalBooks(){
        return rentalBookService.listRentalBooks();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void rentedBook(@Valid @RequestBody RentalBookRequest rentalBookRequest){
        this.rentalBookService.rentedBook(rentalBookRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void returnBook(@PathVariable int id){
        this.rentalBookService.returnbook(id);
    }






}
