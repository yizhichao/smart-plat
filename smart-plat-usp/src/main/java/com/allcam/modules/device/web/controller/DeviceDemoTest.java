package com.allcam.modules.device.web.controller;

import java.rmi.RemoteException;


import com.allcam.sys.thirdplat.ivms7800.Ivms7800Util;

public class DeviceDemoTest {
    public void test() throws RemoteException {
        Ivms7800Util.addDevice("admin", "AA", "");
    }
}
