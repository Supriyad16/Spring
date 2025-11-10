package com.xworkz.hospital.restcontroller;

import com.xworkz.hospital.dto.DoctorDTO;
import com.xworkz.hospital.dto.UpdatedTimeSlotDTO;
import com.xworkz.hospital.service.DoctorService;
import com.xworkz.hospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patientList")
@Slf4j
public class PatientListRestController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;


    @GetMapping("/fetchDoctorList/{specialisation}")
    public String getSpecialisation(@PathVariable String specialisation) {
        log.info("Fetching doctors by specialisation: {}", specialisation);

        List<DoctorDTO> doctor = doctorService.getDoctorsBySpecialisation(specialisation);

        if (doctor.isEmpty()) {
            return "No Doctors Found";
        }

        List<String> matchedDoctor = new ArrayList<>();
        for (DoctorDTO dto : doctor) {
            if (specialisation.equalsIgnoreCase(dto.getSpecialisation())) {
                matchedDoctor.add(dto.getDoctorName() + "|" + dto.getId());
            }
        }

        if (matchedDoctor.isEmpty()) {
            return "No doctors";
        } else {
            log.info("Matched doctors: {}", String.join(",", matchedDoctor));
            return String.join(",", matchedDoctor);
        }
    }


    @GetMapping("/fetchTimeSlotList")
    public ResponseEntity<String> getTimeOfDoctors(@RequestParam int id) {
        List<UpdatedTimeSlotDTO> interval = patientService.getTimeSlot(id);
        if (interval == null || interval.isEmpty()) {
            return ResponseEntity.ok("Not Assigned");
        } else {
            List<String> mappedValues = new ArrayList<>();
            for (UpdatedTimeSlotDTO dto : interval) {
                log.info("{} | {}", dto.getTimeSlot(), dto.getId());
                mappedValues.add(dto.getTimeSlot() + "," + dto.getId());
            }
            return ResponseEntity.ok(String.join("|", mappedValues));
        }
    }
}

