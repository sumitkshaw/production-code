package com.sumitshaww.inventoryservice.controller;


import com.sumitshaww.inventoryservice.response.EventInventoryResponse;
import com.sumitshaww.inventoryservice.response.VenueInventoryResponse;
import com.sumitshaww.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(final InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents() {
        return inventoryService.getAllEvents();
    }

    @GetMapping("/inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryResponse inventoryByVenueId(@PathVariable("venueId") Long venueId) {
        return inventoryService.getVenueInformation(venueId);
    }

    @GetMapping("/inventory/event/{eventId}")
    public @ResponseBody EventInventoryResponse inventoryForEvent(@PathVariable("eventId") Long eventId) {
        return inventoryService.getEventInventory(eventId);
    }

}
