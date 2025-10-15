package com.xworkz.hospital.restcontroller;

import com.xworkz.hospital.service.SlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/slot")
@Slf4j
public class SlotRestController {

    @Autowired
    private SlotService slotService;

    @PostMapping("/checkDuplicate")
    public String checkDuplicate(@RequestParam String specialisation,
                                 @RequestParam String fromTime,
                                 @RequestParam String toTime) {
        System.err.println("Slot rest controller called");
        boolean exists = slotService.isDuplicateSlot(specialisation, fromTime, toTime);
        System.err.println(exists);
        return exists ? "exists" : "not_exists";
    }
}
