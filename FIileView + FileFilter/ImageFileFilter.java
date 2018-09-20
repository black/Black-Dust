package com.example.black.lunartest;

import java.io.File;
import java.io.FileFilter;

public class ImageFileFilter implements FileFilter{

    @Override
    public boolean accept(File file) {
        // if we are looking at a directory/file that's not hidden we want to see it so return TRUE
        if (file.isDirectory()) {
            return true;
        }else if (isImageFile(file.getAbsolutePath())) {
            return true;
        }
        return false;
    }

    private boolean isImageFile(String filePath) {
        final String[] extension = new String[] {".jpg", ".png", ".gif",".JPG", ".PNG", ".GIF"};
        for(int i=0;i<extension.length;i++){
            if (filePath.endsWith(extension[i])){
                return true;
            }
        }
        return false;
    }
}
