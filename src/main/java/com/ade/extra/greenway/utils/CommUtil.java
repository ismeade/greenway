package com.ade.extra.greenway.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import purejavacomm.CommPortIdentifier;
import purejavacomm.SerialPort;
import purejavacomm.SerialPortEvent;
import purejavacomm.SerialPortEventListener;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * 串口监听器
 * // FC00 6A 0000803F 5ED2 16
 * FC 头部
 * 00 地址
 * 6A表示 功能类型
 * FC005A0000803F 经过CRC校验 产出CRC0 和 CRC1
 * 拼接CRC: FC00 6A 0000803F 5ED2
 * 拼接尾部 16
 * 预警硬件通信协议文档
 * 例：打开预警：FC006A000000103ECA16
 * -FC：前缀
 * -00：地址
 * -6A：功能项[亮光+声音]
 * -00000010 打开
 * -00000000 关闭
 * -00000001-0000000A 范围声音分为10个档位值
 * -3ECA 校验位CRC0CRC1
 * -16 拼接后缀
 */
@Slf4j
public class CommUtil implements SerialPortEventListener {

    public static final String PREFIX_SIX_SPLIT = "FC,00,6A,00,00,00";


    public static String PORT_NAME = "";
    private static final int BIT_RATE = 9600;
    public static final int DATA_BITS = SerialPort.DATABITS_8;
    public static final int STOP_BIT = SerialPort.STOPBITS_1;
    public static final int PARITY_BIT = SerialPort.PARITY_NONE;

    private static SerialPort serialPort;
    private static InputStream in;
    private static OutputStream out;
    private static CommUtil commUtil;

    private CommUtil() {
    }

    public static synchronized CommUtil getInstance() {
        if (commUtil == null) {
            commUtil = new CommUtil();
            commUtil.init();
        }
        return commUtil;
    }

    public List<String> findPort() {
        //获得当前所有可用串口
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();

        List<String> portNameList = new ArrayList<>();
        //将可用串口名添加到List并返回该List
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }
        return portNameList;
    }

    public void init() {
        try {
            if (StringUtils.hasText(PORT_NAME)) {
                log.info("init PORT_NAME is :{}", PORT_NAME);
            } else {
                log.error("init PORT_NAME is null");
            }
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(PORT_NAME);
            if (portIdentifier.isCurrentlyOwned()) {
                log.error("Port is currently in use");
            } else if (portIdentifier.getPortType() == 1) {
                serialPort = (SerialPort) portIdentifier.open(PORT_NAME, 1000);
                serialPort.setSerialPortParams(BIT_RATE, DATA_BITS, STOP_BIT, PARITY_BIT);

                in = serialPort.getInputStream();
                out = serialPort.getOutputStream();

                serialPort.addEventListener(this);
                serialPort.notifyOnDataAvailable(true);
            } else {
                log.error("Error: Only serial ports are handled by this example.");
            }
        } catch (Exception e) {
            log.error("init failed", e);
        }
    }

    public void send(String message) {
        try {
            log.info("sendmsg:{}", message);
            byte[] bytes = hexStrToByteArray(message);
            out.write(bytes);
            Thread.sleep(1000);
        } catch (Exception e) {
            log.error("send failed", e);
        }
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.DATA_AVAILABLE:
                receive();
                break;
        }
    }

    public String receive() {
        byte[] buffer = new byte[128];
        int data;
        String result = null;
        try {
            int len = 0;
            while ((data = in.read()) > -1) {
                buffer[len++] = (byte) data;
            }
            byte[] copyValue = new byte[len];
            System.arraycopy(buffer, 0, copyValue, 0, len);
            result = ByteArrayToString(copyValue);
        } catch (Exception e) {
            log.error("receive", e);
        }
        return result;
    }

    public void close() {
        try {
            in.close();
            out.close();
            serialPort.notifyOnDataAvailable(false);
            serialPort.removeEventListener();
            serialPort.close();
        } catch (Exception e) {
            log.error("close", e);
        }
    }

    //16进制转byte数组
    public static byte[] hexStrToByteArray(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++) {
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte) Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }


    public static String ByteArrayToString(byte[] by) {
        StringBuilder str = new StringBuilder();
        for (byte b : by) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            str.append(hex.toUpperCase());
        }
        return str.toString();
    }


    public static void main(String[] args) {
//        String dec2Hex = dec2Hex(9);
//        CommUtil commUtil = CommUtil.getInstance();
//        if (Objects.isNull(commUtil)) {
//            log.error("commUtil is null ");
//            return;
//        }
//        commUtil.send("FC005A0000803F5ED216");
//
//        log.error("commUtil send success ");
//        commUtil.close();
//        System.err.println(dec2Hex);

        byte[] fc005A0000803FS = hexStrToByteArray("FC 00 5A 00 00 00 00 7F 02 16");
        System.out.println(Arrays.toString(fc005A0000803FS));

        int[] data = new int[7];
        data[0] = 252;
        data[1] = 0;
        data[2] = 90;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;
        data[6] = 9;

        System.out.println(Arrays.toString(data));

    }
}