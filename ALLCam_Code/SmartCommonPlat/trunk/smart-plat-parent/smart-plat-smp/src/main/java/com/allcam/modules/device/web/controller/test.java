package com.allcam.modules.device.web.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jodd.util.StringUtil;

import org.apache.axis2.AxisFault;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.allcam.modules.camera.inf.CameraService;
import com.allcam.modules.tree.model.State;
import com.allcam.modules.tree.model.TreeNode;
import com.allcam.modules.tree.util.Tree;
import com.allcam.sys.thirdplat.ivms7800.StringEncrypt;
import com.allcam.sys.thirdplat.ivms7800.Ivms7800Util;
import com.allcam.sys.thirdplat.qlywsu.WsuUtil;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.xml.XmlTools;

public class test {

	@Resource
	CameraService cameraService;

	@SuppressWarnings("null")
	public static void main(String[] args) throws AxisFault, RemoteException {
		 String userName = "admin";
		 String passWord = "Yzc123456";
		 String passWordSHA256 = StringEncrypt.EncryptSHA256(passWord,
		 "UTF-8");
		 String applyTokenST = Ivms7800Util.hikAuthLogin(userName,
		 passWordSHA256);
		 String[] resCodes = new String[]{"30000", "admin", "test"};
		 int resType = 10000;
		 String operCode = "10052";
		 String orgCode = "11010000005000000001";
		 String getAllResourceDetailByOrgResult =
		 Ivms7800Util.getAllResourceDetailByOrg(applyTokenST, resType,
		 operCode,orgCode);
		 Tree tree = new Tree();
		 State state = new State(0, 0, 0);
		 TreeNode root=null;
		 Element element = XmlTools.createRootElement(getAllResourceDetailByOrgResult);
		 NodeList nodelist = element.getElementsByTagName("row");
		 for (int i = 0; i < nodelist.getLength(); i++) {
			 Node node = nodelist.item(i);
			 if(i==0){
				 root=new TreeNode(XmlTools.getAttribute(node, "i_org_id"), "0", XmlTools.getAttribute(node, "c_org_name"), "root", new State(1, 0, 0) );
			 }
			 TreeNode treeNode = new TreeNode(XmlTools.getAttribute(node,
						"c_device_index_code"), XmlTools.getAttribute(node, "i_org_id"),
						XmlTools.getAttribute(node, "c_name"), "device",
						state);

				tree.addNode(treeNode);
		 }
		 String treeJson = tree.getTreeJson(tree, root);
		System.out.println(treeJson);
	}

}
