package com.hackcumple.eventsapp.services;

import org.apache.commons.io.IOUtils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_UNCHANGED;
import static org.opencv.imgcodecs.Imgcodecs.imdecode;

@Service
public class FaceRecognitionService {

    public int getFacesAmount() throws IOException {
        //Loading the OpenCV core library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Resource resource = new ClassPathResource("/pictures/audience.jpg");
        InputStream is = resource.getInputStream();

        //create OpenCV Mat from byteArray
        Mat src = imdecode(new MatOfByte(IOUtils.toByteArray(is)), IMREAD_UNCHANGED);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("opencv/lbpcascade_frontalface.xml").getFile());

        CascadeClassifier classifier = new CascadeClassifier(URLDecoder.decode(file.getAbsolutePath().replace("\\", "/"), "UTF-8"));

        //Detecting the face in the snap
        MatOfRect faceDetections = new MatOfRect();
        classifier.detectMultiScale(src, faceDetections);
        return faceDetections.toArray().length;
    }
}
