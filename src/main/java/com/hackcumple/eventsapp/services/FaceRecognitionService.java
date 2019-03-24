package com.hackcumple.eventsapp.services;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_UNCHANGED;
import static org.opencv.imgcodecs.Imgcodecs.imdecode;

@Service
public class FaceRecognitionService {

    public byte[] getFaceRecognitionImg(byte[] fileBytes) throws IOException {
        //create OpenCV Mat from byteArray
        Mat src = this.getMatFromImg(fileBytes);
        CascadeClassifier classifier = getCascadeClassifier();

        //Detecting the face in the snap
        MatOfRect faceDetections = new MatOfRect();
        classifier.detectMultiScale(src, faceDetections);

        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(src,       //where to draw the box
                    new Point(rect.x, rect.y),   //bottom left
                    new Point(rect.x + rect.width, rect.y + rect.height),  //top right
                    new Scalar(0, 0, 255),
                    3);    //RGB color
        }

        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(".jpg", src, mob);
        return mob.toArray();
    }

    public int getFacesAmount(byte[] fileBytes) throws UnsupportedEncodingException {
        Mat src = this.getMatFromImg(fileBytes);
        CascadeClassifier classifier = getCascadeClassifier();

        //Detecting the face in the snap
        MatOfRect faceDetections = new MatOfRect();
        classifier.detectMultiScale(src, faceDetections);

        return faceDetections.toArray().length;
    }

    private CascadeClassifier getCascadeClassifier() throws UnsupportedEncodingException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("opencv/lbpcascade_frontalface.xml").getFile());
        return new CascadeClassifier(URLDecoder.decode(file.getAbsolutePath().replace("\\", "/"), "UTF-8"));
    }

    private Mat getMatFromImg(byte[] fileBytes) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //create OpenCV Mat from byteArray
        return imdecode(new MatOfByte(fileBytes), IMREAD_UNCHANGED);
    }
}
