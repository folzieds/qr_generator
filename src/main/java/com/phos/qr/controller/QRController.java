package com.phos.qr.controller;

import com.google.zxing.WriterException;
import com.phos.qr.apiModels.QrRequestData;
import com.phos.qr.service.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/barcode")
public class QRController {

    @Autowired
    QRCodeGenerator qrCodeGenerator;

    @GetMapping(value = "", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generateQrCode(@RequestBody QrRequestData qrRequestData) throws WriterException {
        // should take a json request
        return ResponseEntity.ok(qrCodeGenerator.generate(qrRequestData));
    }
}
