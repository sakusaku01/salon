package kg.megacom.Salon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.megacom.Salon.model.request.EmailRequest;
import kg.megacom.Salon.model.request.RequestDto;
import kg.megacom.Salon.services.EmailSenderServices;
import kg.megacom.Salon.swagger.Swagger2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/em")
@Api(tags = Swagger2Config.Email)
public class EmailController {

    @Autowired
    private EmailSenderServices mail;

    @PostMapping("/code/check")
    @ApiOperation("Подтверждение кода")
    public ResponseEntity<?> save(@RequestBody EmailRequest request) {
        try {
            return ResponseEntity.ok(mail.codeCheck(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }

    }
}
