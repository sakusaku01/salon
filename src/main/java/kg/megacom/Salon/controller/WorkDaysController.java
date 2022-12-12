package kg.megacom.Salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Salon.model.dtos.WorkDaysDto;
import kg.megacom.Salon.model.enums.Days;
import kg.megacom.Salon.model.request.ScheduleRequest;
import kg.megacom.Salon.services.WorkDaysServices;
import kg.megacom.Salon.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/work")
@Api(tags = Swagger2Config.Work)
public class WorkDaysController {

    @Autowired
    private WorkDaysServices workDaysServices;

    @PostMapping("/save")
    @ApiOperation("Сохранить рабочие дни")
    public ResponseEntity<?> save(@RequestBody WorkDaysDto dto) {
        try {
            return ResponseEntity.ok(workDaysServices.save(dto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @PostMapping("create/schedule")
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleRequest request){
        try {
            return ResponseEntity.ok(workDaysServices.createSchedule(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @PostMapping("/find")
    @ApiOperation("Просмотреть график мастеров")
    public ResponseEntity<?> graph(@RequestParam(name = "masterId")Long id) {
        try {
            return ResponseEntity.ok(workDaysServices.findGraph(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @GetMapping("get/schedule/list")
    public ResponseEntity<?> getScheduleList(){
        try {
            return ResponseEntity.ok(workDaysServices.getList());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/get/all")
    @ApiOperation("Вывести всех")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(workDaysServices.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @PutMapping("set/master/schedule")
    public ResponseEntity<?> setSchedule(@RequestParam Long workDayId,@RequestParam Long masterId){
        try {
            return ResponseEntity.ok(workDaysServices.setSchedule(workDayId,masterId));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
