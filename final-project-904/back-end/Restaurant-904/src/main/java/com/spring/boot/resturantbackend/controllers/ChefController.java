package com.spring.boot.resturantbackend.controllers;

import com.spring.boot.resturantbackend.dto.ChefDto;
import com.spring.boot.resturantbackend.dto.ExceptionDto;
import com.spring.boot.resturantbackend.services.ChefService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(
        name = "Chef Controller",
        description = "get all chefs"
)
@RestController
@RequestMapping("/chefs")
@CrossOrigin("http://localhost:4200")
public class ChefController {
    @Autowired
    private ChefService chefService;
    @Operation(
            summary = "get all chefs",
            description = "all chefs in resturant"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status get all chefs"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @GetMapping("/all-chefs")
    public ResponseEntity<List<ChefDto>> getAllChefs() throws SystemException {
        return ResponseEntity.ok(chefService.getAllChefs());
    }
}
