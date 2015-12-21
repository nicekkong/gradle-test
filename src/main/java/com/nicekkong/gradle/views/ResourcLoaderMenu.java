/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by nicekkong on 2015. 12. 18..
 */

@Component
public class ResourcLoaderMenu {

    @Autowired
    private ResourceLoader resourceLoader;

    public void printMenu(String menuFile) {
        try{
            InputStream stream = resourceLoader.getResource(menuFile).getInputStream();
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
