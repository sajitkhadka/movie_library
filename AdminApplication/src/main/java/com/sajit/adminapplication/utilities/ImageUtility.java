/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sajit.adminapplication.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.servlet.http.Part;

/**
 *
 * @author Sajit
 */
public class ImageUtility {
    
    public static byte[] ImagePartToByte64(Part filePart) throws IOException{
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            byte[] buffer = new byte[(int)filePart.getSize()];
            filePart.getInputStream().read(buffer,0,buffer.length);
            bytes.write(buffer);
            
            byte[] encoded = Base64.getEncoder().encode(buffer);
            return encoded;
    }
}
