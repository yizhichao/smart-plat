package com.allcam.modules.device.web.controller;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.allcam.modules.camera.inf.CameraService;
import com.allcam.modules.camera.model.CameraInfo;
import com.allcam.modules.client.inf.ClientService;
import com.allcam.modules.client.model.ClientInfo;
import com.allcam.modules.device.inf.DeviceService;
import com.allcam.modules.device.model.DeviceInfo;
import com.allcam.modules.tree.model.State;
import com.allcam.modules.tree.model.TreeNode;
import com.allcam.modules.tree.util.Tree;
import com.allcam.modules.user.inf.UserService;
import com.allcam.modules.zone.inf.ZoneService;
import com.allcam.modules.zone.model.ZoneInfo;
import com.allcam.pojo.PageBean;
import com.allcam.sys.thirdplat.ivms7800.Ivms7800Util;
import com.allcam.sys.thirdplat.ivms7800.StringEncrypt;
import com.allcam.sys.thirdplat.qlywsu.WsuUtil;
import com.allcam.utils.DateUtils;
import com.allcam.utils.GV;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.JsonResult;
import com.allcam.utils.SysCodeBuilderUtil;
import com.allcam.utils.datatable.AoData;
import com.allcam.utils.datatable.DataTableReturnObject;
import com.allcam.utils.xml.XmlTools;
import com.allcam.web.controller.BaseController;

/***
 * 设备管理
 * 
 * @author XiongJinTeng
 */
@Controller
public class DeviceController extends BaseController {
	@Resource
	CameraService cameraService;

	@Resource
	ZoneService zoneService;

	@Resource
	ClientService clientService;

	/**
	 * 设备管理首页<br />
	 * <p>
	 * 该控制器的作用很明显，展示左树又表的结构
	 * </p>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "device")
	public String index(HttpServletRequest request) {
		// return "deviceIndex";
		return GV.VV(GV.VIEWS, "dev/deviceIndex");
	}

	@ResponseBody
	@RequestMapping(value = "/get")
	public Object get(HttpServletRequest request) {
		// return "deviceIndex";

		return deviceService.get(0);
	}

	@Resource
	private UserService userService;

	@Resource
	private DeviceService deviceService;

	NodeList nodelist;

	@RequestMapping(value = "addDevice", produces = "application/json", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void addDevice(@ModelAttribute final DeviceInfo deviceInfo,
			HttpServletRequest request) throws Exception {
		JsonResult jr = new JsonResult();
		try {
			if (deviceService.insert(deviceInfo) == 1) {
				JsonResult.jsonResult(jr, response, JsonResult.SUCCESS);
			} else {
				JsonResult.jsonResult(jr, response, JsonResult.CUSTOM_ERROR);
			}
		} catch (Exception e) {
			JsonResult.jsonResult(jr, response, JsonResult.CUSTOM_ERROR);
		}
	}

	@RequestMapping(value = "allocate", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String allocate(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("clientId", request.getParameter("clientId"));
		request.setAttribute("zoneId", request.getParameter("zoneId"));
		request.setAttribute("clientName", request.getParameter("clientName"));
		request.setAttribute("zoneName", request.getParameter("zoneName"));

		return GV.VV(GV.VIEWS, "dev/allocateDev");
	}

	@ResponseBody
	@RequestMapping(value = "getDevices.json", method = { RequestMethod.POST })
	public void getDevicesJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		Tree tree = new Tree();
		State state = new State(0, 0, 0);
		TreeNode root = new TreeNode("0", "", "root", "root",
				new State(1, 0, 0));
		PageBean zonePageBean = new PageBean();
		zonePageBean.setPageSize(1000);
		Map<String, Object> zoneMap = new HashMap<String, Object>();
		ZoneInfo zoneInfo = new ZoneInfo();
		zoneMap.put("zoneInfo", zoneInfo);
		zoneMap.put("pageBean", zonePageBean);
		List<ZoneInfo> zoneList = zoneService.queryZoneInfoListByPage(zoneMap);
		for (ZoneInfo zone : zoneList) {
			if (StringUtil.isAllBlank(zone.getParentId())) {
				zone.setParentId("root");
			}
			zone.setCreateDate(zone.getCreateDate().substring(0, 19));
			zone.setLastDate(zone.getLastDate().substring(0, 19));
			TreeNode treeNode = new TreeNode(zone.getZoneId(),
					zone.getParentId(), zone.getZoneName(), "zone", state);
			tree.addNode(treeNode);
		}
		PageBean clientPageBean = new PageBean();
		clientPageBean.setPageSize(1000);
		Map<String, Object> clientMap = new HashMap<String, Object>();
		ClientInfo clientInfo = new ClientInfo();
		clientMap.put("clientInfo", clientInfo);
		clientMap.put("pageBean", clientPageBean);
		List<ClientInfo> clientList = clientService
				.queryClientInfoListByPage(clientMap);
		for (ClientInfo client : clientList) {
			client.setCreateDate(client.getCreateDate().substring(0, 19));
			client.setLastDate(client.getLastDate().substring(0, 19));
			TreeNode treeNode = new TreeNode(client.getClientId(),
					client.getZoneId(), client.getClientName(), "client", state);
			tree.addNode(treeNode);
		}
		String treeJson = tree.getTreeJson(tree, root);
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(treeJson);
	}

	@ResponseBody
	@RequestMapping(value = "getOnlineDevices.json", method = { RequestMethod.GET })
	public void getOnlineDevicesJson(@RequestParam String platType,
			@RequestParam String url, @RequestParam String userName,
			@RequestParam String passWord, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		if (com.allcam.utils.StringUtil.isNull(url)
				|| com.allcam.utils.StringUtil.isNull(platType)
				|| com.allcam.utils.StringUtil.isNull(userName)
				|| com.allcam.utils.StringUtil.isNull(passWord)) {
			JsonResult jr = new JsonResult();
			JsonResult.jsonResult(jr, response, JsonResult.ERROR);
		}
		Tree tree = new Tree();
		State state = new State(0, 0, 0);
		TreeNode root = null;
		if (platType.equals("02")) {
			String scId = "18652021426";
			String input = WsuUtil.getDevList(userName, passWord, scId, url);
			Element element = XmlTools.createRootElement(input);
			nodelist = element.getElementsByTagName("CAMERA");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Node node = nodelist.item(i);
				TreeNode treeNode = new TreeNode(XmlTools.getAttribute(node,
						"Id"), XmlTools.getAttribute(node, "SubjectId"),
						XmlTools.getAttribute(node, "Name"), "device", state);
				tree.addNode(treeNode);
			}
			nodelist = element.getElementsByTagName("SUBJECT_INFO");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Node node = nodelist.item(i);
				if (StringUtil.isAllBlank(XmlTools.getAttribute(node,
						"ParentId"))) {
					root = new TreeNode(
							XmlTools.getAttribute(node, "SubjectId"),
							XmlTools.getAttribute(node, "ParentId"),
							XmlTools.getAttribute(node, "SubjectName"), "root",
							new State(1, 0, 0));
					continue;
				}
				TreeNode treeNode = new TreeNode(XmlTools.getAttribute(node,
						"SubjectId"), XmlTools.getAttribute(node, "ParentId"),
						XmlTools.getAttribute(node, "SubjectName"), "zone",
						state);

				tree.addNode(treeNode);

			}
			nodelist = element.getElementsByTagName("CAMERA");// 保存，添加时使用

		}
		if (platType.equals("04")) {

			// String userName = "admin";
			// String passWord = "Yzc123456";
			String passWordSHA256 = StringEncrypt.EncryptSHA256(passWord,
					"UTF-8");
			String applyTokenST = Ivms7800Util.hikAuthLogin(userName,
					passWordSHA256);
			int resType = 10000;
			String operCode = "10052";
			String orgCode = "11010000005000000001";
			String input = Ivms7800Util.getAllResourceDetailByOrg(applyTokenST,
					resType, operCode, orgCode);
			Element element = XmlTools.createRootElement(input);
			nodelist = element.getElementsByTagName("row");
			for (int i = 0; i < nodelist.getLength(); i++) {
				Node node = nodelist.item(i);
				if (i == 0) {
					root = new TreeNode(
							XmlTools.getAttribute(node, "i_org_id"), "0",
							XmlTools.getAttribute(node, "c_org_name"), "root",
							new State(1, 0, 0));
				}
				TreeNode treeNode = new TreeNode(XmlTools.getAttribute(node,
						"c_device_index_code"), XmlTools.getAttribute(node,
						"i_org_id"), XmlTools.getAttribute(node, "c_name"),
						"device", state);

				tree.addNode(treeNode);
			}
		}
		String treeJson = tree.getTreeJson(tree, root);
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(treeJson);
	}

	@ResponseBody
	@RequestMapping(value = "allocateDev", produces = "application/json", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void allocateDev(@RequestBody final DeviceInfo deviceInfo,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JsonResult jr = new JsonResult();
		String platType = deviceInfo.getDevSn();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("zoneId", deviceInfo.getZoneId());
			String[] idList = deviceInfo.getDevId().split(",");
			String[] nameList = deviceInfo.getDevName().split(",");
			if (platType.equals("02")) {

				// List<CameraInfo> cameraList = new ArrayList<CameraInfo>();
				for (int j = 0; j < idList.length; j++) {
					for (int i = 0; i < nodelist.getLength(); i++) {
						Node node = nodelist.item(i);
						if (XmlTools.getAttribute(node, "Id").equals(idList[j])) {
							String total = String.valueOf(deviceService
									.getDeviceTotal(map) + 1);
							total = com.allcam.utils.StringUtil.fillString(
									total, 12, '0');
							deviceInfo.setDevId(SysCodeBuilderUtil
									.devCodeBuilder(SYS_ID,
											ID_CODE_DEVICE_VIDEO + "00",
											ID_CODE_DEVICE_VIDEO + "000101"
													+ total, idList[j]));
							deviceInfo.setDevName(nameList[j]);
							if (deviceService.insert(deviceInfo) <= 0) {
								JsonResult.jsonResult(jr, response,
										JsonResult.ERROR);
							}
							CameraInfo cameraInfo = new CameraInfo(
									deviceInfo.getZoneId(),
									deviceInfo.getDevId(),
									XmlTools.getAttribute(node, "Id"),
									XmlTools.getAttribute(node, "Name"),
									XmlTools.getAttribute(node, "PTZType"),
									XmlTools.getIntAttribute(node, "RunStatus"));
							if (cameraService.insert(cameraInfo) < 0) {
								JsonResult.jsonResult(jr, response,
										JsonResult.ERROR);
							}
							break;
						}

					}
				}
			}
			if (platType.equals("04")) {
				for (int j = 0; j < idList.length; j++) {
					for (int i = 0; i < nodelist.getLength(); i++) {
						Node node = nodelist.item(i);
						if (XmlTools.getAttribute(node, "c_device_index_code")
								.equals(idList[j])) {
							String total = String.valueOf(deviceService
									.getDeviceTotal(map) + 1);
							total = com.allcam.utils.StringUtil.fillString(
									total, 12, '0');
							deviceInfo.setDevId(SysCodeBuilderUtil
									.devCodeBuilder(SYS_ID,
											ID_CODE_DEVICE_VIDEO + "00",
											ID_CODE_DEVICE_VIDEO + "000101"
													+ total, idList[j]));
							deviceInfo.setDevName(nameList[j]);

							if (deviceService.insert(deviceInfo) <= 0) {
								JsonResult.jsonResult(jr, response,
										JsonResult.ERROR);
							}
							CameraInfo cameraInfo = new CameraInfo(
									deviceInfo.getZoneId(),
									deviceInfo.getDevId(),
									idList[j],
									nameList[j],
									XmlTools.getAttribute(node, "i_camera_type"),
									XmlTools.getIntAttribute(node, "i_status"));
							if (cameraService.insert(cameraInfo) < 0) {
								JsonResult.jsonResult(jr, response,
										JsonResult.ERROR);
							}
							break;
						}

					}
				}
			}
			JsonResult.jsonResult(jr, response, JsonResult.SUCCESS);
		} catch (Exception e) {
			JsonResult.jsonResult(jr, response, JsonResult.ERROR);
		}
	}

	@ResponseBody
	@RequestMapping(value = "getClientDevList.json", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String getClientDevList(@RequestParam String aoData, String sEcho)
			throws Exception {
		// String
		// st="[{\"name\":\"sEcho\",\"value\":1},{\"name\":\"iColumns\",\"value\":6},{\"name\":\"sColumns\",\"value\":\"devName,devType,status,createTime,upStringTime,\"},{\"name\":\"iDisplayStart\",\"value\":0},{\"name\":\"iDisplayLength\",\"value\":10},{\"name\":\"mDataProp_0\",\"value\":0},{\"name\":\"sSearch_0\",\"value\":\"\"},{\"name\":\"bRegex_0\",\"value\":false},{\"name\":\"bSearchable_0\",\"value\":true},{\"name\":\"bSortable_0\",\"value\":true},{\"name\":\"mDataProp_1\",\"value\":1},{\"name\":\"sSearch_1\",\"value\":\"\"},{\"name\":\"bRegex_1\",\"value\":false},{\"name\":\"bSearchable_1\",\"value\":true},{\"name\":\"bSortable_1\",\"value\":true},{\"name\":\"mDataProp_2\",\"value\":2},{\"name\":\"sSearch_2\",\"value\":\"\"},{\"name\":\"bRegex_2\",\"value\":false},{\"name\":\"bSearchable_2\",\"value\":true},{\"name\":\"bSortable_2\",\"value\":true},{\"name\":\"mDataProp_3\",\"value\":3},{\"name\":\"sSearch_3\",\"value\":\"\"},{\"name\":\"bRegex_3\",\"value\":false},{\"name\":\"bSearchable_3\",\"value\":true},{\"name\":\"bSortable_3\",\"value\":true},{\"name\":\"mDataProp_4\",\"value\":4},{\"name\":\"sSearch_4\",\"value\":\"\"},{\"name\":\"bRegex_4\",\"value\":false},{\"name\":\"bSearchable_4\",\"value\":true},{\"name\":\"bSortable_4\",\"value\":true},{\"name\":\"mDataProp_5\",\"value\":5},{\"name\":\"sSearch_5\",\"value\":\"\"},{\"name\":\"bRegex_5\",\"value\":false},{\"name\":\"bSearchable_5\",\"value\":true},{\"name\":\"bSortable_5\",\"value\":true},{\"name\":\"sSearch\",\"value\":\"\"},{\"name\":\"bRegex\",\"value\":false},{\"name\":\"iSortCol_0\",\"value\":0},{\"name\":\"sSortDir_0\",\"value\":\"asc\"},{\"name\":\"iSortingCols\",\"value\":1},{\"name\":\"sClientId\",\"value\":\"15415\"}]";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aoData", new AoData(aoData.replace("&quot;", "\"")));
		List<DeviceInfo> list = deviceService.queryDeviceInfoList(map);
		int size = list.size();
		String[][] data = new String[size][];
		for (int i = 0; i < size; i++) {
			DeviceInfo info = list.get(i);
			info.setCreateTime(info.getCreateTime().substring(0, 19));
			info.setupdateTime(info.getupdateTime().substring(0, 19));
			data[i] = info.values();
		}
		return JSonUtils.toJSon(new DataTableReturnObject(size, size, sEcho,
				data));
	}

	@ResponseBody
	@RequestMapping(value = "delDevice.json", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void delDeviceJson(@RequestParam String devId,
			HttpServletResponse response) throws Exception {

		JsonResult jr = new JsonResult();
		try {
			List<String> ids = Arrays.asList(devId.split(","));
			if (deviceService.delDeviceInfo(ids) > 0) {
				JsonResult.jsonResult(jr, response, JsonResult.SUCCESS);
			} else {
				JsonResult.jsonResult(jr, response, JsonResult.ERROR);
			}
		} catch (Exception e) {
			JsonResult.jsonResult(jr, response, JsonResult.ERROR);
		}

	}

	

	@RequestMapping(value = "deviceShare")
	public String deviceShare(HttpServletRequest request) {
		// return "deviceIndex";
		return GV.VV(GV.VIEWS, "dev/deviceShare");
	}

	/**
	 * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils
						.escapeHtml4(text.trim()));
			}

			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}

		});
	}
}
