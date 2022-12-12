package kg.megacom.Salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Salon.model.dtos.AccountDto;
import kg.megacom.Salon.services.AccountServices;
import kg.megacom.Salon.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/acc")
@Api(tags = Swagger2Config.Acc)
public class AccountController {

    @Autowired
    private AccountServices accountServices;

    @PostMapping("/save")
    @ApiOperation("Сохранить аккаунт")
    public ResponseEntity<?> save(@RequestBody AccountDto account) {
        try {
            return ResponseEntity.ok(accountServices.save(account));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
    @GetMapping("/get")
    @ApiOperation("Поиск по id")
    public  ResponseEntity<?> findById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(accountServices.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/all")
    @ApiOperation("Вывести всех")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.ok(accountServices.findAll());
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


}
