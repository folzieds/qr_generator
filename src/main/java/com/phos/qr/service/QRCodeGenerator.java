package com.phos.qr.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.phos.qr.models.QRImageData;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRCodeGenerator {

    public BufferedImage generate() throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        QRImageData imageData = new QRImageData();

        // Add image data, convert to json and encrypt
        BitMatrix bitMatrix = qrCodeWriter.encode("imageData", BarcodeFormat.QR_CODE,200,200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}