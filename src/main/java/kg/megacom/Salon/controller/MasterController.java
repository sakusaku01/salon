package kg.megacom.Salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Salon.model.dtos.MasterDto;
import kg.megacom.Salon.services.MasterServices;
import kg.megacom.Salon.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mas")
@Api(tags = Swagger2Config.Master)
public class MasterController {

    @Autowired
    private MasterServices masterServices;

    @PostMapping("/save")
    @ApiOperation("Сохранить мастера")
    public ResponseEntity<?> save(@RequestBody MasterDto masterDto) {
        try {
            return ResponseEntity.ok(masterServices.save(masterDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @PostMapping("/find/by/salon")
    @ApiOperation("Поиск мастера по салонам")
    public ResponseEntity<?> save(@RequestParam(name = "salonId") Long id) {
        try {
            return ResponseEntity.ok(masterServices.findBySalon(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }

    @GetMapping("/get")
    @ApiOperation("Поиск по id")
    public  ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(masterServices.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/all")
    @ApiOperation("Вывести всех")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(masterServices.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
