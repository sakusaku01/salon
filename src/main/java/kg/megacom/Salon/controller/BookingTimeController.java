package kg.megacom.Salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Salon.model.dtos.BookingTimeDto;
import kg.megacom.Salon.model.request.RequestDto;
import kg.megacom.Salon.services.BookingTimeServices;
import kg.megacom.Salon.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/boo")
@Api(tags = Swagger2Config.Booking)
public class BookingTimeController {
    @Autowired
    private BookingTimeServices booking;

    @PostMapping("/save")
    @ApiOperation("Сохранить записи")
    public ResponseEntity<?> save(@RequestBody BookingTimeDto book) {
        try {
            return ResponseEntity.ok(booking.save(book));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @PostMapping("/save/check")
    @ApiOperation("Запись с проверкой")
    public ResponseEntity<?> save(@RequestBody RequestDto requestDto) {
        try {
            return ResponseEntity.ok(booking.saveCheck(requestDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @PostMapping("/find/master")
    @ApiOperation("Запись у мастеров")
    public ResponseEntity<?> checkMaster(@RequestParam Long masterId) {
        try {
            return ResponseEntity.ok(booking.masterBookingCheck(masterId));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }


    @GetMapping("/get")
    @ApiOperation("Поиск по id")
    public  ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(booking.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/all")
    @ApiOperation("Вывести всех")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(booking.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
