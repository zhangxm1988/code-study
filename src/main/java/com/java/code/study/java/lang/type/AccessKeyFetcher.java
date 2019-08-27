package com.java.code.study.java.lang.type;

import org.apache.commons.codec.digest.DigestUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取线上报表访问key
 */
public class AccessKeyFetcher {

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH");
    String salt = "2SmYi!5;b.qzEnaH@c{(K:($IZ-_|Z8>gl.\"d1c7kAgq%d>p5>qO8JYY^eILi,L";
    String accessKey = DigestUtils.md5Hex(sdf.format(new Date()) + salt);
//    setSysClipboardText("&accessKey=" + accessKey);
    System.out.println(accessKey);
  }

  private static void setSysClipboardText(String writeMe) {
    StringSelection contents = new StringSelection(writeMe);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(contents, contents);
  }

}
