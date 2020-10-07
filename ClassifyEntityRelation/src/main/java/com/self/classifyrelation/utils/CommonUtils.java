package com.self.classifyrelation.utils;

import java.io.FileNotFoundException;
import java.net.URL;

import com.self.classifyrelation.constants.GlobalMessageConstants;

/**
 * Common utility
 * 
 * @author ranjithr
 *
 */
public class CommonUtils {
  public String getQualifiedUrlPath(String fileName) throws FileNotFoundException {
    URL url = getClass().getClassLoader().getResource(fileName);

    if (null == url) {
      throw new FileNotFoundException(
        String.format(GlobalMessageConstants.ERROR_MSG_FILE_NOT_FOUND, fileName));
    }

    return url.getPath();
  }
}
