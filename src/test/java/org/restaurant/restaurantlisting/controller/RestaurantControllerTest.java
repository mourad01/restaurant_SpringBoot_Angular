package org.restaurant.restaurantlisting.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.restaurant.restaurantlisting.dto.RestaurantDTO;
import org.restaurant.restaurantlisting.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RestaurantControllerTest {
    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantService restaurantService;

    @BeforeEach
    public  void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testFetchAllRestaurant(){
        List<RestaurantDTO> mockRestaurants = Arrays.asList(
                new RestaurantDTO(1,"macdo","Beni mellal", "Beni Mellal" ,"https://localadventurer.com/wp-content/uploads/2015/11/moroccan-couscous.jpg", "nannnldjn"),
                new RestaurantDTO(2,"macdo","Beni mellal", "Beni Mellal" ,"https://localadventurer.com/wp-content/uploads/2015/11/moroccan-couscous.jpg", "nannnldjn")
        );
        when(restaurantService.findAllRestaurants()).thenReturn(mockRestaurants);

        ResponseEntity<List<RestaurantDTO>> responce= restaurantController.fetchAllRestaurants();

        assertEquals(HttpStatus.OK, responce.getStatusCode());
        assertEquals(mockRestaurants, responce.getBody());

        verify(restaurantService , times(1)).findAllRestaurants();

    }
}
