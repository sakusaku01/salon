package kg.megacom.Salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Salon.model.dtos.ClientDto;
import kg.megacom.Salon.services.ClientServices;
import kg.megacom.Salon.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cl")
@Api(tags = Swagger2Config.Client)
public class ClientController {
    @Autowired
    private ClientServices clientServices;

    @PostMapping("/save")
    @ApiOperation("Сохранить клиента")
    public ResponseEntity<?> save(@RequestBody ClientDto clientDto) {
        try {
            return ResponseEntity.ok(clientServices.save(clientDto));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @GetMapping("/get")
    @ApiOperation("Поиск по id")
    public  ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(clientServices.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/all")
    @ApiOperation("Вывести всех")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(clientServices.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}
